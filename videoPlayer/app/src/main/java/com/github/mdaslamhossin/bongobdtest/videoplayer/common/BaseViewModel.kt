package com.github.mdaslamhossin.bongobdtest.videoplayer.common

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class BaseViewModel @Inject constructor() : ViewModel() {
  protected var compositeDisposable = CompositeDisposable()

  override fun onCleared() {
    compositeDisposable.clear()
    super.onCleared()
  }
}
