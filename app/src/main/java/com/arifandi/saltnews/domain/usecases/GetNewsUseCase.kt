package com.arifandi.saltnews.domain.usecases

import com.arifandi.saltnews.common.Categories
import com.arifandi.saltnews.common.Resource
import com.arifandi.saltnews.data.model.NewsDTO
import com.arifandi.saltnews.data.model.SourceDTO
import com.arifandi.saltnews.domain.NewsRepository

/**
 * Created by Muh Arifandi on 7,July,2022
 */
class GetNewsUseCase(private val repository: NewsRepository) {

    suspend fun getSource(category: Categories): Resource<SourceDTO> {
        return repository.getSource(category)
    }

    suspend fun getNews(category: String): Resource<NewsDTO> {
        return repository.getNews(category)
    }
}