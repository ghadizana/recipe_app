package com.timtiga.recipe_app.model.network

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
data class RecipeResponse(
    @Json(name = "data")
    val meals: List<Meals>? = null,

    @Json(name = "status")
    val status: Boolean? = null
)

@JsonClass(generateAdapter = true)
@Parcelize
data class Meals(
    val strMeal: String,
    val strCategory: String,
    val strArea: String,
    val strInstructions: String,
    val strMealThumb: String,
    val strYoutube: String,
    val strIngredient: Ingredient,
    val strMeasure: Measure,
): Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Ingredient (
    val strIngredient1: String,
    val strIngredient2: String,
    val strIngredient3: String,
    val strIngredient4: String,
    val strIngredient5: String,
    val strIngredient6: String,
    val strIngredient7: String,
    val strIngredient8: String,
    val strIngredient9: String,
): Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Measure (
    val strMeasure1: String,
    val strMeasure2: String,
    val strMeasure3: String,
    val strMeasure4: String,
    val strMeasure5: String,
    val strMeasure6: String,
    val strMeasure7: String,
    val strMeasure8: String,
    val strMeasure9: String,
): Parcelable
