package com.timtiga.recipe_app

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.timtiga.recipe_app.model.network.ApiClient
import com.timtiga.recipe_app.model.network.RecipeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeViewModel: ViewModel() {
    private var _listRecipes = MutableLiveData<RecipeResponse>()
    val listRecipes get() = _listRecipes as LiveData<RecipeResponse>

    fun listRecipes() {
        ApiClient.provideApiService().getListRecipes()
            .enqueue(object : Callback<RecipeResponse> {
                override fun onResponse(
                    call: Call<RecipeResponse>,
                    response: Response<RecipeResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i(
                            "ViewModel",
                            "onResponse: Call success with HTTP status code ${response.body()}"
                        )
                        _listRecipes.postValue(response.body())
                    } else Log.e(
                        "ViewModel",
                        "onFailure"
                    )
                }

                override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                    Log.e(
                        "ViewModel",
                        "onFailure" + t.localizedMessage
                    )
                }
            })
    }
}