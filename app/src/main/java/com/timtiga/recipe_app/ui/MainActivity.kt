package com.timtiga.recipe_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.timtiga.recipe_app.RecipeViewModel
import com.timtiga.recipe_app.adapter.RecipeAdapter
import com.timtiga.recipe_app.databinding.ActivityMainBinding
import com.timtiga.recipe_app.model.network.RecipeResponse
import com.timtiga.recipe_app.model.network.RecipeResponse.meals

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var _recipeViewModel: RecipeViewModel? = null
    private val recipeViewModel get() = _recipeViewModel as RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        _binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showRecyclerList()

        _recipeViewModel = ViewModelProvider(this)[RecipeViewModel::class.java]
        recipeViewModel.listRecipes()
        recipeViewModel.listRecipes.observe(this){
            val mAdapter = RecipeAdapter()
            binding.rvRecipes.apply {
                adapter = mAdapter
        }
    }
    }

    private fun showRecyclerList() {
        binding.rvRecipes.layoutManager = GridLayoutManager(this, 2)
    }


}