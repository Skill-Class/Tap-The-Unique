package com.example.taptheunique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    sleep(2500);
                    Intent i = new Intent(Splash_Screen.this,IntroActivity.class);
                    startActivity(i);
                    finish();

                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
           thread.start();
    }
}