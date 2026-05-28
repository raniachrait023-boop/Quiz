package com.example.quiz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class result_math extends AppCompatActivity {
    int quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_math);
        Button merci = findViewById(R.id.merci);


        Bundle bundle=getIntent().getExtras();
        String nom=bundle.getString("pseudo");
        quiz=getIntent().getExtras().getInt("quiz");
        TextView score=findViewById(R.id.score);
        TextView pseudo=findViewById(R.id.pseudo);
        pseudo.setText(nom);
        score.setText("Votre score ="+quiz);
        Toast.makeText(this, "le score sera"+quiz, Toast.LENGTH_SHORT).show();


        merci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(result_math.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}