package net.jspiner.ask.ui.base;

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import java.util.ArrayList

abstract class BaseAdapter<D> : RecyclerView.Adapter<BaseViewHolder<ViewDataBinding, D>>() {

    private val dataList: ArrayList<D> = ArrayList()

    override fun onBindViewHolder(holder: BaseViewHolder<ViewDataBinding, D>, position: Int) {
        holder.setData(dataList[position])
    }

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
