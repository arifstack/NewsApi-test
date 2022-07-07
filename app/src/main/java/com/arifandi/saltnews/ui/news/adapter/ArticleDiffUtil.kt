package com.arifandi.saltnews.ui.news.adapter

import androidx.recyclerview.widget.DiffUtil
import com.arifandi.saltnews.domain.models.ArticleUi

/**
 * Created by Muh Arifandi on 7,July,2022
 */
class ArticleDiffUtil : DiffUtil.ItemCallback<ArticleUi>() {
    override fun areItemsTheSame(oldItem: ArticleUi, newItem: ArticleUi): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ArticleUi, newItem: ArticleUi): Boolean {
        return oldItem == newItem
    }
}