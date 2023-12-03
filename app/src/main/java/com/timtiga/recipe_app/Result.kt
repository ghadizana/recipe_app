package com.timtiga.recipe_app

sealed class ActionResult {
    data class Success<out T>(val data: T): ActionResult()
    data class Error(val exception: Throwable): ActionResult()
}