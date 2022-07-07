package com.arifandi.saltnews.data.model

/**
 * Created by Muh Arifandi on 7,July,2022
 */
data class Source(
    val id: String,
    val name: String? = null,
    val description: String,
    val url: String? = null,
    val category: String,
    val language: String? = null,
    val country: String
)