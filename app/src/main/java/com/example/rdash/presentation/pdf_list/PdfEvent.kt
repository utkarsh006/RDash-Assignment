package com.example.rdash.presentation.pdf_list

sealed class PdfEvent{
    data class PdfListItemClicked(val dataFile: String) : PdfEvent()
}
