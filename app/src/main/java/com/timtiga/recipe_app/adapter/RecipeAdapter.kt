package com.timtiga.recipe_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.timtiga.recipe_app.R
import com.timtiga.recipe_app.databinding.ItemRecipeBinding
import com.timtiga.recipe_app.model.network.RecipeResponse

class RecipeAdapter(private val data: MutableList<RecipeResponse.meals> = mutableListOf()) : RecyclerView.Adapter<RecipeAdapter.MyViewHolder>() {
    private val listRecipe = ArrayList<RecipeResponse.meals>()
    class MyViewHolder(var binding: ItemRecipeBinding):
            RecyclerView.ViewHolder(binding.root)

    fun setData(list: RecipeResponse.meals) {
        this.data.clear()
        this.data.addAll(listOf(list))
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  MyViewHolder (
        ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
                .resize(2048, 1600)
                .placeholder(R.drawable.ic_splash)
                .into(ivRecipe)
        }

//        holder.itemView.setOnClickListener {
//            val intent = Intent(it.context, DetailActivity::class.java)
//            intent.putExtra(DetailActivity., data)
//            it.context.startActivity(intent)
//        }
    }
}