package net.jspiner.ask.ui.base

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import io.reactivex.subjects.CompletableSubject
import net.jspiner.ask.ui.common.LoadingDialog
import net.jspiner.ask.util.initLazy

abstract class BaseActivity<Binding : ViewDataBinding, ViewModel : BaseViewModel> : AppCompatActivity() {

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun createViewModel(): ViewModel
    abstract fun loadState(bundle: Bundle)
    abstract fun saveState(bundle: Bundle)

    val binding: Binding by lazy { DataBindingUtil.setContentView(this, getLayoutId()) as Binding }
    val viewModel: ViewModel by lazy { createViewModel() }

    protected val lifecycle: CompletableSubject by lazy { CompletableSubject.create() }

    private val loadingDialog by lazy { LoadingDialog(this) }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when {
            savedInstanceState != null -> loadState(savedInstanceState)
            intent.extras != null -> loadState(intent.extras!!)
            else -> loadState(Bundle.EMPTY)
        }

        binding.initLazy()
        viewModel.initLazy()

        viewModel.toast.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.onComplete()
    }

    final override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveState(outState)
    }

    fun showStatusBar() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    fun hideStatusBar() {
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    fun showNavigationBar() {
        window.decorView.apply {
            systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }

    fun hideNavigationBar() {
        window.decorView.apply {
            systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }

    fun getStatusBarHeight(): Int {
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(resourceId)
    }

    fun getNavigationBarHeight(): Int {
        val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(resourceId)
    }

    fun setNavigationBarColor(@ColorRes colorRes: Int) {
        window.navigationBarColor = ContextCompat.getColor(this, colorRes)
    }

    fun showLoading() = loadingDialog.show()

    fun hideLoading() = loadingDialog.dismiss()
}