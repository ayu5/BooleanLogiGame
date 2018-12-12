package com.example.bob60.booleanlogicgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighScore";

    private TextView textViewHighScore;

    private int highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("on create", "on create");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewHighScore = findViewById(R.id.text_view_highscore);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        int score = prefs.getInt(PtestActivity.MY_SCORE, 0);
        Log.i("score", "score: " + score);
        Log.i("high score", "high score: " + highscore);
        if (score > highscore) {
            updateHighScore(score);
            Log.i("update", "updated");
        }

        loadHighScore();

        editor.putInt(PtestActivity.MY_SCORE, 0);
        editor.apply();

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

        Button buttonResetScore = findViewById(R.id.button_resetScore);
        buttonResetScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHighScore();
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
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    private void startPractice() {
        Intent intent = new Intent(MainActivity.this, P1testActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        Log.i("on activity", "on activity");

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            int score = prefs.getInt(PtestActivity.MY_SCORE, 0);
            Log.i("score", "score: " + score);
            Log.i("high score", "high score: " + highscore);
            if (score > highscore) {
                updateHighScore(score);
                Log.i("update", "updated");
            }
        }
        loadHighScore();

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(PtestActivity.MY_SCORE, 0);
        editor.apply();
    }

    private void loadHighScore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighScore.setText("High Score: " + highscore);
        Log.i("loaded", "loaded: " + highscore);
    }
    private void updateHighScore(int highScoreNew) {
        highscore = highScoreNew;

        Log.i("updated", "updated: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
    private void resetHighScore() {
        highscore = 0;

        textViewHighScore = findViewById(R.id.text_view_highscore);
        textViewHighScore.setText("Highscore: 0");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, 0);
        editor.apply();
    }
}
