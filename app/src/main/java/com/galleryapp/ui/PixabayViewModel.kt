package com.galleryapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galleryapp.model.PixabayResponse
import com.galleryapp.repository.PixabayRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class PixabayViewModel(
    private val pixabayRepository: PixabayRepository
    ): ViewModel() {

    /*init {
        getLatestImages("latest")
    }*/

    init {
        getLatestImages()
    }

     val latestImages = MutableLiveData<PixabayResponse>()
    fun getLatestImages() = viewModelScope.launch {
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
  /*  fun getLatestImages(order : String) = viewModelScope.launch {
        val response = pixabayRepository.getLatestImages(order)
        if (response.isSuccessful){
            Log.i("PixabayViewModel", "getLatestImages: ")
        }
        else{
            Log.i("PixabayViewModel", "no response: ")
        }
        latestImages.postValue(response.body())
    }*/

}
