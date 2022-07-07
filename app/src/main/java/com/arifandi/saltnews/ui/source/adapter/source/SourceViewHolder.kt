package com.arifandi.saltnews.ui.source.adapter.source

import android.widget.TextView
import com.arifandi.saltnews.databinding.ItemLayoutSourceBinding

/**
 * Created by Muh Arifandi on 7,July,2022
 */
class SourceViewHolder(
    private val binding: ItemLayoutSourceBinding,
) : BaseViewHolder(binding) {

    override fun description(): TextView = binding.description
    override fun name(): TextView = binding.name
    override fun url(): TextView = binding.url
}