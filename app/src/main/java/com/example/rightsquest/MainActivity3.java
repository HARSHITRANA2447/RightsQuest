package com.example.rightsquest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3; // For the "nutrition" button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        // Initialize ImageButtons
        btn1 = findViewById(R.id.unwanted);
        btn2 = findViewById(R.id.goodbad);
        btn3 = findViewById(R.id.nutrition);

        // Set an OnClickListener for the "nutrition" button
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the VideoPlayerActivity when the button is clicked
                Intent intent = new Intent(MainActivity3.this,videoplayer.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this,storystoryplay.class);
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this,playstory.class);
                startActivity(intent);
            }
        });
    }
}
