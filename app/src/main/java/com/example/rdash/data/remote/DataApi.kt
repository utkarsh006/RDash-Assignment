package com.example.rdash.data.remote

import com.example.rdash.data.remote.pdfClasses.Pdf
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface DataApi {
    @GET
    suspend fun getPdfs(@Url url: String, @Query("id") id: String): Pdf
}

/* This is a Retrofit Api interface, we basically defines different functions and routes we want to
access from our api */
