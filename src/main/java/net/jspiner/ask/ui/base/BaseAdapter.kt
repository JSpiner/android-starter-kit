package net.jspiner.ask.ui.base;

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import java.util.ArrayList

abstract class BaseAdapter<D> : RecyclerView.Adapter<BaseViewHolder<ViewDataBinding, D>>() {

    private val dataList: ArrayList<D> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewDataBinding, D> {
        return onCreateViewHolderInternal(parent, viewType) as BaseViewHolder<ViewDataBinding, D>
    }

    abstract fun onCreateViewHolderInternal(parent: ViewGroup, viewType: Int): BaseViewHolder<out ViewDataBinding,D>

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun addAll(itemList: ArrayList<D>) {
        val prevSize = dataList.size
        dataList.addAll(itemList)
        notifyItemRangeInserted(prevSize, itemList.size)
    }

    fun clear() {
        dataList.clear()
        notifyDataSetChanged()
    }
}
