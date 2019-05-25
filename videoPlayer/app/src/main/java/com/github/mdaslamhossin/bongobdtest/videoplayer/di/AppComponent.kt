package com.github.mdaslamhossin.bongobdtest.videoplayer.di

import com.github.mdaslamhossin.bongobdtest.videoplayer.VideoApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AndroidSupportInjectionModule::class,
    ActivityModule::class,
    FragmentModule::class,
    AppModule::class]
)
interface AppComponent : AndroidInjector<VideoApp> {

  @Component.Builder
  abstract class Builder : AndroidInjector.Builder<VideoApp>()
}
