package net.jspiner.ask.ui.common

import android.content.Context
import android.os.Bundle
import net.jspiner.ask.R
import net.jspiner.ask.databinding.DialogSimpleConfirmBinding
import net.jspiner.ask.ui.base.BaseDialog

class SimpleConfirmDialog(context: Context) : BaseDialog<DialogSimpleConfirmBinding>(context) {

    override fun getLayoutId() = R.layout.dialog_simple_confirm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.confirm.setOnClickListener { dismiss() }
    }

    fun setTitle(title: String): SimpleConfirmDialog {
        binding.title.text = title
        return this
    }

    fun setContent(content: String): SimpleConfirmDialog {
        binding.content.text = content
        return this
    }
}