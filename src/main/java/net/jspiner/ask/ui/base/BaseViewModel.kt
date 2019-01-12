package net.jspiner.ask.ui.base

import android.support.annotation.CallSuper
import io.reactivex.subjects.CompletableSubject

abstract class BaseViewModel {

    protected val lifecycle: CompletableSubject by lazy { CompletableSubject.create() }

    @CallSuper
    open fun onDestroy() {
        lifecycle.onComplete()
    }
}