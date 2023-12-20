package com.example.rdash.domain.repository

import com.example.rdash.data.remote.pdfClasses.DataDTO

interface DataRepository {
    suspend fun getPdfs(id: String): List<DataDTO>
}