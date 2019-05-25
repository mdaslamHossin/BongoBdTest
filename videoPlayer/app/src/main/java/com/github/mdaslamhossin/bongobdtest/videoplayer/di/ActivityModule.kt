package com.github.mdaslamhossin.bongobdtest.videoplayer.di

import com.github.mdaslamhossin.bongobdtest.videoplayer.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

  @ContributesAndroidInjector
  internal abstract fun contributeMainActivity(): MainActivity

}
