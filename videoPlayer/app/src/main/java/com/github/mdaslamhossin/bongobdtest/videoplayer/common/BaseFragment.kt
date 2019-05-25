package com.github.mdaslamhossin.bongobdtest.videoplayer.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProviders
import com.github.mdaslamhossin.bongobdtest.videoplayer.util.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<M : BaseViewModel> : DaggerFragment() {

  private lateinit var viewModel: M

  @Inject
  lateinit var viewModelFactory: ViewModelFactory

  @get:LayoutRes
  protected abstract val layoutResId: Int

  private lateinit var fragmentContainer: View

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(layoutResId, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
    onInitialize(savedInstanceState, viewModel)
  }

  protected abstract fun getViewModel(): Class<M>

  protected abstract fun onInitialize(instance: Bundle?, viewModel: M)
}
