package com.ewadus.katoon.network

data class  VideoResponse (val videos: List<VideoModel>)

data class VideoModel(
    val title: String,
    val description: String,
    val url: String,
    val updated: String,
    val thumbnail: String,
)

