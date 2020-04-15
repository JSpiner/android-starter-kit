package net.jspiner.ask.util

import android.graphics.drawable.Drawable
import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("src")
    fun setImageSrc(view: ImageView, image: Drawable) {
        view.setImageDrawable(image)
    }

    @JvmStatic
    @BindingAdapter("setText")
    fun setText(editText: EditText, text: String?) {
        if (editText.text.toString() != text) {
            editText.setText(text)
            if (editText.isFocused) {
                editText.setSelection(editText.text.length)
            }
        }
    }
}