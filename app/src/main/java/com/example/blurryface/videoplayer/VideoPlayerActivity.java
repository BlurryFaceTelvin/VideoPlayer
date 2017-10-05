package com.example.blurryface.videoplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayerActivity extends AppCompatActivity {
    VideoView videoView;
    String TAG = "VideoPlayer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        videoView = (VideoView)findViewById(R.id.videoView);
        videoView.setVideoPath("http://www.ebookfrenzy.com/android_book/movie.mp4");
        //mediaController
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i(TAG,"Duration ="+videoView.getDuration());
            }
        });
        videoView.start();
    }
}
