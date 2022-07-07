package com.arifandi.saltnews.data.model

/**
 * Created by Muh Arifandi on 7,July,2022
 */
data class Article(
    val source: SourceNews,
    val author: String? = null,
    val title: String,
    val description: String? = null,
    val url: String,
    val urlToImage: String? = null,
    val publishedAt: String,
    val content: String,
)