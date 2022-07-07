package com.arifandi.saltnews.ui.news.adapter

import android.widget.TextView
import com.arifandi.saltnews.common.ImageSource
import com.arifandi.saltnews.databinding.ArticlesItemWithImageBinding
import com.arifandi.saltnews.domain.models.ArticleUi

/**
 * Created by Muh Arifandi on 7,July,2022
 */
class ArticleWithImageViewHolder(
    private val binding: ArticlesItemWithImageBinding,
) : NewsViewHolder(binding) {

    override fun bindNews(articleUi: ArticleUi) {
        super.bindNews(articleUi)
        ImageSource.NetImageSource(
            radiusRoundedCorner = 12f
        ).show(articleUi.urlToImage, binding.image)

    }

    override fun description(): TextView = binding.description
    override fun headline(): TextView = binding.headline
    override fun author(): TextView = binding.author
    override fun timeDate(): TextView = binding.timeDate
}