package com.timtiga.recipe_app.model.network

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
data class RecipeResponse(
    @Json(name = "meals")
    val meals: List<MealsItem>? = null,
)

@JsonClass(generateAdapter = true)
@Parcelize
data class MealsItem (
    @Json(name = "strMeal")
    val strMeal: String,

    @Json(name = "strCategory")
    val strCategory: String,

    @Json(name = "strArea")
    val strArea: String,

    @Json(name = "strInstructions")
    val strInstructions: String,

    @Json(name = "strMealThumb")
    val strMealThumb: String,

    @Json(name = "strYoutube")
    val strYoutube: String,

    @Json(name = "strIngredient1")
    val strIngredient1: String,

    @Json(name = "strMeasure1")
    val strMeasure1: String
): Parcelable
