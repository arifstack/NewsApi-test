package com.arifandi.saltnews.domain

import com.arifandi.saltnews.common.Categories
import com.arifandi.saltnews.common.Resource
import com.arifandi.saltnews.data.model.NewsDTO
import com.arifandi.saltnews.data.model.SourceDTO

/**
 * Created by Muh Arifandi on 7,July,2022
 */
interface NewsRepository {

    suspend fun getSource(category: Categories): Resource<SourceDTO>

    suspend fun getNews(category: String): Resource<NewsDTO>

}