package net.jspiner.ask.ui.base;

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

abstract class BaseAdapter<D : Diffable> :
    RecyclerView.Adapter<BaseViewHolder<ViewDataBinding, D>>() {

    protected val dataList: ArrayList<D> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ViewDataBinding, D> {
        return onCreateViewHolderInternal(parent, viewType) as BaseViewHolder<ViewDataBinding, D>
    }

    abstract fun onCreateViewHolderInternal(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<out ViewDataBinding, D>

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun update(newList: List<D>) {
        val diffResult = DiffUtil.calculateDiff(BaseDiffCallback(dataList, newList))
        dataList.clear()
        dataList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun addAll(itemList: List<D>) {
        update(dataList.toMutableList().plus(itemList))
    }

    fun clear() {
        update(emptyList())
    }
}
