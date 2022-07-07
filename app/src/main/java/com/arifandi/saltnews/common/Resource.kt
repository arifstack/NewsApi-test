package com.arifandi.saltnews.common

/**
 * Created by Muh Arifandi on 7,July,2022
 */
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
) {
    class Success<T>(data: T?) : Resource<T>(data = data)

    class Error<T>(errorMessage: String) : Resource<T>(message = errorMessage)

    class Loading<T>(loadingMessage: String = "Loading..") : Resource<T>(message = loadingMessage)
}