package com.timtiga.recipe_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timtiga.recipe_app.databinding.ItemRecipeBinding
import com.timtiga.recipe_app.model.network.Meals

class RecipeAdapter: RecyclerView.Adapter<RecipeAdapter.MyViewHolder>() {
    private val listRecipe = ArrayList<Meals>()
    class MyViewHolder(var binding: ItemRecipeBinding):
            RecyclerView.ViewHolder(binding.root)

    fun setData(list: List<Meals>?) {
        if (list === null) return
        listRecipe.clear()
        listRecipe.addAll(list)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  MyViewHolder (
        ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = listRecipe.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }
}