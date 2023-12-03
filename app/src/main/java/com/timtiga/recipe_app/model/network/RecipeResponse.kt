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

//@JsonClass(generateAdapter = true)
//@Parcelize
//data class Ingredient (
//    val strIngredient1: String,
//    val strIngredient2: String,
//    val strIngredient3: String,
//    val strIngredient4: String,
//    val strIngredient5: String,
//    val strIngredient6: String,
//    val strIngredient7: String,
//    val strIngredient8: String,
//    val strIngredient9: String,
//): Parcelable
//
//@JsonClass(generateAdapter = true)
//@Parcelize
//data class Measure (
//    val strMeasure1: String,
//    val strMeasure2: String,
//    val strMeasure3: String,
//    val strMeasure4: String,
//    val strMeasure5: String,
//    val strMeasure6: String,
//    val strMeasure7: String,
//    val strMeasure8: String,
//    val strMeasure9: String,
//): Parcelable
