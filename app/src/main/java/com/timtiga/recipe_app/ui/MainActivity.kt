package com.timtiga.recipe_app.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.timtiga.recipe_app.R
import com.timtiga.recipe_app.databinding.ActivityMainBinding
import com.timtiga.recipe_app.fragment.RecipeFragment

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        _binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val recipeFragment = RecipeFragment()
        val fragment = fragmentManager.findFragmentByTag(RecipeFragment::class.java.simpleName)

        if (fragment !is RecipeFragment) {
            Log.d(
                "MyFragment",
                "Fragment Name : " + RecipeFragment::class.java.simpleName
            )
            fragmentManager
                .beginTransaction()
                .add(R.id.frame_container, recipeFragment, RecipeFragment::class.java.simpleName)
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}