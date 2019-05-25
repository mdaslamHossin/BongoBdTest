package com.github.mdaslamhossin.bongobdtest.videoplayer

import com.github.mdaslamhossin.bongobdtest.videoplayer.di.DaggerAppComponent
import com.squareup.leakcanary.LeakCanary
import dagger.android.support.DaggerApplication
import timber.log.Timber

class VideoApp : DaggerApplication() {
  override fun applicationInjector() = DaggerAppComponent.builder().create(this)
  override fun onCreate() {
    super.onCreate()
    if (LeakCanary.isInAnalyzerProcess(this)) {
      // This process is dedicated to LeakCanary for heap analysis.
      // You should not init your app in this process.
      return

    }
    LeakCanary.install(this)
    Timber.plant(Timber.DebugTree())
  }
}
