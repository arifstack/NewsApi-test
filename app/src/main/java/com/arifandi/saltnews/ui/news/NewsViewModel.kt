package com.arifandi.saltnews.ui.news

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.arifandi.saltnews.common.ArticlesMapper
import com.arifandi.saltnews.common.Resource
import com.arifandi.saltnews.data.model.NewsDTO
import com.arifandi.saltnews.domain.models.ArticleUi
import com.arifandi.saltnews.domain.usecases.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Muh Arifandi on 07,July,2022
 */
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
    private val myApplication: Application,
) : AndroidViewModel(myApplication) {

    private val _articlesList = MutableLiveData<List<ArticleUi>>()
    val articlesList: LiveData<List<ArticleUi>> = _articlesList

    private val _status = MutableLiveData<Resource<NewsDTO>>()
    val status: LiveData<Resource<NewsDTO>> = _status

    private var currentCategory:String=""
    init {
        loadNews()
    }

    fun changeCategory(newCategory: String) {
        currentCategory = newCategory
        loadNews()
    }


    fun loadNews() = viewModelScope.launch {

        _status.value = Resource.Loading()

        val news = getNewsUseCase.getNews(currentCategory)

        _status.value = news

        if (news is Resource.Success) {
            val articlesUi =
                ArticlesMapper(myApplication.applicationContext).map(news.data!!.articles)
            _articlesList.postValue(articlesUi)
        }
    }


}