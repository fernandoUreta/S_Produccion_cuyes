package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void btnPozas(View v){
        Intent i = new Intent(this,MenuPozas.class);
        startActivity(i);
    }
    public void btnCalendario(View v){
        Intent i = new Intent(this,Calendario.class);
        startActivity(i);
    }
    public void btnReporte(View v){
        Intent i = new Intent(this,MenuReportes.class);
        startActivity(i);
    }
}