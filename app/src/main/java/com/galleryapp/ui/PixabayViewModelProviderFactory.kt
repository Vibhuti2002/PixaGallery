package com.galleryapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.galleryapp.repository.PixabayRepository

class PixabayViewModelProviderFactory (
    private val pixabayRepository: PixabayRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PixabayViewModel(pixabayRepository) as T
    }
}