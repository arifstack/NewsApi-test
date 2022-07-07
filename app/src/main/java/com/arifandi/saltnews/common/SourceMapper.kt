package com.arifandi.saltnews.common

import android.content.Context
import com.arifandi.saltnews.data.model.Source
import com.arifandi.saltnews.domain.models.SourceUi

/**
 * Created by Muh Arifandi on 7,July,2022
 */
class SourceMapper(
    private val context: Context,
) : Mapper<List<Source>, List<SourceUi>> {
    override fun map(source: List<Source>): List<SourceUi> {
        return source.map { article ->
            SourceUi(
                id = article.id,
                name = article.name,
                description = article.description,
                url = article.url,
                category = article.category,
                language = article.language,
                country = article.country
            )
        }
    }
}