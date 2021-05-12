package com.ewadus.katoon.detail

import android.app.Application
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ewadus.katoon.network.VideoModel

class DetailViewModel(videoModel: VideoModel, app: Application): AndroidViewModel(app) {

    private val _selectVideo = MutableLiveData<VideoModel>()
    val selectVideo: LiveData<VideoModel>
    get() = _selectVideo

    init {
        _selectVideo.value = videoModel
    }

}