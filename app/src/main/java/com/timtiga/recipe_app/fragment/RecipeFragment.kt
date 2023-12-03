package com.timtiga.recipe_app.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.timtiga.recipe_app.R
import com.timtiga.recipe_app.RecipeViewModel
import com.timtiga.recipe_app.adapter.RecipeAdapter
import com.timtiga.recipe_app.databinding.FragmentRecipeBinding

class RecipeFragment : Fragment() {
    private var _binding: FragmentRecipeBinding? = null
    private val binding get() = _binding as FragmentRecipeBinding

    private var _recipeViewModel: RecipeViewModel? = null
    private val recipeViewModel get() = _recipeViewModel as RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _recipeViewModel = ViewModelProvider(this)[RecipeViewModel::class.java]
        recipeViewModel.listRecipes()
        recipeViewModel.listRecipes.observe(viewLifecycleOwner) {
            val mAdapter = RecipeAdapter()
            mAdapter.setData(it.meals)
            Log.i(
                "Common Fragment",
                "onViewCreated: ${it.meals}"
            )

            binding.rvRecipe.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(view.context)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}