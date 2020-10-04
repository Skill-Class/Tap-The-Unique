package com.example.taptheunique;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animator.AnimatorListener {
    private int score = 0;
    private int randomNumber, randomIndexX, randomIndexY, uniqueButtonId, uniqueNumber, counter = 30;
    private TextView scoreView, timerView;
    private static final int[][] idArray = {{R.id.b11, R.id.b12, R.id.b13, R.id.b14, R.id.b15, R.id.b16, R.id.b17},
            {R.id.b21, R.id.b22, R.id.b23, R.id.b24, R.id.b25, R.id.b26, R.id.b27},
            {R.id.b31, R.id.b32, R.id.b33, R.id.b34, R.id.b35, R.id.b36, R.id.b37},
            {R.id.b41, R.id.b42, R.id.b43, R.id.b44, R.id.b45, R.id.b46, R.id.b47},
            {R.id.b51, R.id.b52, R.id.b53, R.id.b54, R.id.b55, R.id.b56, R.id.b57},
            {R.id.b61, R.id.b62, R.id.b63, R.id.b64, R.id.b65, R.id.b66, R.id.b67},
            {R.id.b71, R.id.b72, R.id.b73, R.id.b74, R.id.b75, R.id.b76, R.id.b77}
    };

    private static final Button[][] button = new Button[7][8];

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerView = (TextView) findViewById(R.id.timerView);
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerView.setText(String.valueOf(counter));
                counter--;
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("Score", String.valueOf(score));
                startActivity(intent);
                // finish();
            }
        }.start();

        scoreView = (TextView) findViewById(R.id.scoreView);
        scoreView.setText(score + "");

        callRandom();

    }


    private void callRandom() {
        Random rand = new Random();
        randomIndexX = rand.nextInt(7);
        randomIndexY = rand.nextInt(7);
        do {
            randomNumber = rand.nextInt(90) + 10;
            uniqueNumber = rand.nextInt(90) + 10;
        } while (randomNumber == uniqueNumber);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                button[i][j] = (Button) findViewById(idArray[i][j]);
                if (i == randomIndexX && j == randomIndexY) {
                    button[i][j].setText(uniqueNumber + "");
                    uniqueButtonId = idArray[i][j];
                } else {
                    button[i][j].setText(randomNumber + "");
                }
                button[i][j].setOnClickListener((View.OnClickListener) this);
                translateAnimation(button[i][j]);
            }
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == uniqueButtonId) {
            //  Toast.makeText(game5_old.this,"Correct",Toast.LENGTH_LONG).show();
            score += 5;
        } else {
            //    Toast.makeText(game5_old.this,"InCorrect",Toast.LENGTH_LONG).show();
        }
        scoreView.setText(score + "");
        callRandom();

    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        //finishAffinity();
        // finish();
        Toast.makeText(getApplicationContext(), "Back button is disabled", Toast.LENGTH_SHORT).show();
    }

    public void translateAnimation(View view) {
        Animator translator = AnimatorInflater.loadAnimator(this, R.animator.translator);
        translator.setTarget(view);
        translator.addListener(this);
        translator.start();
    }

    @Override
    public void onAnimationStart(Animator animator) {

    }

    @Override
    public void onAnimationEnd(Animator animator) {

    }

    @Override
    public void onAnimationCancel(Animator animator) {

    }

    @Override
    public void onAnimationRepeat(Animator animator) {

    }
}
