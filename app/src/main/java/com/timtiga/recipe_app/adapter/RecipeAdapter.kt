package com.timtiga.recipe_app.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.timtiga.recipe_app.R
import com.timtiga.recipe_app.databinding.ItemRecipeBinding
import com.timtiga.recipe_app.model.network.MealsItem
import com.timtiga.recipe_app.ui.DetailActivity

class RecipeAdapter: RecyclerView.Adapter<RecipeAdapter.MyViewHolder>() {
    private val listRecipe = ArrayList<MealsItem>()

    class MyViewHolder(var binding: ItemRecipeBinding): RecyclerView.ViewHolder(binding.root)

    fun setData(list: List<MealsItem>?) {
        if (list == null) return
        listRecipe.clear()
        listRecipe.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ItemRecipeBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
    )

    override fun getItemCount(): Int = listRecipe.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listRecipe[position]

        holder.binding.apply {
            tvRecipe.text = data.strMeal
            tvCategory.text = data.strCategory
            Picasso
                .get()
                .load(data.strMealThumb)
                .placeholder(R.drawable.ic_splash)
                .into(ivRecipe)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.RECIPE_DATA, data)
            it.context.startActivity(intent)
        }
    }
}