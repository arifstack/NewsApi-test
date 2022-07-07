package com.arifandi.saltnews.data.model

/**
 * Created by Muh Arifandi on 7,July,2022
 */
data class NewsDTO(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>,
)