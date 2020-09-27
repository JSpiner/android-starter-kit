package net.jspiner.ask.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import net.jspiner.ask.ui.image.SquircleTransformer

fun ImageView.load(url: String) {
    Glide.with(this)
            .load(url)
            .apply(RequestOptions.centerCropTransform())
            .into(this)
}

fun ImageView.loadSquirclely(url: String) {
    Glide.with(this)
            .load(url)
            .transform(SquircleTransformer())
//            .apply(RequestOptions.centerCropTransform())
            .into(this)
}