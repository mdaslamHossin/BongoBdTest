package com.github.mdaslamhossin.bongobdtest.videoplayer.ui

import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.Observer
import com.github.mdaslamhossin.bongobdtest.videoplayer.R
import com.github.mdaslamhossin.bongobdtest.videoplayer.common.BaseActivity
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<MainViewModel>() {
  override val layoutResId: Int get() = R.layout.activity_main

  override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

  override fun onIntialize(instance: Bundle?, viewModel: MainViewModel) {

    val player: SimpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this, DefaultTrackSelector())
    playerView.player = player
    val dataSourceFactory =
      DefaultDataSourceFactory(this, Util.getUserAgent(this, getString(R.string.app_name)))
    viewModel.getVideoUrl().observe(this, Observer {
      val videoSource = ExtractorMediaSource.Factory(dataSourceFactory)
        .createMediaSource(Uri.parse(it))
      player.prepare(videoSource)
      player.playWhenReady=true
    })

  }

}
