package com.timtiga.recipe_app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.timtiga.recipe_app.adapter.RecipeAdapter
import com.timtiga.recipe_app.databinding.ActivityMainBinding

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

        _recipeViewModel = ViewModelProvider(this)[RecipeViewModel::class.java]
        recipeViewModel.listRecipes()
        recipeViewModel.listRecipes.observe(viewLifecycleOwner){
            val mAdapter = RecipeAdapter()
            mAdapter.setData(it.meals)
            binding.rvRecipes.apply {
                adapter = mAdapter
                layoutManager = GridLayoutManager(this@MainActivity,2)
        }
    }
    }


}