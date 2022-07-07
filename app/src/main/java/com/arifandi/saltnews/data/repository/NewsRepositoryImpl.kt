package com.arifandi.saltnews.data.repository

import com.arifandi.saltnews.common.Categories
import com.arifandi.saltnews.common.Resource
import com.arifandi.saltnews.data.api.NewsService
import com.arifandi.saltnews.data.model.NewsDTO
import com.arifandi.saltnews.data.model.SourceDTO
import com.arifandi.saltnews.domain.NewsRepository

/**
 * Created by Muh Arifandi on 7,July,2022
 */
class NewsRepositoryImpl(private val newsService: NewsService) : BaseRepository(), NewsRepository {

    override suspend fun getSource(category: Categories): Resource<SourceDTO> {
        return safeApiCall { newsService.getSource(category) }
    }

    override suspend fun getNews(category: String): Resource<NewsDTO> {
        return safeApiCall { newsService.getNews(category) }
    }

}