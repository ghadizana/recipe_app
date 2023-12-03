package com.timtiga.recipe_app.ui

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.timtiga.recipe_app.databinding.ActivityDetailBinding
import com.timtiga.recipe_app.model.network.MealsItem

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION") var recipeData = when{
            SDK_INT >= 33 -> intent.getParcelableExtra(RECIPE_DATA, MealsItem::class.java)
            else -> intent.getParcelableExtra(RECIPE_DATA)
        }

        binding.apply {
            tvTitleRecipe.text = recipeData?.strMeal
            tvTitleCategory.text = recipeData?.strCategory
            tvTitleArea.text = recipeData?.strArea
            tvTitleIngredients.text = recipeData?.strIngredient1
            tvTitleSteps.text = recipeData?.strInstructions
            Picasso.get().load(recipeData?.strMealThumb).into(ivFood)
        }
    }

    companion object {
        const val RECIPE_DATA = "data"
    }
}