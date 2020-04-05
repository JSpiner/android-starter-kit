package net.jspiner.ask.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import io.reactivex.subjects.CompletableSubject

abstract class BaseFragment<Binding : ViewDataBinding, ViewModel : BaseViewModel> : Fragment() {

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun createViewModel(): ViewModel

    protected lateinit var binding: Binding
    protected open val viewModel: ViewModel by lazy { createViewModel() }

    protected val lifecycle: CompletableSubject by lazy { CompletableSubject.create() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            getLayoutId(),
            container,
            false
        ) as Binding
        return binding.root
    }

    protected fun isBindingInitialized() = ::binding.isInitialized

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.onComplete()
    }

    //편의를 위해 non-null 로 처리했지만, destroy 된 상황에서 null 일 가능성이 있음
    override fun getContext(): Context {
        return super.getContext()!!
    }
}