package com.github.mdaslamhossin.bongobdtest.videoplayer.di

import android.content.Context
import com.github.mdaslamhossin.bongobdtest.videoplayer.util.scheduler.AndroidSchedulerProvider
import com.github.mdaslamhossin.bongobdtest.videoplayer.VideoApp
import com.github.mdaslamhossin.bongobdtest.videoplayer.util.scheduler.SchedulerProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, NetworkModule::class])
abstract class AppModule {

  @Singleton
  @Binds
  abstract fun provideApplicationContext(context: VideoApp): Context

  @Singleton
  @Binds
  abstract fun provideSchedulerProvider(
    androidSchedulerProvider: AndroidSchedulerProvider
  ): SchedulerProvider

//  @Singleton
//  @Binds
//  abstract fun providePreferenceHelper(preferenceHelper: AppPrefernceHelper): PreferenceHelper

//  @Module
//  companion object {
//
//    @JvmStatic
//    @Provides
//    fun provideSharedPreference(context: Context): SharedPreferences {
//      return context.let {
//        it.getSharedPreferences(it.getString(R.string.preference_file_key), Context.MODE_PRIVATE)
//      }
//    }
//  }
}
