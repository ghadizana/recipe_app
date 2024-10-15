package com.timtiga.recipe_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.timtiga.recipe_app.R
import com.timtiga.recipe_app.databinding.ActivityMainBinding
import com.timtiga.recipe_app.fragment.Profile
import com.timtiga.recipe_app.fragment.RecipeFragment

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        _binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(RecipeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.nav_home -> replaceFragment(RecipeFragment())
                R.id.nav_profile -> replaceFragment(Profile())

                else -> {

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransactions = fragmentManager.beginTransaction()
        fragmentTransactions.replace(R.id.frame_container, fragment)
        fragmentTransactions.commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}