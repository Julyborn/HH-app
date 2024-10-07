package ru.practicum.android.diploma.search.domain.models

sealed interface Resource<T> {
    data class Success<T>(val data: T, val found: Int?, val page: Int?, val pages: Int?) : Resource<T>
    data class ServerError<T>(val message: String) : Resource<T>
    data class NoInternetError<T>(val message: String) : Resource<T>
}
