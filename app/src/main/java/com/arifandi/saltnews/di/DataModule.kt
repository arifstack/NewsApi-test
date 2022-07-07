package com.arifandi.saltnews.di

import com.arifandi.saltnews.BuildConfig.BASE_URL
import com.arifandi.saltnews.data.api.NewsService
import com.arifandi.saltnews.data.repository.NewsRepositoryImpl
import com.arifandi.saltnews.domain.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Muh Arifandi on 7,July,2022
 */
@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideNewsRepository(newsService: NewsService): NewsRepository {
        return NewsRepositoryImpl(newsService = newsService)
    }

    @Provides
    @Singleton
    fun provideNewsApiService(): NewsService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsService::class.java)
    }

}