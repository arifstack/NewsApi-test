package com.arifandi.saltnews.ui.news.adapter

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.arifandi.saltnews.common.ItemBind
import com.arifandi.saltnews.common.Mapper
import com.arifandi.saltnews.domain.models.ArticleUi

/**
 * Created by Muh Arifandi on 7,July,2022
 */

abstract class NewsViewHolder(
    binding: ViewBinding,
) : RecyclerView.ViewHolder(binding.root), ItemBind {

    private val dateTimeMapper = Mapper.DateTimeMapper(context = binding.root.context)

    override fun bindNews(articleUi: ArticleUi) {
        description().text = articleUi.description
        author().text = articleUi.author
        headline().text = articleUi.title
        timeDate().text = dateTimeMapper.map(articleUi.publishedAt)

    }

    abstract fun description(): TextView
    abstract fun headline(): TextView
    abstract fun author(): TextView
    abstract fun timeDate(): TextView
}