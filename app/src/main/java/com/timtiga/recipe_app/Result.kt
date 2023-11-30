package com.timtiga.recipe_app

sealed class Result {
    data class Success<out T>(val data: T): Result()
    data class Error(val exception: Throwable): Result()
    data class Loading(val isLoading: Boolean): Result()
}