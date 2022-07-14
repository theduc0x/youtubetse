package com.example.youtubeapi;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSource;

import java.util.ArrayList;

public class VideoAdapter {
    private Context context;
    private ArrayList<PlayVideoList> listVideo;

    class VideoViewHolder extends RecyclerView.ViewHolder {
        StyledPlayerView spvVideo;
        TextView tvVideo;
        ProgressBar pbLoading;
        ExoPlayer exoPlayer;
        MediaSource mediaSource;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            spvVideo = itemView.findViewById(R.id.playerView);
            tvVideo = itemView.findViewById(R.id.tvTitle);
            pbLoading = itemView.findViewById(R.id.pbLoading);

        }
        public void setVideoPath(String url) {
            exoPlayer = new ExoPlayer.Builder(context).build();
            exoPlayer.addListener(new Player.Listener() {
                @Override
                public void onPlayerError(PlaybackException error) {
                    Player.Listener.super.onPlayerError(error);
                    Toast.makeText(context, "Can't play video", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                    Player.Listener.super.onPlayerStateChanged(playWhenReady, playbackState);

                    if (playbackState == Player.STATE_BUFFERING) {
                        pbLoading.setVisibility(View.VISIBLE);
                    } else if (playbackState == Player.STATE_READY) {
                        pbLoading.setVisibility(View.GONE);
                    }
                }
            });

            spvVideo.setPlayer(exoPlayer);
            exoPlayer.seekTo(0);
            exoPlayer.setRepeatMode(Player.REPEAT_MODE_ONE);

            DefaultDataSource.Factory dataSource =
                    new DefaultDataSource.Factory(context);

            mediaSource = ProgressiveMediaSource.Factory(dataSource).createMediaS;




        }
    }
}
