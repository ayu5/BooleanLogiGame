package com.example.bob60.booleanlogicgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPressPlay = findViewById(R.id.button_play);
        buttonPressPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });

        Button buttonPracticeMode = findViewById(R.id.button_practice);
        buttonPracticeMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPractice();
            }
        });

        Button buttonPressQuit = findViewById(R.id.button_quit);
        buttonPressQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    private void startGame() {
        Intent intent = new Intent(MainActivity.this, PtestActivity.class);
        startActivity(intent);
    }

    private void startPractice() {
        Intent intent = new Intent(MainActivity.this, PtestActivity.class);
        startActivity(intent);
    }
}
