package com.example.rdash.data.remote.pdfClasses

import com.example.rdash.domain.model.Data

data class DataDTO(
    val comment_count: Int,
    val `file`: String,
    val file_size: Double,
    val id: String,
    val name: String,
    val section: String,
    val status: Int,
    val tags: List<Tag>,
    val type: String,
    val uploaded_at: String,
    val uploaded_by: UploadedBy,
    val version: Int
)

fun DataDTO.toPdf(): Data {
    return Data(
        id = id,
        file = file,
        name = name,
        section = section,
        uploaded_at = uploaded_at,
        type = type,
        version = version,
    )
}
