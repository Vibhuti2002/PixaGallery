package com.galleryapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.galleryapp.R
import com.galleryapp.model.Hit
import com.galleryapp.ui.fragments.CategoriesFragment
import javax.security.auth.callback.Callback

class PixabayAdapter(private var imageListner : PixabayAdapter.OnImageClickListener) : RecyclerView.Adapter<PixabayAdapter.ViewHolder>() {


    interface OnImageClickListener{
        fun onImageClick(link : String)
    }

    fun setOnQueClickListener(listener: OnImageClickListener){
        imageListner = listener
    }
    var categoriesData = emptyList<Hit>()
    var categoryList = arrayListOf<String>("https://pixabay.com/get/g61e8c9350555e3ae42943fd968ff5ea33d3744d65f30c4d1bcccadb74b19c66c943298be93c358ff26fa06a7d6dd87bd72e96c091471de44c7c67e04d4cb3ece_640.jpg",
        "https://pixabay.com/get/gff48535fd70bab96bcceb8a3fc0398bad425ffc079701bd82b08a4d5c9873bdf6dd9f1449622a5caa510729c88e125130543ebbcf5a60fe945386d51f13f8d3c_1280.jpg")

//    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val image: ImageView = itemView.findViewById(R.id.ivCategoryItem)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixabayAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentData = categoriesData[position]
        Glide.with(holder.itemView.context).load(currentData.previewURL).into(holder.image);
    }

    override fun getItemCount(): Int {
        return categoriesData.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        val image: ImageView = itemView.findViewById(R.id.ivCategoryItem)
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            val link = categoriesData[position].largeImageURL
            Log.i("PRIYANSHU", "onClick: $link url ")
            if (position!=RecyclerView.NO_POSITION) {
                if (v != null) {
                    imageListner.onImageClick(link)
                }
            }
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<Hit>){
        categoriesData = newList
        notifyDataSetChanged()
    }

}