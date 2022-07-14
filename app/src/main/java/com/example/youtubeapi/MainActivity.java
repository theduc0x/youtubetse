package com.example.youtubeapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class MainActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {
    private ConstraintLayout clVideo;
    BottomSheetBehavior sheetBehavior;
    YouTubePlayerFragment youTubePlayerFragment;
    Button btResize;
    TextView tvName;
    Button btTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clVideo = findViewById(R.id.cl_video_play);
        sheetBehavior = BottomSheetBehavior.from(clVideo);
        btResize = findViewById(R.id.bt_play);
        btTrans = findViewById(R.id.bt_trans);
        tvName = findViewById(R.id.tv_name);
        btResize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED){
                    playVideo();
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                } else {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        btTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toIntent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(toIntent);
            }
        });

    }

    private void playVideo() {
        youTubePlayerFragment = (YouTubePlayerFragment) getFragmentManager()
                .findFragmentById(R.id.fm_youtube_play_view);
        youTubePlayerFragment.initialize("AIzaSyDMV8e1aPB63Xwgi506dtDyzf6PrlQWCrw", this);

        sheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_DRAGGING:
                        ViewGroup.LayoutParams params = (ViewGroup.LayoutParams )youTubePlayerFragment.getView().getLayoutParams();
                        params.height = 300;
                        params.width = 550;
                        youTubePlayerFragment.getView().setLayoutParams(params);
                        tvName.setText("Bắt cóc con tim");
                        tvName.setVisibility(View.VISIBLE);
                        sheetBehavior.setPeekHeight(300);
                        Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        ViewGroup.LayoutParams paramss = (ViewGroup.LayoutParams )youTubePlayerFragment.getView().getLayoutParams();
                        int width = getResources().getDisplayMetrics().widthPixels;
                        tvName.setVisibility(View.GONE);
                        paramss.height = 600;
                        paramss.width = width;
                        youTubePlayerFragment.getView().setLayoutParams(paramss);
                        Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                        break;
                }
//                Toast.makeText(MainActivity.this, "Thay doi", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        YouTubePlayer.PlayerStyle playerStyle = YouTubePlayer.PlayerStyle.DEFAULT;

        if(!b) {
            youTubePlayer.setPlayerStyle(playerStyle);
            youTubePlayer.loadVideo("Fi4_Ikpg7Yk");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}