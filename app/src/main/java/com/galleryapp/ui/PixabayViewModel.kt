package com.galleryapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galleryapp.model.PixabayResponse
import com.galleryapp.repository.PixabayRepository
import kotlinx.coroutines.launch

class PixabayViewModel(
    private val pixabayRepository: PixabayRepository, category: String, color : String
    ): ViewModel() {



    init {
        getLatestImages()
        getCategoryImages(category)
        getColorImages(color)
    }

     val latestImages = MutableLiveData<PixabayResponse>()
     val categoryImages = MutableLiveData<PixabayResponse>()
     val colorImages = MutableLiveData<PixabayResponse>()
    private fun getLatestImages() = viewModelScope.launch {
        val response = pixabayRepository.getLatestImages()
        Log.i("PixabayViewModel", "getLatestImages: ${response.body()}")
        if (response.isSuccessful){
            Log.i("PixabayViewModel", "getLatestImages: ")
        }
        else{
            Log.i("PixabayViewModel", "no response: ")
        }
        latestImages.postValue(response.body())
    }
    private fun getCategoryImages(category : String) = viewModelScope.launch {
        val response = pixabayRepository.getCategoryImages(category)
        Log.i("PixabayViewModel", "getCategoryImages: ${response.body()}")
        if (response.isSuccessful){
            Log.i("PixabayViewModel", "getCategoryImages: ")
        }
        else{
            Log.i("PixabayViewModel", "no response: ")
        }
        categoryImages.postValue(response.body())
    }
    private fun getColorImages(color : String) = viewModelScope.launch {
        val response = pixabayRepository.getColorImages(color)
        Log.i("PixabayViewModel", "getColorImages: ${response.body()}")
        if (response.isSuccessful){
            Log.i("PixabayViewModel", "getColorImages: ")
        }
        else{
            Log.i("PixabayViewModel", "no response: ")
        }
        colorImages.postValue(response.body())
    }

}
