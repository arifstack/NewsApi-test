package com.arifandi.saltnews.ui.news.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.arifandi.saltnews.R
import com.arifandi.saltnews.common.ImageSource
import com.arifandi.saltnews.databinding.ArticlesItemWithImageBinding
import com.arifandi.saltnews.domain.models.ArticleUi
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Muh Arifandi on 7,July,2022
 */
class ArticlesAdapter :  RecyclerView.Adapter<ArticlesAdapter.DataViewHolder>(), Filterable {

    var articleList: ArrayList<ArticleUi> = ArrayList()
    var articleListFiltered: ArrayList<ArticleUi> = ArrayList()
    var onClickNewsItem: ((ArticleUi) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.articles_item_with_image, parent,
            false
        )
    )



    override fun getItemCount(): Int = articleListFiltered.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(articleListFiltered[position])
    }


    inner class DataViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        init {
            item.setOnClickListener {
                onClickNewsItem?.invoke(articleListFiltered[adapterPosition])
            }
        }

        fun bind(result: ArticleUi) {
            val binding = ArticlesItemWithImageBinding.bind(itemView)
            binding.apply {
                author.text = result.author
                headline.text = result.title
                description.text = result.description
                ImageSource.NetImageSource(
                    radiusRoundedCorner = 12f
                ).show(result.urlToImage, binding.image)
            }
        }
    }

    fun addData(list: List<ArticleUi>) {
        articleList = list as ArrayList<ArticleUi>
        articleListFiltered = articleList
        notifyDataSetChanged()
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint?.toString() ?: ""
                if (charString.isEmpty()) {
                    articleListFiltered = articleList
                } else {
                    val resultList = ArrayList<ArticleUi>()
                    for (row in articleList) {
                        if (row.title?.lowercase(Locale.getDefault())?.contains(constraint.toString()
                                .lowercase(Locale.getDefault()))!!
                        ) {
                            resultList.add(row)
                        }
                    }
                    articleListFiltered = resultList
                }
                return FilterResults().apply { values = articleListFiltered }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                articleListFiltered = if (results?.values == null)
                    ArrayList()
                else
                    results.values as ArrayList<ArticleUi>
                notifyDataSetChanged()

            }
        }
    }


}