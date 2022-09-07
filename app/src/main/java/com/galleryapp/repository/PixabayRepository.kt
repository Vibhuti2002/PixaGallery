package com.galleryapp.repository

import com.galleryapp.api.RetrofitInstance

class PixabayRepository {
/*    suspend fun getLatestImages(order : String) =
        RetrofitInstance.api.getLatestImages(order) */

    suspend fun getLatestImages() =
        RetrofitInstance.api.getLatestImages()

    suspend fun getCategoryImages(category: String) =
        RetrofitInstance.api.getCategoryImages(category)

    suspend fun getColorImages(color: String) =
        RetrofitInstance.api.getColorImages(color)
}