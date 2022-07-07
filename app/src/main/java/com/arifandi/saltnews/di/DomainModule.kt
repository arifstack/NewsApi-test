package com.arifandi.saltnews.di

import com.arifandi.saltnews.domain.NewsRepository
import com.arifandi.saltnews.domain.usecases.GetNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by Muh Arifandi on 7,July,2022
 */
@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetNewsUseCase(
        newsRepository: NewsRepository,
    ): GetNewsUseCase {
        return GetNewsUseCase(repository = newsRepository)
    }

}

