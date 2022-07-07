package com.arifandi.saltnews.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifandi.saltnews.R
import com.arifandi.saltnews.common.Categories
import com.arifandi.saltnews.common.Resource
import com.arifandi.saltnews.databinding.FragmentNewsBinding
import com.arifandi.saltnews.domain.models.ArticleUi
import com.arifandi.saltnews.domain.models.SourceUi
import com.arifandi.saltnews.ui.BaseFragment
import com.arifandi.saltnews.ui.news.adapter.ArticlesAdapter
import com.arifandi.saltnews.ui.newsdetail.NewsDetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding>() {

    private val newsViewModel: NewsViewModel by viewModels()
    private val articlesAdapter = ArticlesAdapter()
    private var category:String=""

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentNewsBinding.inflate(layoutInflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = requireArguments().getParcelable<SourceUi>(ARTICLE_UI)
            ?: SourceUi("", "", "", "", "","")
        category = args.category.toString()
        newsViewModel.changeCategory(category)
        binding.source.text =getString(R.string.source) + args.name

        setupRecyclerView()
        setupObservers()


    }

    private fun setupRecyclerView() = with(binding) {
        newsList.apply {
            adapter = articlesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        newsViewModel.articlesList.observe(viewLifecycleOwner) {
            articlesAdapter.submitList(it)
        }
        articlesAdapter.onClickNewsItem = {
            val bundle = Bundle().apply {
                putParcelable(NewsDetailFragment.ARTICLE_UI, it)
            }
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_newsFragment_to_newsDetailFragment, bundle)
        }

        reloadNews.setOnRefreshListener { newsViewModel.loadNews() }
    }

    private fun setupObservers() = with(binding) {

        newsViewModel.status.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    reloadNews.isRefreshing = false
                    internetConnectionStatus.isVisible = false
                }
                is Resource.Error -> {
                    internetConnectionStatus.isVisible = true
                    internetConnectionStatus.text = it.message
                }
                is Resource.Loading -> {
                    internetConnectionStatus.isVisible = true
                    internetConnectionStatus.text = it.message
                    reloadNews.isRefreshing = false
                }
            }
            newsList.smoothScrollToPosition(0)
        }
    }



    companion object {
        const val ARTICLE_UI = "article_ui"
    }


}