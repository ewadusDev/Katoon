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

//    //     สำหรับ get response หลายๆอัน
//    private val _responseImgs = MutableLiveData<VideoResponse>()
//    val responseImgs: LiveData<VideoResponse>
//    get() = _responseImgs


    init {
        getVideoProperty()
    }

    private fun getVideoProperty() {
        viewModelScope.launch {
            try {
                val listResult = DevByteNetwork.videoServices.getPlaylist()
                Log.i("response","${listResult.body()?.videos?.get(1)?.thumbnail.toString()}")
                _responseText.value = listResult.body()?.videos?.get(1)?.thumbnail




            }catch (e:Exception) {
                Log.e("failure", "$e.message")

                }


            }
        }

    }








