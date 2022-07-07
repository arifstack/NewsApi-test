package com.arifandi.saltnews.ui.source

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.arifandi.saltnews.common.SourceMapper
import com.arifandi.saltnews.common.Categories
import com.arifandi.saltnews.common.Resource
import com.arifandi.saltnews.data.model.SourceDTO
import com.arifandi.saltnews.domain.models.SourceUi
import com.arifandi.saltnews.domain.usecases.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Muh Arifandi on 7,July,2022
 */
@HiltViewModel
class SourceViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
    private val myApplication: Application,
) : AndroidViewModel(myApplication) {

    private val _articlesList = MutableLiveData<List<SourceUi>>()
    val articlesList: LiveData<List<SourceUi>> = _articlesList

    private val _status = MutableLiveData<Resource<SourceDTO>>()
    val status: LiveData<Resource<SourceDTO>> = _status

    private var currentCategory = Categories.general

    init {
        loadNews()
    }

    fun changeCategory(newCategory: Categories) {
        currentCategory = newCategory
        loadNews()
    }

    fun loadNews() = viewModelScope.launch {

        _status.value = Resource.Loading()

        val news = getNewsUseCase.getSource(currentCategory)

        _status.value = news

        if (news is Resource.Success) {
            val articlesUi =
                SourceMapper(myApplication.applicationContext).map(news.data!!.sources)
            _articlesList.postValue(articlesUi)
        }
    }
}