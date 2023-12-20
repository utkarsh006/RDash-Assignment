package com.example.rdash.di

import android.content.Context
import com.example.rdash.common.Constants
import com.example.rdash.data.remote.DataApi
import com.example.rdash.data.repository.DataRepoImpl
import com.example.rdash.domain.repository.DataRepository
import com.example.rdash.domain.usecases.GetPdfsUseCase
import com.example.rdash.presentation.downloader.AndroidDownloader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): DataApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DataApi::class.java)
    }

    //This function we would provide to our repository
    @Provides
    @Singleton
    fun provideDataRepository(dataApi: DataApi): DataRepository {
        return DataRepoImpl(dataApi)
    }

    @Provides
    @Singleton
    fun providePdfUseCase(dataRepo : DataRepository) : GetPdfsUseCase {
        return GetPdfsUseCase(dataRepo)
    }

    @Provides
    @Singleton
    fun provideDownloader(@ApplicationContext context: Context): AndroidDownloader {
        return AndroidDownloader(context)
    }
}