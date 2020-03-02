package net.jspiner.ask.ui.base

import androidx.databinding.ViewDataBinding

abstract class PagerFragment<Binding : ViewDataBinding, ViewModel : BaseViewModel> :
    BaseFragment<Binding, ViewModel>() {

    abstract fun onCurrentPageSelected()
    abstract fun onCurrentPageUnselected()

}