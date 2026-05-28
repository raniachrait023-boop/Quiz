package com.example.quiz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class hist2 extends AppCompatActivity {
    Button retour , suivant ;
    int quiz;

    private TextView timerText;

    private CountDownTimer countDownTimer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hist2);
        Bundle bundle=getIntent().getExtras();
        String nom=bundle.getString("pseudo");
        RadioButton radioButton1=findViewById(R.id.radioButton1);
        RadioButton radioButton2=findViewById(R.id.radioButton2);
        RadioButton radioButton3=findViewById(R.id.radioButton3);

        timerText = findViewById(R.id.timerText);
        countDownTimer = new CountDownTimer(10000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished / 1000 + 1;
                timerText.setText(String.valueOf(seconds));

            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();



        Button suivant=findViewById(R.id.suivant);
        quiz=getIntent().getExtras().getInt("quiz");
        retour = findViewById(R.id.retour);
        suivant = findViewById(R.id.suivant);




        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton2.isChecked()){
                    quiz=quiz+5;

                }
                else {
                    quiz=+quiz+0;
                }



                Intent intent=new Intent(hist2.this,hist3.class);
                intent.putExtra("quiz",quiz);
                Bundle bundle = new Bundle();
                bundle.putString("pseudo",(nom));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(hist2.this,hist1.class);
                startActivity(i);
            }
        });
    }



}