package com.github.mdaslamhossin.bongobdtest.videoplayer.common

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<M : BaseViewModel> : DaggerAppCompatActivity() {

  private lateinit var viewModel: M

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  @get:LayoutRes
  protected abstract val layoutResId: Int

  @SuppressLint("CheckResult")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setLayout(layoutResId)
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
    onIntialize(savedInstanceState, viewModel)
  }


  private fun setLayout(layoutResID: Int) {
    setContentView(layoutResID)
  }


  protected abstract fun getViewModel(): Class<M>

  protected abstract fun onIntialize(instance: Bundle?, viewModel: M)

}
