package net.jspiner.ask.ui.base

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseDialog<Binding : ViewDataBinding>(context: Context) : AlertDialog(context) {

    @LayoutRes
    abstract fun getLayoutId(): Int

    protected val binding: Binding by lazy {
        DataBindingUtil.inflate(
            layoutInflater,
            getLayoutId(),
            null,
            false
        ) as Binding
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.clearFlags(
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
        )

        setContentView(binding.root)
    }
}