package com.example.youtubeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    VideoAdapter adapter;
    ArrayList<PlayVideoList> videos;
    ViewPager2 vp2Video;
    ArrayList<ExoPlayerItem> listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        vp2Video = findViewById(R.id.vp2_video);
        videos = new ArrayList<>();

        videos.add(new
                PlayVideoList(
                        "Big Buck Bunny",
                        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
        );

        videos.add( new
                PlayVideoList(
                        "Elephant Dream",
                        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
                )
        );

        videos.add( new
                PlayVideoList(
                        "For Bigger Blazes",
                        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"
                )
        );

        adapter = new VideoAdapter(this, videos, new VideoAdapter.OnVideoPreparedListener() {
            @Override
            public void onVideoPrepared(ExoPlayerItem exoPlayerItem) {
                listItem.add(exoPlayerItem);
            }
        });
        vp2Video.setAdapter(adapter);
        vp2Video.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                int previousIndex = listItem.
            }
        });
    }

}