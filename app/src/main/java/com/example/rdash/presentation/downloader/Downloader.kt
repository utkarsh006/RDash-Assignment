package com.example.rdash.presentation.downloader

interface Downloader {
    fun downloadFile(fileUrl: String): Long
}