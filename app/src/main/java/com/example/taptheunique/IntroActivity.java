package com.example.taptheunique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity {

    private Button startGame,easyButton,mediumButton,hardButton,timeButton1,timeButton2;
    int level=1;
    int time=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        startGame = (Button) findViewById(R.id.startGame);
        easyButton = (Button) findViewById(R.id.easyButton);
        mediumButton = (Button) findViewById(R.id.mediumButton);
        hardButton = (Button) findViewById(R.id.hardButton);
        timeButton1 = (Button) findViewById(R.id.timeButton1);
        timeButton2 = (Button) findViewById(R.id.timeButton2);

        timeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time=1;
                timeButton1.setBackgroundResource(R.drawable.button_background_green);
                timeButton2.setBackgroundResource(R.drawable.button_background);
            }
        });

        timeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time=2;
                timeButton2.setBackgroundResource(R.drawable.button_background_green);
                timeButton1.setBackgroundResource(R.drawable.button_background);
            }
        });

        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level=1;
                easyButton.setBackgroundResource(R.drawable.button_background_green);
                mediumButton.setBackgroundResource(R.drawable.button_background);
                hardButton.setBackgroundResource(R.drawable.button_background);
            }
        });
        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level=2;
                mediumButton.setBackgroundResource(R.drawable.button_background_green);
                easyButton.setBackgroundResource(R.drawable.button_background);
                hardButton.setBackgroundResource(R.drawable.button_background);
            }
        });
        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level=3;
                hardButton.setBackgroundResource(R.drawable.button_background_green);
                mediumButton.setBackgroundResource(R.drawable.button_background);
                easyButton.setBackgroundResource(R.drawable.button_background);
            }
        });

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this,MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("levelValue",String.valueOf(level));
                bundle.putString("timeValue",String.valueOf(time));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}