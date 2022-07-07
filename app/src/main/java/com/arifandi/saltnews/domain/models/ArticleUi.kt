package com.arifandi.saltnews.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Muh Arifandi on 7,July,2022
 */
@Parcelize
data class ArticleUi(
    val author: String,
    val title: String,
    val description: String,
    val urlToImage: String,
    val publishedAt: String,
    val url: String,
) : Parcelable {
    companion object {
        const val EMPTY_URL = ""
    }
}