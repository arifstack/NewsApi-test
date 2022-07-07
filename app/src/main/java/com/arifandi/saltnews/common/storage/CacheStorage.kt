package com.arifandi.saltnews.common.storage

import com.arifandi.saltnews.domain.models.SourceUi

/**
 * Created by Muh Arifandi on 7,July,2022
 */
interface CacheStorage {

    fun saveListArticles(list: List<SourceUi>)

    fun getListArticles(): List<SourceUi>?

}