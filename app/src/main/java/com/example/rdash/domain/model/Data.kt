package com.example.rdash.domain.model

data class Data(
    val id: String,
    val file: String,
    val name: String,
    val section: String,
    val uploaded_at: String,
    val type: String,
    val version: Int
)