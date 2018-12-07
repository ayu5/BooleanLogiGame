package com.example.bob60.booleanlogicgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckBox;

public class PtestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptest);

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
                if (!ans1.isChecked()
                        && !ans2.isChecked()
                        && ans3.isChecked()
                        && ans4.isChecked()
                        && ans5.isChecked()
                        && !ans6.isChecked()
                        && !ans7.isChecked()
                        && !ans8.isChecked()
                        && !ans9.isChecked()) {
                    advance();
                } else {
                    gameOver();
                }
            }
        });
    }

    private void advance() {
        Intent intent = new Intent(PtestActivity.this, Main2Activity.class);
        startActivity(intent);
    }
    private void gameOver() {
        Intent intent = new Intent(PtestActivity.this, MainActivity.class);
        startActivity(intent);
    }


}
