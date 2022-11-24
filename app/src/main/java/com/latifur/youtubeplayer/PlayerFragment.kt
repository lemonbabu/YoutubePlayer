package com.latifur.youtubeplayer

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.latifur.youtubeplayer.databinding.FragmentPlayerBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener


class PlayerFragment : Fragment(R.layout.fragment_player) {

    private lateinit var binding: FragmentPlayerBinding
    var video_id = "Ps4aVpIESkc"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlayerBinding.bind(view)

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