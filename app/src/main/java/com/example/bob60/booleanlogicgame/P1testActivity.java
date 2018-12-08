package com.example.bob60.booleanlogicgame;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
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
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;
import java.util.Random;
import java.util.Arrays;

public class P1testActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    //public static final String MY_SCORE = "myScore";
    //private static final long COUNTDOWN_IN_MILLIS = 10000;

    //private TextView textViewScore;
    //private TextView textViewCountDown;
    //private int score;
    private long backPressedTime;


    //private ColorStateList textColorDefaultCd;
    //private CountDownTimer countDownTimer;
    //private long timeLeftInMillis = COUNTDOWN_IN_MILLIS;

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
        advance();
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
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1test);

        //textViewScore = findViewById(R.id.text_view_score);
        //textViewCountDown = findViewById(R.id.text_view_countdown);

        //textColorDefaultCd = textViewCountDown.getTextColors();


        GestureDetect = new GestureDetectorCompat(this,this);
        GestureDetect.setOnDoubleTapListener(this);



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

        //startCountDown();


        Button pressSubmit = findViewById(R.id.submit_answer);
        pressSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean[][] playerAnswers = {
                        {ans1.isChecked(), ans2.isChecked(), ans3.isChecked()},
                        {ans4.isChecked(), ans5.isChecked(), ans6.isChecked()},
                        {ans7.isChecked(), ans8.isChecked(), ans9.isChecked()}};

                //countDownTimer.cancel();

                if (Arrays.deepEquals(playerAnswers, boolAnswers)) {
                  //  score++;
                    //textViewScore.setText("Score: " + score);
                    advance();
                } else {
                    gameOver();
                }
            }
        });

    }

    private void advance() {
        finish();
        Intent intent = new Intent(P1testActivity.this, P1testActivity.class);
        startActivity(intent);
    }
    private void gameOver() {
        Intent resultIntent = new Intent();
        //resultIntent.putExtra(MY_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }



    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            gameOver();
        }
        backPressedTime = System.currentTimeMillis();
    }

}
