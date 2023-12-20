package com.example.rdash.presentation.pdf_list

import com.example.rdash.domain.model.Data

data class PdfListState(
    val isLoading: Boolean = false,
    val data2D: List<Data> = emptyList(),
    val data3D: List<Data> = emptyList(),
    val dataProd: List<Data> = emptyList(),
    val error: String = ""
)
