package com.arifandi.saltnews.common

import android.content.Context
import com.arifandi.saltnews.R
import com.arifandi.saltnews.data.model.Article
import com.arifandi.saltnews.domain.models.ArticleUi
import com.arifandi.saltnews.domain.models.ArticleUi.Companion.EMPTY_URL

/**
 * Created by Muh Arifandi on 7,July,2022
 */
class ArticlesMapper(
    private val context: Context,
) : Mapper<List<Article>, List<ArticleUi>> {
    override fun map(source: List<Article>): List<ArticleUi> {
        return source.map { article ->
            ArticleUi(
                author = article.author ?: context.getString(R.string.with_no_author),
                title = article.title,
                description = article.description
                    ?: context.getString(R.string.with_no_description),
                urlToImage = article.urlToImage ?: EMPTY_URL,
                publishedAt = article.publishedAt,
                url = article.url
            )
        }
    }
}