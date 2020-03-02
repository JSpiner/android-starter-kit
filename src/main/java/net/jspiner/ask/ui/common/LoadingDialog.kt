package net.jspiner.ask.ui.common

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import net.jspiner.ask.R

class LoadingDialog(context: Context) : AlertDialog(context) {

    init {
        setCancelable(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
    }
}