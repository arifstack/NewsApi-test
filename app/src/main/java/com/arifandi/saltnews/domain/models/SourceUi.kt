package com.arifandi.saltnews.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Muh Arifandi on 7,July,2022
 */
@Parcelize
data class SourceUi(
    val id: String?=null,
    val name: String? = null,
    val description: String?=null,
    val url: String? = null,
    val category: String?=null,
    val language: String? = null,
    val country: String?=null
) : Parcelable {
    companion object {
        const val EMPTY_URL = ""
    }
}