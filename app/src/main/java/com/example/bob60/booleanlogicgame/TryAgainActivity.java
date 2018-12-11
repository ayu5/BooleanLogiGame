package com.example.bob60.booleanlogicgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TryAgainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_again);

        Button buttonGoHome = findViewById(R.id.button_go_Home);
        buttonGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });
    }

    private void goHome() {
        Intent intent = new Intent(TryAgainActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
