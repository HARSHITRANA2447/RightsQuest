package com.example.rightsquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Objects;

public class logInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Objects.requireNonNull(getSupportActionBar()).hide();

        ImageButton searchImageButton = findViewById(R.id.searchImageButton);
        Button signup = findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign = new Intent(logInActivity.this,signUpActivity.class);
                startActivity(sign);
            }
        });
        searchImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(logInActivity.this, MainActivity.class);
                startActivity(login);
            }
        });
    }
}