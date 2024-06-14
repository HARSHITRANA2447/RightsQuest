package com.example.rightsquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Objects;

public class storystoryplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storystoryplay);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        VideoView video_View = findViewById(R.id.video_View);

        // Set the video file path or URL to play
        String videoPath = "android.resource://"+getPackageName()+"/raw/good";
        video_View.setVideoPath(videoPath);
        video_View.start();

        // ... other video playback code here ...

        MediaController mediaController=new MediaController(this);
        video_View.setMediaController(mediaController);
        mediaController.setAnchorView(video_View);
    }
}