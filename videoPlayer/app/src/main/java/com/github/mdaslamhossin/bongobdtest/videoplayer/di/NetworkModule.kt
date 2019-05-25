package com.github.mdaslamhossin.bongobdtest.videoplayer.di

import com.garbageman.user.di.qualifier.HostApiQualifier
import com.github.mdaslamhossin.bongobdtest.videoplayer.util.scheduler.SchedulerProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [ ApiModule::class])
class NetworkModule {

  companion object {

    const val HEADER_AUTHORIZATION = "Authorization"
    const val HEADER_AUTHORIZATION_PREFIX = "Bearer "
    const val HEADER_AUTHORIZATION_VALUE =
      "Bearer eyJraWQiOiJJTmlWRWc1ZHFuR2N1WTJpbURUUVwvS3pPVEV4aU5NSzFPbEZcLzdocFFMRGc9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiIwYTk3ODQ5YS1kZjNhLTQyYTAtYjYxYS0wNTQ5NzMwYzlkM2EiLCJldmVudF9pZCI6IjNhNjE2OTZlLTdhZTYtMTFlOS05ZjdkLTIxNGZjOGFkZTNhNiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE1NTgzNDY0ODUsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5hcC1zb3V0aGVhc3QtMS5hbWF6b25hd3MuY29tXC9hcC1zb3V0aGVhc3QtMV9BRTNhTHVwZjUiLCJleHAiOjE1NTgzNTAwODUsImlhdCI6MTU1ODM0NjQ4NSwianRpIjoiMWZjNTBjMmEtYmE2NC00ODI2LTgzMmEtM2Y4MjcxODZmZDQ3IiwiY2xpZW50X2lkIjoiN3ZmN3BncGIwdW91cGt1N202bzI5aGVqczgiLCJ1c2VybmFtZSI6IjBhOTc4NDlhLWRmM2EtNDJhMC1iNjFhLTA1NDk3MzBjOWQzYSJ9.h87aXdwnHgOyi9qFkp8vQ2B1AO1DVMmjIvtdYhcPppKkUUjN-uX4Y2hvZsCe8LmSYfXiuhDo_2y1468-pg2eTjOnxfXCbqHVjmp_3UWEAqQDyLj8B9lbDW1kui9dkwjJiTKwCmX8Z3nNMuQ_GaqyKGSb2gD_8LPawQzSoQ8UKF_n5FWKEaErAmCDdlf6M_d94ka4ghmzhpPbxIFa31lCqpY_ounX3WUYM-RcfKXm3a7aukM5sQvi4KG3-7F1BYuFFWkKnlHlGmJrf93s9zvLHZSXrtWYslIYDVZRNbUE3S5jBhTw9ZnwmPbagVUcNuxK8hsihFCSs93-y9vD8JVObA"
    const val HEADER_CONTENT_TYPE = "Content-Type"
    const val HEADER_CONTENT_TYPE_VALUE = "application/json"
    const val CONNECT_TIMEOUT_S: Long = 60
    const val READ_TIMEOUT_S: Long = 60
    const val WRITE_TIMEOUT_S: Long = 60
    private const val NAME_BASE_URL = ""
  }

  @Provides
  @Named(NAME_BASE_URL)
  fun provideBaseUrlString() = NAME_BASE_URL

  @Singleton
  @Provides
  fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
  }

  @Provides
  @Singleton
  fun provideInterceptor(): Interceptor {
    return Interceptor {
      val original = it.request()
      val requestBuilder = original.newBuilder()
      requestBuilder.header(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_VALUE)
//      val tokenResponse: TokenResponse = appPrefernceHelper.loadTokenResponse()
//      requestBuilder.header(
//        HEADER_AUTHORIZATION,
//        HEADER_AUTHORIZATION_PREFIX + tokenResponse.accessToken
//      )
      requestBuilder.header(HEADER_AUTHORIZATION, HEADER_AUTHORIZATION_VALUE)
      val request = requestBuilder.build()
      it.proceed(request)
    }
  }


  @Singleton
  @Provides
  @HostApiQualifier
  fun providesOkHttpClient(
    httpLoggingInterceptor: HttpLoggingInterceptor,
    interceptor: Interceptor
  ): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
    httpClient.followRedirects(true)
    httpClient.followSslRedirects(true)
    httpClient.retryOnConnectionFailure(true)
    httpClient.addInterceptor(interceptor)
    httpClient.addInterceptor(httpLoggingInterceptor)
    httpClient.connectTimeout(CONNECT_TIMEOUT_S, TimeUnit.SECONDS)
    httpClient.readTimeout(READ_TIMEOUT_S, TimeUnit.SECONDS)
    httpClient.writeTimeout(WRITE_TIMEOUT_S, TimeUnit.SECONDS)
    return httpClient.build()
  }

  @Provides
  @Singleton
  fun provideGson(): Gson {
    return GsonBuilder()
      .create()
  }


  @Provides
  @Singleton
  @HostApiQualifier
  fun providesHostApiRetrofit(
    @HostApiQualifier httpClient: OkHttpClient,
    schedulerProvider: SchedulerProvider, gson: Gson, @Named(NAME_BASE_URL) baseUrl: String
  ): Retrofit {

    return Retrofit.Builder().baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create(gson))
      .addCallAdapterFactory(
        RxJava2CallAdapterFactory.createWithScheduler(schedulerProvider.io())
      )
      .client(httpClient)
      .build()
  }
}
