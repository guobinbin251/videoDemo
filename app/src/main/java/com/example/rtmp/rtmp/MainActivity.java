package com.example.rtmp.rtmp;

import android.app.Activity;
import android.os.Bundle;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.utils.Log;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private String path = "";
    private VideoView mVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!LibsChecker.checkVitamioLibs(this)){
            Log.e(TAG,"Libs not complete!!");
            return;
        }
        setContentView(R.layout.activity_main);

        mVideoView = (VideoView)findViewById(R.id.vitamio_videoView);
        path = "rtmp://218.63.117.136:8093/hls/camera";
        mVideoView.setVideoPath(path);
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.requestFocus();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setPlaybackSpeed(1.0f);
            }
        });
        mVideoView.start();
    }
}
