package com.latifur.youtubeplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.latifur.youtubeplayer.databinding.ActivityMainBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var video_id = "Ps4aVpIESkc"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycle.addObserver(binding.videoPlayer)

        binding.apply {
            videoPlayer.enterFullScreen()
            videoPlayer.toggleFullScreen()

            videoPlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(video_id, 0f)
                }
            })
        }
    }
}