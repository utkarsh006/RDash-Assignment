package com.example.rdash.domain.usecases

import com.example.rdash.common.Resource
import com.example.rdash.data.remote.pdfClasses.toPdf
import com.example.rdash.domain.model.Data
import com.example.rdash.domain.repository.DataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetPdfsUseCase @Inject constructor(
    private val repository: DataRepository,
) {
    private var id: String ?= null

    fun setPdfID(id:String){
        this.id = id
    }

    operator fun invoke(): Flow<Resource<List<Data>>> = flow {
        try {
            emit(Resource.Loading())
            val pdfs = repository.getPdfs(id!!).map { it.toPdf() }
            emit(Resource.Success(pdfs))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error Occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach Server"))
        }
    }
}