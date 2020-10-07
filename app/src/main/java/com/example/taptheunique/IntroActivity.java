package com.example.taptheunique;

import androidx.appcompat.app.AppCompatActivity;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity implements Animator.AnimatorListener {

    private Button startGame, easyButton, mediumButton, hardButton, timeButton1, timeButton2;
    int level = 1;
    int time = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        startGame = findViewById(R.id.startGame);
        easyButton = findViewById(R.id.easyButton);
        mediumButton = findViewById(R.id.mediumButton);
        hardButton = findViewById(R.id.hardButton);
        timeButton1 = findViewById(R.id.timeButton1);
        timeButton2 = findViewById(R.id.timeButton2);

        translateAnimation(startGame);
        scaleAnimation(findViewById(R.id.textView3));

        timeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time = 1;
                timeButton1.setBackgroundResource(R.drawable.button_background_green);
                timeButton2.setBackgroundResource(R.drawable.button_background);
            }
        });

        timeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time = 2;
                timeButton2.setBackgroundResource(R.drawable.button_background_green);
                timeButton1.setBackgroundResource(R.drawable.button_background);
            }
        });

        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level = 1;
                easyButton.setBackgroundResource(R.drawable.button_background_green);
                mediumButton.setBackgroundResource(R.drawable.button_background);
                hardButton.setBackgroundResource(R.drawable.button_background);
            }
        });
        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level = 2;
                mediumButton.setBackgroundResource(R.drawable.button_background_green);
                easyButton.setBackgroundResource(R.drawable.button_background);
                hardButton.setBackgroundResource(R.drawable.button_background);
            }
        });
        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level = 3;
                hardButton.setBackgroundResource(R.drawable.button_background_green);
                mediumButton.setBackgroundResource(R.drawable.button_background);
                easyButton.setBackgroundResource(R.drawable.button_background);
            }
        });

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("levelValue", level);
                bundle.putInt("timeValue", time);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    public void translateAnimation(View view) {
        Animator translator = AnimatorInflater.loadAnimator(this, R.animator.translator);
        translator.setInterpolator(new FastOutSlowInInterpolator());
        translator.setTarget(view);
        translator.addListener(this);
        translator.start();
    }

    public void scaleAnimation(View view) {
        Animator scale = AnimatorInflater.loadAnimator(this, R.animator.scale);
        scale.setInterpolator(new AccelerateDecelerateInterpolator());
        scale.setTarget(view);
        scale.addListener(this);
        scale.start();
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