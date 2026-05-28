package com.example.quiz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class computer4 extends AppCompatActivity {
    int quiz;
    private TextView timerText;

    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer4);



        Bundle bundle=getIntent().getExtras();
        String nom=bundle.getString("pseudo");
        RadioButton radioButton1=findViewById(R.id.radioButton1);
        RadioButton radioButton2=findViewById(R.id.radioButton2);
        RadioButton radioButton3=findViewById(R.id.radioButton3);
        Button suivant=findViewById(R.id.suivant);
        quiz=getIntent().getExtras().getInt("quiz");

        Button retour=findViewById(R.id.retour);
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


        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent i = new Intent (computer4.this,computer3.class);
             startActivity(i);
            }
        });

        suivant.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if (radioButton1.isChecked()){
                    quiz=quiz+5;

                }
                else {
                    quiz=+quiz+0;
                }



                Intent intent=new Intent(computer4.this,computer5.class);
                intent.putExtra("quiz",quiz);
                Bundle bundle = new Bundle();
                bundle.putString("pseudo",(nom));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });



    }
}