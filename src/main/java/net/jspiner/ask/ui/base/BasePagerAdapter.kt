package net.jspiner.ask.ui.base

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager

abstract class BasePagerAdapter(pager: ViewPager, fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    protected val fragmentList = createFragmentList()

    init {
        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {
                //no-op
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
                //no-op
            }

            override fun onPageSelected(position: Int) {
                fragmentList[position].onCurrentPageSelected()
                (0 until fragmentList.size)
                    .filter { it != position }
                    .forEach { fragmentList[it].onCurrentPageUnselected() }
            }
        })
    }

    protected abstract fun createFragmentList(): Array<PagerFragment<out ViewDataBinding, out BaseViewModel>>

    override fun getItem(position: Int) = fragmentList[position]

    override fun getCount() = fragmentList.size
}