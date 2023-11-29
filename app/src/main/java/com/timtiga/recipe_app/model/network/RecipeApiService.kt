package com.timtiga.recipe_app.model.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApiService {
    // list recipe
    @GET("/api/json/v1/1/search.php?f=a")
    fun getListRecipes(
        @Query("q") q: String = "a",
        @Query("pageSize") pageSize: Int = 50
    ): Call<RecipeResponse>

    // detail meal
//    @GET("/api/json/v1/1/lookup.php?i=52772")
}