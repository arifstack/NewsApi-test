package com.arifandi.saltnews.ui.source.adapter.source

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.arifandi.saltnews.databinding.ItemLayoutSourceBinding
import com.arifandi.saltnews.domain.models.SourceUi

/**
 * Created by Muh Arifandi on 7,July,2022
 */
class SourceAdapter : ListAdapter<SourceUi, BaseViewHolder>(SourceDiffUtil()) {

    var onClickNewsItem: ((SourceUi) -> Unit)? = null

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener() {
            onClickNewsItem?.invoke(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return SourceViewHolder(
            ItemLayoutSourceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    companion object {
        private const val ARTICLE_WITH_IMAGE = 1
        private const val ARTICLE_WITHOUT_IMAGE = 0
        private const val EMPTY_URL = ""
    }


}