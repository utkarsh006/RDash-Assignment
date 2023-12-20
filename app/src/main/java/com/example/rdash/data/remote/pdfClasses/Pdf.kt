package com.example.rdash.data.remote.pdfClasses

data class Pdf(
    val code: Int,
    val `data`: List<DataDTO>,
    val errors: Any,
    val message: String,
    val success: Boolean
)


