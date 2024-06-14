package com.example.rightsquest;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class videoplayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_videoplayer);

        // Set the screen orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        VideoView videoView = findViewById(R.id.videoView);

        // Set the video file path or URL to play
        String videoPath = "android.resource://"+getPackageName()+"/raw/body";
        videoView.setVideoPath(videoPath);
        videoView.start();

        // ... other video playback code here ...

        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}