package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OpcionCrearPoza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcion_crear_poza);
    }

    public void PozaRecomendada(View v){
        Intent i = new Intent(this,DistribucionRecomendado.class);
        startActivity(i);
    }
}