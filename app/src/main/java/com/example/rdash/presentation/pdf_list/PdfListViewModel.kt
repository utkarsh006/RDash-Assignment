package com.example.rdash.presentation.pdf_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rdash.common.Resource
import com.example.rdash.domain.usecases.GetPdfsUseCase
import com.example.rdash.presentation.downloader.AndroidDownloader
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PdfListViewModel @Inject constructor(
    private val getPdfsUseCase: GetPdfsUseCase,
    private val downloader : AndroidDownloader
) : ViewModel() {
    private val _state = mutableStateOf(PdfListState())
    val state: State<PdfListState> get() = _state // exposing this state to the composables

    init {
        getPdfs("")
    }

    private fun getPdfs(id: String) {
        getPdfsUseCase.setPdfID(id)
        getPdfsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    val data = result.data ?: emptyList()
                    val data2d = data.filter { it.section == "2D" }
                    val data3d = data.filter { it.section == "3D" }
                    val dataProd = data.filter { it.section == "PROD" }

                    _state.value = PdfListState(
                        data2D = data2d,
                        data3D = data3d,
                        dataProd = dataProd
                    )
                }

                is Resource.Error -> {
                    _state.value = PdfListState(error = result.message ?: "Unexpected Error")
                }

                is Resource.Loading -> {
                    _state.value = PdfListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: PdfEvent) {
        viewModelScope.launch {
            try {
                when (event) {
                    is PdfEvent.PdfListItemClicked -> {
                      downloader.downloadFile(event.dataFile)
                    }
                }

            } catch (e: Exception) {
                _state.value = e.message?.let { state.value.copy(error = it) }!!
            }
        }
    }
}
