package com.ewadus.katoon.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ewadus.katoon.network.VideoModel

class DetailViewModelFactory(
    private val viewModel: VideoModel,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(viewModel, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
