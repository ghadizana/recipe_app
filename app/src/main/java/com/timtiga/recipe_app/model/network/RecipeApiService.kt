package com.timtiga.recipe_app.model.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApiService {
    // list recipe
    @GET("/api/json/v1/1/search.php")
    fun getListRecipes(
        @Query("f") q: String = "a"
    ): Call<RecipeResponse>

    // detail meal
//    @GET("/api/json/v1/1/lookup.php?i=52772")
}