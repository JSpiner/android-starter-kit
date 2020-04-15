package net.jspiner.ask.ui.base

import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.subjects.CompletableSubject

abstract class BaseViewModel : ViewModel() {

    protected val lifecycle: CompletableSubject by lazy { CompletableSubject.create() }

    protected val _toast = MutableLiveData<String?>()
    val toast: LiveData<String?> = _toast

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        lifecycle.onComplete()
    }
}