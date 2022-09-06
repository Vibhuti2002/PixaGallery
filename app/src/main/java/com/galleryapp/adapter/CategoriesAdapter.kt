package com.galleryapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.galleryapp.R
import com.galleryapp.model.Hit
import com.galleryapp.ui.fragments.CategoriesFragment

class CategoriesAdapter() : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    var categoriesData = emptyList<Hit>()
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.ivCategoryItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)
        return CategoriesAdapter.ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentData = categoriesData[position]
        Glide.with(holder.itemView.context).load(currentData.previewURL).into(holder.image);
    }

    override fun getItemCount(): Int {
        return categoriesData.size
    }

    fun setData(newList: List<Hit>){
        categoriesData = newList
        notifyDataSetChanged()
    }

}