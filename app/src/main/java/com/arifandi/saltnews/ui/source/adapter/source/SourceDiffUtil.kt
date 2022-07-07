package com.arifandi.saltnews.ui.source.adapter.source

import androidx.recyclerview.widget.DiffUtil
import com.arifandi.saltnews.domain.models.SourceUi

/**
 * Created by Muh Arifandi on 7,July,2022
 */
class SourceDiffUtil : DiffUtil.ItemCallback<SourceUi>() {
    override fun areItemsTheSame(oldItem: SourceUi, newItem: SourceUi): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SourceUi, newItem: SourceUi): Boolean {
        return oldItem == newItem
    }
}