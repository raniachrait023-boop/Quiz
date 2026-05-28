package com.example.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private  CardView cumputer ,history ,science ,mathématique , deconnecter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       cumputer = findViewById(R.id.compture);
       history = findViewById(R.id.hist);
       science = findViewById(R.id.science);
       mathématique = findViewById(R.id.math);
       deconnecter = findViewById(R.id.deconnecter);
       AlertDialog.Builder builder = new AlertDialog.Builder(this);



history.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i = new Intent(MainActivity.this,Acceuil_histoire.class);
        startActivity(i);
    }
});

       cumputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Accueil_informatique.class);
                startActivity(i);
            }
        });
       mathématique.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(MainActivity.this,Acceuil_math.class);
               startActivity(i);
           }
       });


       science.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(MainActivity.this,Acceuil_science.class);
               startActivity(i);
           }
       });
       deconnecter.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               builder.setTitle("Déconnecter");
               builder.setMessage("Êtes-vous sûr de vouloir quitter l'application ?");
               builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       finish();
                   }
               });
               builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       dialogInterface.dismiss();
                   }
               });
               builder.show();


           }
       });
    }
}