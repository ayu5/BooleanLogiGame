package com.example.bob60.booleanlogicgame;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.CountDownTimer;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;
import java.util.Arrays;

import android.content.SharedPreferences;

public class PtestActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String MY_SCORE = "myScore";
    private static final long COUNTDOWN_IN_MILLIS = 10000;

    private TextView textViewScore;
    private TextView textViewCountDown;
    protected static Integer score = 0;
    private long backPressedTime;


    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = COUNTDOWN_IN_MILLIS;

    protected String[][] boardStrings = new String[][] {
            {"blue1", "yellow2", "red3"},
            {"blue3", "yellow3", "red1"},
            {"blue2", "yellow1", "red2"}};

    private GestureDetectorCompat GestureDetect;
    @Override
    public boolean onDown(MotionEvent e) {
        Log.i("a", "a");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.i("a", "a");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.i("a", "a");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.i("a", "a");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.i("a", "a");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i("a", "a");
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.i("a", "a");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.i("a", "a");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.i("a", "a");
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        GestureDetect.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptest);

        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
                advance();
            }
        });

        textViewScore = findViewById(R.id.text_view_score);
        textViewCountDown = findViewById(R.id.text_view_countdown);

        textColorDefaultCd = textViewCountDown.getTextColors();

        GestureDetect = new GestureDetectorCompat(this,this);
        GestureDetect.setOnDoubleTapListener(this);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        score = prefs.getInt(MY_SCORE, 0);
        String text = "Score: " + score;
        Log.i("score", text);
        textViewScore.setText("Score: " + score);

        TextView questionText = findViewById(R.id.textView);

        Random rand = new Random();
        int questionNum = rand.nextInt(5);

        Object[] input = Main2Activity.getQuestion(questionNum);
        String question = (String) input[0];
        String[] answers = (String[]) input[1];

        final boolean[][] boolAnswers = new boolean[3][3];

        for (int i = 0; i < boolAnswers.length; i++) {
            for (int j = 0; j < boolAnswers[i].length; j++) {
                for (String answer : answers) {
                    if (answer.equals(boardStrings[i][j])) {
                        boolAnswers[i][j] = true;
                    }
                }
            }
        }

        questionText.setText(question);

        final CheckBox ans1 = findViewById(R.id.game_button1);
        final CheckBox ans2 = findViewById(R.id.game_button2);
        final CheckBox ans3 = findViewById(R.id.game_button3);
        final CheckBox ans4 = findViewById(R.id.game_button4);
        final CheckBox ans5 = findViewById(R.id.game_button5);
        final CheckBox ans6 = findViewById(R.id.game_button6);
        final CheckBox ans7 = findViewById(R.id.game_button7);
        final CheckBox ans8 = findViewById(R.id.game_button8);
        final CheckBox ans9 = findViewById(R.id.game_button9);

        startCountDown();

        Button pressSubmit = findViewById(R.id.submit_answer);
        pressSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean[][] playerAnswers = {
                        {ans1.isChecked(), ans2.isChecked(), ans3.isChecked()},
                        {ans4.isChecked(), ans5.isChecked(), ans6.isChecked()},
                        {ans7.isChecked(), ans8.isChecked(), ans9.isChecked()}};

                countDownTimer.cancel();

                if (Arrays.deepEquals(playerAnswers, boolAnswers)) {
                    score++;

                    SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt(MY_SCORE, score);
                    editor.apply();

                    advance();
                } else {
                    gameOver();
                }
            }
        });

    }

    private void advance() {
        finish();
        Intent intent = new Intent(PtestActivity.this, PtestActivity.class);
        startActivity(intent);
    }
    private void gameOver() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(MY_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                gameOver();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);

        if (timeLeftInMillis < 5000) {
            textViewCountDown.setTextColor(Color.RED);
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }
}
