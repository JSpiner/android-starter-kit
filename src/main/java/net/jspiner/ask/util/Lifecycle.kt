package net.jspiner.ask.util

import android.annotation.SuppressLint
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.CompletableSubject

@SuppressLint("CheckResult")
fun Disposable.bindLifecycle(lifecycleSubject: CompletableSubject) {
    lifecycleSubject.subscribe {
        if (isDisposed.not()) dispose()
    }
}