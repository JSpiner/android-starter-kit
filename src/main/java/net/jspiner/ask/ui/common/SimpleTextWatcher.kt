package net.jspiner.ask.ui.common

import android.text.Editable
import android.text.TextWatcher

open class SimpleTextWatcher : TextWatcher{
    override fun afterTextChanged(p0: Editable?) {
        // no-op
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        // no-op
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        // no-op
    }
}