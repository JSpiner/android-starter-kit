package net.jspiner.ask.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.load(url: String) {
    Glide.with(this)
        .load(url)
        .apply(RequestOptions.centerCropTransform())
        .into(this)
}