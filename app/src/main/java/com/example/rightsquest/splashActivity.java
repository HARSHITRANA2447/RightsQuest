package com.example.rightsquest;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class splashActivity extends AppCompatActivity {

    // SharedPreferences key to track whether the splash screen has been shown
    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String SPLASH_SCREEN_SHOWN_KEY = "splashScreenShown";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        // Check if the splash screen has been shown before
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        boolean splashScreenShown = prefs.getBoolean(SPLASH_SCREEN_SHOWN_KEY, false);

        // If the splash screen has not been shown before, show it
        if (!splashScreenShown) {
            // Show the splash screen for a few seconds (e.g., 2 seconds)
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Set the flag to indicate that the splash screen has been shown
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean(SPLASH_SCREEN_SHOWN_KEY, true);
                    editor.apply();

                    // Start the main activity or any other desired activity
                    Intent intent = new Intent(splashActivity.this, logInActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 1700); // 2000 milliseconds (2 seconds)
        } else {
            // If the splash screen has been shown before, directly start the main activity
            Intent intent = new Intent(splashActivity.this, logInActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

