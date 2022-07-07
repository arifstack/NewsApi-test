package com.arifandi.saltnews.ui.source

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifandi.saltnews.R
import com.arifandi.saltnews.common.Categories
import com.arifandi.saltnews.common.Resource
import com.arifandi.saltnews.databinding.FragmentNewsBinding
import com.arifandi.saltnews.databinding.FragmentSourceBinding
import com.arifandi.saltnews.ui.BaseFragment
import com.arifandi.saltnews.ui.news.NewsFragment
import com.arifandi.saltnews.ui.source.adapter.source.SourceAdapter
import com.arifandi.saltnews.ui.newsdetail.NewsDetailFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SourceFragment : BaseFragment<FragmentSourceBinding>() {

    private val sourceViewModel: SourceViewModel by viewModels()
    private val articlesAdapter = SourceAdapter()

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentSourceBinding.inflate(layoutInflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
        setupChipsListeners()

        binding.general.isChecked = true
    }

    private fun setupRecyclerView() = with(binding) {
        newsList.apply {
            adapter = articlesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        sourceViewModel.articlesList.observe(viewLifecycleOwner) {
            articlesAdapter.submitList(it)
        }
        articlesAdapter.onClickNewsItem = {
            val bundle = Bundle().apply {
                putParcelable(NewsFragment.ARTICLE_UI, it)
            }
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_sourceFragment_to_newsFragment, bundle)
        }

        reloadNews.setOnRefreshListener { sourceViewModel.loadNews() }
    }

    private fun setupObservers() = with(binding) {

        sourceViewModel.status.observe(viewLifecycleOwner) {
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

    private fun setupChipsListeners() = with(binding) {
        business.setOnClickListener() { sourceViewModel.changeCategory(Categories.business) }
        sports.setOnClickListener() { sourceViewModel.changeCategory(Categories.sports) }
        general.setOnClickListener() { sourceViewModel.changeCategory(Categories.general) }
        technology.setOnClickListener() { sourceViewModel.changeCategory(Categories.technology) }
        science.setOnClickListener() { sourceViewModel.changeCategory(Categories.science) }
        health.setOnClickListener() { sourceViewModel.changeCategory(Categories.health) }
        entertainment.setOnClickListener() { sourceViewModel.changeCategory(Categories.entertainment) }
    }


}