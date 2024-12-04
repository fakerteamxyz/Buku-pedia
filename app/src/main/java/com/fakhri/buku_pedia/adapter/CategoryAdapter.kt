package com.fakhri.buku_pedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fakhri.buku_pedia.models.Category
import com.fakhri.buku_pedia.R

class CategoryAdapter(
    private val categories: List<Category>
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int = categories.size

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val categoryImage: ImageView = itemView.findViewById(R.id.category_image)
        private val categoryName: TextView = itemView.findViewById(R.id.category_name)

        fun bind(category: Category) {
            categoryImage.setImageResource(category.imageResId)
            categoryName.text = category.name
        }
    }
}