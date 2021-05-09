package com.ewadus.katoon

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ewadus.katoon.home.VDOAPIStatus
import com.ewadus.katoon.network.VideoModel

@BindingAdapter("thumbnail_url")
fun bindImage(imgView: ImageView, imgURL:String?) {
    imgURL?.let {
        val imgUri = imgURL.toUri()
            .buildUpon()
            .scheme("https")
            .build()


        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_download_img)
                    .error(R.drawable.ic_broken_img)
            )
            .into(imgView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<VideoModel>?){
    val adapter = recyclerView.adapter as VdoGridAdapter
    adapter.submitList(data)
}


@BindingAdapter("vdoStatus")
fun bindStatus(statusImg: ImageView, status:VDOAPIStatus) {
    when(status) {
        VDOAPIStatus.LOADING -> {
            statusImg.visibility = View.VISIBLE
            statusImg.setImageResource(R.drawable.ic_download_img)

        }
        VDOAPIStatus.DONE -> {
            statusImg.visibility = View.GONE
        }

        VDOAPIStatus.ERROR -> {
            statusImg.visibility = View.VISIBLE
            statusImg.setImageResource(R.drawable.ic_broken_img)

        }
    }
}



