package com.example.rdash.data.repository

import com.example.rdash.data.remote.DataApi
import com.example.rdash.domain.repository.DataRepository
import com.example.rdash.data.remote.pdfClasses.DataDTO
import javax.inject.Inject

class DataRepoImpl @Inject constructor(
    private val api: DataApi
) : DataRepository {

    override suspend fun getPdfs(id: String): List<DataDTO> {
        val response = api.getPdfs("https://n8n.rdash.io/webhook/223a7fe0-4e32-4414-aacf-1bc0ab1c0bba",id)
        // Log.d("MyTag", response.toString())
        return response.data
    }
}
