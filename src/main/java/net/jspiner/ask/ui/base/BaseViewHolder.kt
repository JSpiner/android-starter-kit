package net.jspiner.ask.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import net.jspiner.ask.util.initLazy

abstract class BaseViewHolder<Binding : ViewDataBinding, Data>(parent: ViewGroup, @LayoutRes layoutResId: Int) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)) {

    protected val binding: Binding by lazy { DataBindingUtil.bind<Binding>(itemView)!! }
    protected var lastData: Data? = null

    init {
        binding.initLazy()
    }

    @CallSuper
    open fun setData(data: Data) {
        lastData = data
    }

}
