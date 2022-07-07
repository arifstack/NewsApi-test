package com.arifandi.saltnews.data.api

import com.arifandi.saltnews.BuildConfig.API_SECRET
import com.arifandi.saltnews.common.Categories
import com.arifandi.saltnews.data.model.NewsDTO
import com.arifandi.saltnews.data.model.SourceDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Muh Arifandi on 7,July,2022
 */
interface NewsService {

    @GET("top-headlines/sources?country=us&apiKey=$API_SECRET")
    suspend fun getSource(@Query("category") categories: Categories): Response<SourceDTO>

    @GET("top-headlines?country=us&apiKey=$API_SECRET")
    suspend fun getNews(@Query("category") categories: String): Response<NewsDTO>

    @GET("everything&apiKey=$API_SECRET")
    suspend fun searchSource(@Query("q") categories: String): Response<NewsDTO>

    @GET("everything&apiKey=$API_SECRET")
    suspend fun searchNews(@Query("q") categories: String): Response<NewsDTO>


}