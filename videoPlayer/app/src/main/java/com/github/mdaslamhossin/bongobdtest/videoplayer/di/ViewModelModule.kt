package com.github.mdaslamhossin.bongobdtest.videoplayer.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.garbageman.user.di.ViewModelKey
import com.github.mdaslamhossin.bongobdtest.videoplayer.util.ViewModelFactory
import com.github.mdaslamhossin.bongobdtest.videoplayer.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
internal abstract class ViewModelModule {

  @Binds
  @IntoMap
  @ViewModelKey(MainViewModel::class)
  abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel


  @Binds
  @Singleton
  internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
