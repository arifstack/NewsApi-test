package com.arifandi.saltnews.ui.newsdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.arifandi.saltnews.databinding.FragmentNewsDetailBinding
import com.arifandi.saltnews.domain.models.ArticleUi
import com.arifandi.saltnews.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>() {
    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentNewsDetailBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = requireArguments().getParcelable<ArticleUi>(ARTICLE_UI)
            ?: ArticleUi("", "", "", "", "","")
        binding.apply {
            webView.apply {
                webViewClient = WebViewClient()
                args.url?.let { loadUrl(it) }
            }
        }

    }

    inner class WebViewClient : android.webkit.WebViewClient() {

        // Load the URL
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }

        // ProgressBar will disappear once page is loaded
        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            binding.SHOWPROGRESS.visibility = View.GONE
        }
    }

    companion object {
        const val ARTICLE_UI = "article_ui"
    }
}

