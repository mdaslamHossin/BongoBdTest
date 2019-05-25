package com.github.mdaslamhossin.bongobdtest.videoplayer.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.mdaslamhossin.bongobdtest.videoplayer.common.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {
  private val videoUrlLiveData: MutableLiveData<String> = MutableLiveData()

  fun getVideoUrl(): LiveData<String> {
    videoUrlLiveData.value =
      "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
    return videoUrlLiveData
  }
}
