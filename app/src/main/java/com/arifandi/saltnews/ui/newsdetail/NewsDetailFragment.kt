package com.arifandi.saltnews.ui.newsdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.arifandi.saltnews.common.ImageSource
import com.arifandi.saltnews.databinding.FragmentNewsDetailBinding
import com.arifandi.saltnews.domain.models.ArticleUi
import com.arifandi.saltnews.domain.models.SourceUi
import com.arifandi.saltnews.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>() {


    private val imageSource = ImageSource.NetImageSource(radiusRoundedCorner = 12f)

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentNewsDetailBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillData()
    }

    private fun fillData() = with(binding) {
        val args = requireArguments().getParcelable<ArticleUi>(ARTICLE_UI)
            ?: ArticleUi("", "", "", "", "","")
        webView.apply {
            webViewClient = WebViewClient()
            args.url?.let { loadUrl(it) }
        }

    }

    companion object {
        const val ARTICLE_UI = "article_ui"
    }
}