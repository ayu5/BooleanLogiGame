package com.example.bob60.booleanlogicgame;

import android.content.Intent;
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

import java.util.Random;
import java.util.Arrays;

public class PtestActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    TextView questionText = findViewById(R.id.textView);
    protected String[][] boardStrings = new String[][] {
            {"blue1", "yellow2", "red3"},
            {"blue3", "yellow3", "red1"},
            {"blue2", "yellow1", "red2"}};

    private GestureDetectorCompat GestureDetect;
    @Override
    public boolean onDown(MotionEvent e) {
        questionText.setText("onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        questionText.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        questionText.setText("onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        questionText.setText("onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        advance();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptest);
        GestureDetect = new GestureDetectorCompat(this,this);
        GestureDetect.setOnDoubleTapListener(this);

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

        Button pressSubmit = findViewById(R.id.submit_answer);
        pressSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean[][] playerAnswers = {
                        {ans1.isChecked(), ans2.isChecked(), ans3.isChecked()},
                        {ans4.isChecked(), ans5.isChecked(), ans6.isChecked()},
                        {ans7.isChecked(), ans8.isChecked(), ans9.isChecked()}};

                Log.i("Me", Arrays.deepToString(boolAnswers));
                Log.i("Player", Arrays.deepToString(playerAnswers));

                if (Arrays.deepEquals(playerAnswers, boolAnswers)) {
                    Log.i("a", "a");
                    advance();
                } else {
                    Log.i("b", "b");
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
        Intent intent = new Intent(PtestActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
