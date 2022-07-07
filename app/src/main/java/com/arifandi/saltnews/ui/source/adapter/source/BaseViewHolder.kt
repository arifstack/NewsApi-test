package com.arifandi.saltnews.ui.source.adapter.source

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.arifandi.saltnews.common.ItemBind
import com.arifandi.saltnews.domain.models.SourceUi

/**
 * Created by Muh Arifandi on 7,July,2022
 */
abstract class BaseViewHolder(
    binding: ViewBinding,
) : RecyclerView.ViewHolder(binding.root), ItemBind {

    override fun bind(articleUi: SourceUi) {

        description().text = articleUi.description
        name().text = articleUi.name
        url().text = articleUi.url

    }

    abstract fun description(): TextView
    abstract fun name(): TextView
    abstract fun url(): TextView
}