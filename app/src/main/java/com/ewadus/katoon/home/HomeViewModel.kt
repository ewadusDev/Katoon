package com.ewadus.katoon.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ewadus.katoon.network.DevByteNetwork
import com.ewadus.katoon.network.VideoModel
import com.ewadus.katoon.network.VideoResponse
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {


    //    สำรหรับ fun getJSON String from API with Scalars converter libs
    private val _responseText = MutableLiveData<String>()
    val responseText: LiveData<String>
        get() = _responseText


   //     สำหรับ get response แค่ 1  อัน
    private val _responseImg = MutableLiveData<VideoModel>()
    val responseImg: LiveData<VideoModel>
        get() = _responseImg

    //     สำหรับ get response หลายๆอัน
    private val _responseImgs = MutableLiveData<List<VideoModel>>()
    val responseImgs: LiveData<List<VideoModel>>
    get() = _responseImgs


    init {
        getVideoProperty()
    }

    private fun getVideoProperty() {
        viewModelScope.launch {
            try {
                _responseImgs.value = DevByteNetwork.videoServices.getPlaylist().videos
                Log.i("response","${DevByteNetwork.videoServices.getPlaylist().videos.size}")



            }catch (e:Exception) {
                Log.e("failure", "$e.message")

                }


            }
        }

    }








