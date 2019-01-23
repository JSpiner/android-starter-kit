package net.jspiner.ask.ui.base

import android.databinding.ViewDataBinding

abstract class PagerFragment<Binding : ViewDataBinding, ViewModel : BaseViewModel> :
    BaseFragment<Binding, ViewModel>() {

    abstract fun onCurrentPageSelected()
    abstract fun onCurrentPageUnselected()

}