package com.example.taptheunique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView message;
    private Button playAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        message = (TextView) findViewById(R.id.message);
        playAgain = (Button) findViewById(R.id.playAgain);
        Intent intent = getIntent();
        String finalScore = intent.getStringExtra("Score");
        message.setText(" Your Score is: \n" + finalScore);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this,IntroActivity.class);
                startActivity(intent);
            }
        });
    }
}