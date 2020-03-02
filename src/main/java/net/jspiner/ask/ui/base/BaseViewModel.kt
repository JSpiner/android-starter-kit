package net.jspiner.ask.ui.base

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import io.reactivex.subjects.CompletableSubject

abstract class BaseViewModel: ViewModel() {

    protected val lifecycle: CompletableSubject by lazy { CompletableSubject.create() }

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        lifecycle.onComplete()
    }
}