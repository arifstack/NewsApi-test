package com.arifandi.saltnews.common

import com.arifandi.saltnews.domain.models.ArticleUi
import com.arifandi.saltnews.domain.models.SourceUi

/**
 * Created by Muh Arifandi on 7,July,2022
 */
interface ItemBind {
    fun bind(articleUi: SourceUi){}
    fun bindNews(articleUi: ArticleUi){}
}