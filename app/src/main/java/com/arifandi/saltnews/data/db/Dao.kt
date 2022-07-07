package com.arifandi.saltnews.data.db

import androidx.room.Insert
import androidx.room.Query
import com.arifandi.saltnews.domain.models.SourceUi

/**
 * Created by Muh Arifandi on 7,July,2022
 */
interface Dao {

    @Insert
    suspend fun writeArticlesToCache(list: List<SourceUi>)

    @Query("SELECT * FROM articles")
    suspend fun getListSource(): List<SourceUi>

    @Query("DELETE FROM articles")
    suspend fun deleteAllSource()
}