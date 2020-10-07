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

    private Button startGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        startGame = findViewById(R.id.startGame);
        translateAnimation(startGame);
        scaleAnimation(findViewById(R.id.textView3));
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
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