package net.jspiner.ask.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("src")
    fun setImageSrc(view: ImageView, image: Drawable) {
        view.setImageDrawable(image)
    }
}