package com.ewadus.katoon.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class  VideoResponse (val videos: List<VideoModel>)
@Parcelize
data class VideoModel(
    val title: String,
    val description: String,
    val url: String,
    val updated: String,
    val thumbnail: String,
): Parcelable {

}

