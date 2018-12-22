package net.jspiner.ask.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import net.jspiner.ask.util.initLazy

abstract class BaseViewHolder<B : ViewDataBinding, D>(parent: ViewGroup, @LayoutRes layoutResId: Int) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)) {

    protected val binding: B by lazy { DataBindingUtil.bind<B>(itemView)!! }
    protected var lastData: D? = null

    init {
        binding.initLazy()
    }

    @CallSuper
    fun setData(data: D) {
        lastData = data
    }

}
