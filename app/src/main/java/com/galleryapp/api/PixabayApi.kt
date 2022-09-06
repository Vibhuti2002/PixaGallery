package com.galleryapp.api

import com.galleryapp.model.PixabayResponse
import com.galleryapp.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("?key=29654407-fa79b1a52b18c688b7bd36128&order=latest")
    suspend fun getLatestImages(): Response<PixabayResponse>


    /*suspend fun getLatestImages(
        @Query("key")
        apiKey : String = API_KEY,
        @Query("order")
        order : String = "latest"
    ): Response<PixabayResponse>*/
}