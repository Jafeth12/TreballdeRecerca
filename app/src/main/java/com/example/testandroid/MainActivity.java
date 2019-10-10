package com.example.testandroid;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaració dels botons de la homepage per anar a cada una de les activitats
        Button goTecno, goFisica, goMates;

        //setOnClickListener per cada botó i que obrin la seva activitat correspondent
        goTecno = findViewById(R.id.goTecno);
        goTecno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTecno();
            }
        });

        goFisica = findViewById(R.id.goFisica);
        goFisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFisica();
            }
        });

        goMates = findViewById(R.id.goMates);
        goMates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMates();
            }
        });
    }

    //creació dels methods per anar a les activitat de física, mates i tecno
    public void openFisica() {
        Intent intent = new Intent(this, FisicaActivity.class);
        startActivity(intent);
    }

    public void openMates() {
        Intent intent = new Intent(this, MatesActivity.class);
        startActivity(intent);
    }

    public void openTecno() {
        Intent intent = new Intent(this, TecnoActivity.class);
        startActivity(intent);
    }


}
