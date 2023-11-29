package com.timtiga.recipe_app.model.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Url

object ApiClient {
    fun provideApiService() : RecipeApiService {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor {
                val newRequest = it.request().newBuilder()
                    .build()
                it.proceed(newRequest)
            }
            .build()

        return Retrofit.Builder()
            .baseUrl("www.themealdb.com/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(RecipeApiService::class.java)
    }
}