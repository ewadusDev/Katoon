package com.ewadus.katoon.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ewadus.katoon.bindImage
import com.ewadus.katoon.network.DevByteNetwork
import com.ewadus.katoon.network.VideoModel
import com.ewadus.katoon.network.VideoResponse
import kotlinx.coroutines.launch


enum class VDOAPIStatus { LOADING, ERROR, DONE }

class HomeViewModel : ViewModel() {


    //    สำรหรับ fun getJSON String from API with Scalars converter libs
    private val _responseText = MutableLiveData<String>()
    val responseText: LiveData<String>
        get() = _responseText

//   //     สำหรับ get response แค่ 1  อัน
//    private val _responseImg = MutableLiveData<VideoModel>()
//    val responseImg: LiveData<VideoModel>
//        get() = _responseImg

    //     สำหรับ get response หลายๆอัน
    private val _responseImgs = MutableLiveData<List<VideoModel>>()
    val responseImgs: LiveData<List<VideoModel>>
        get() = _responseImgs

    // Enum Class Statuses

    private val _status = MutableLiveData<VDOAPIStatus>()
    val status: LiveData<VDOAPIStatus>
        get() = _status

    var refreshData: Boolean = false

     private val _navigateToSelectedVideo = MutableLiveData<VideoModel>()
    val navigateToSelectedVideo: LiveData<VideoModel>
    get() = _navigateToSelectedVideo


    init {
        getVideoProperty()
        pull2Refresh()

    }

    fun pull2Refresh(){
        getVideoProperty()
    }


    private fun getVideoProperty() {
        viewModelScope.launch {
            _status.value = VDOAPIStatus.LOADING
            refreshData = true
            try {
                _responseImgs.value = DevByteNetwork.videoServices.getPlaylist().videos
                Log.i("response", "${DevByteNetwork.videoServices.getPlaylist().videos.size}")
                _status.value = VDOAPIStatus.DONE
                refreshData = false

            } catch (e: Exception) {

                Log.e("failure", "$e.message")
                _status.value = VDOAPIStatus.ERROR
                refreshData = false
            }
        }
    }

    fun displayVideoDetail(videosModel: VideoModel ) {
        _navigateToSelectedVideo.value = videosModel
    }

    fun displayVideoDetailComplete( ) {
        _navigateToSelectedVideo.value = null
    }

}








