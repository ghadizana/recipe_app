package com.timtiga.recipe_app.ui

import android.app.Notification.Action
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.timtiga.recipe_app.RecipeViewModel
import com.timtiga.recipe_app.Result
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
        val mAdapter = RecipeAdapter()

        binding.rvRecipes.setHasFixedSize(true)
        binding.rvRecipes.adapter = mAdapter
        showRecyclerList()

//        _recipeViewModel = ViewModelProvider(this)[RecipeViewModel::class.java]
//        recipeViewModel.listRecipes()
//        recipeViewModel.listRecipes.observe(this){
//            binding.rvRecipes.apply {
//                adapter = mAdapter
//        }

        recipeViewModel.listRecipes.observe(this) {
            when (it) {
                is Result.Success<*> -> {
                    mAdapter.setData(it.data as MutableList<RecipeResponse.meals>)
                }
                is Result.Error -> {
                    Toast.makeText(this, it.exception.message.toString(), Toast.LENGTH_SHORT).show()
                }
                is Result.Loading -> {
                    binding.
                }
            }
    }
    }

    private fun showRecyclerList() {
        binding.rvRecipes.layoutManager = GridLayoutManager(this, 2)
    }


}