package com.arifandi.saltnews.ui.news.adapter

import android.widget.TextView
import com.arifandi.saltnews.databinding.ArticlesItemWithoutImageBinding

/**
 * Created by Muh Arifandi on 7,July,2022
 */
class ArticleWithoutImageViewHolder(
    private val binding: ArticlesItemWithoutImageBinding,
) : NewsViewHolder(binding) {

    override fun description(): TextView = binding.description
    override fun headline(): TextView = binding.headline
    override fun author(): TextView = binding.author
    override fun timeDate(): TextView = binding.timeDate
}