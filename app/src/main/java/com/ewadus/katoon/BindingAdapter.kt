package com.ewadus.katoon

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

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

