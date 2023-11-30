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
    class MyViewHolder(var binding: ItemRecipeBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: RecipeResponse.meals) {
            Picasso
                .get()
                .load(item.strMealThumb)
                .resize(2048, 1600)
                .placeholder(R.drawable.ic_splash)
                .into(binding.ivRecipe)
            binding.tvRecipe.text = item.strMeal
            binding.tvCategory.text = item.strCategory
        }
    }

    fun setData(list: MutableList<RecipeResponse.meals>) {
        this.data.clear()
        this.data.addAll(list)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = listRecipe.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listRecipe[position]

        holder.onBind(data)

//        holder.itemView.setOnClickListener {
//            val intent = Intent(it.context, DetailActivity::class.java)
//            intent.putExtra(DetailActivity., data)
//            it.context.startActivity(intent)
//        }
    }
}