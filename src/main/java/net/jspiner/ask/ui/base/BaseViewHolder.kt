package net.jspiner.ask.ui.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import net.jspiner.ask.util.initLazy

abstract class BaseViewHolder<Binding : ViewDataBinding, Data>(parent: ViewGroup, @LayoutRes layoutResId: Int) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)) {

    protected val binding: Binding by lazy { DataBindingUtil.bind<Binding>(itemView)!! }
    protected var lastData: Data? = null
    protected val context by lazy { binding.root.context }

    init {
        binding.initLazy()
    }

    @CallSuper
    open fun setData(data: Data) {
        lastData = data
    }

}
