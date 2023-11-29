package com.timtiga.recipe_app

import android.os.Build
import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.squareup.picasso.Picasso
import com.timtiga.recipe_app.databinding.ActivityDetailBinding
import com.timtiga.recipe_app.model.network.Meals

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = null
        }

        setContentView(binding.root)

        @Suppress("DEPRECATION") var recipeData = when {
            SDK_INT >= 33 -> intent.getParcelableExtra(LIST_RECIPE, Meals::class.java)
            else -> intent.getParcelableExtra(LIST_RECIPE)
        }

        binding.apply {
            tvTitleRecipe.text = recipeData?.strMeal
            tvTitleCategory.text = recipeData?.strCategory
            tvTitleArea.text = recipeData?.strArea
            tvTitleSteps.text = recipeData?.strInstructions
            Picasso.get().load(recipeData?.strMealThumb).into(ivFood)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val LIST_RECIPE = "data"
    }
}