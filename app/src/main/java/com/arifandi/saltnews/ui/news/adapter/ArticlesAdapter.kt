package com.arifandi.saltnews.ui.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.ListAdapter
import com.arifandi.saltnews.databinding.ArticlesItemWithImageBinding
import com.arifandi.saltnews.databinding.ArticlesItemWithoutImageBinding
import com.arifandi.saltnews.domain.models.ArticleUi
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Muh Arifandi on 7,July,2022
 */
class ArticlesAdapter : ListAdapter<ArticleUi, NewsViewHolder>(ArticleDiffUtil()) {

    var onClickNewsItem: ((ArticleUi) -> Unit)? = null

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindNews(item)
        holder.itemView.setOnClickListener() {
            onClickNewsItem?.invoke(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        when (viewType) {
            ARTICLE_WITHOUT_IMAGE -> return ArticleWithoutImageViewHolder(
                ArticlesItemWithoutImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            ARTICLE_WITH_IMAGE -> return ArticleWithImageViewHolder(
                ArticlesItemWithImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Article type is not found")
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).urlToImage) {
            EMPTY_URL -> ARTICLE_WITHOUT_IMAGE
            else -> ARTICLE_WITH_IMAGE
        }
    }

    companion object {
        private const val ARTICLE_WITH_IMAGE = 1
        private const val ARTICLE_WITHOUT_IMAGE = 0
        private const val EMPTY_URL = ""
    }



}