package com.arifandi.saltnews.ui.source.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.arifandi.saltnews.R
import com.arifandi.saltnews.databinding.ItemLayoutSourceBinding
import com.arifandi.saltnews.domain.models.SourceUi
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Muh Arifandi on 7,July,2022
 */
open class SourceAdapter : RecyclerView.Adapter<SourceAdapter.DataViewHolder>(), Filterable {

    var sourceList: ArrayList<SourceUi> = ArrayList()
    var sourceListFiltered: ArrayList<SourceUi> = ArrayList()
    var onClickNewsItem: ((SourceUi) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout_source, parent,
            false
        )
    )

    override fun getItemCount(): Int = sourceListFiltered.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(sourceListFiltered[position])
    }


    inner class DataViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        init {
            item.setOnClickListener {
                onClickNewsItem?.invoke(sourceListFiltered[adapterPosition])
            }
        }

        fun bind(result: SourceUi) {
            val binding = ItemLayoutSourceBinding.bind(itemView)
            binding.apply {
                name.text = result.name
                description.text = result.description
                url.text = result.url
            }
        }
    }

    fun addData(list: List<SourceUi>) {
        sourceList = list as ArrayList<SourceUi>
        sourceListFiltered = sourceList
        notifyDataSetChanged()
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint?.toString() ?: ""
                if (charString.isEmpty()) {
                    sourceListFiltered = sourceList
                } else {
                    val resultList = ArrayList<SourceUi>()
                    for (row in sourceList) {
                        if (row.name?.lowercase(Locale.getDefault())?.contains(constraint.toString()
                                .lowercase(Locale.getDefault()))!!
                        ) {
                            resultList.add(row)
                        }
                    }
                    sourceListFiltered = resultList
                }
                return FilterResults().apply { values = sourceListFiltered }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                sourceListFiltered = if (results?.values == null)
                    ArrayList()
                else
                    results.values as ArrayList<SourceUi>
                notifyDataSetChanged()

            }
        }
    }


}