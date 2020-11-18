package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class    MenuVerPozas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ver_pozas);
    }

    public void btnEmpadre(View v){
        Intent i = new Intent(this,MenuPozasEmpadre.class);
        startActivity(i);
    }
    public void btnEngorde(View v){
        Intent i = new Intent(this,MenuPozasEngorde.class);
        startActivity(i);
    }
    public void btnRecria(View v){
        Intent i = new Intent(this,MenuPozasRecria.class);
        startActivity(i);
    }
    public void btnPadrillos(View v){
        Intent i = new Intent(this,MenuPozasPadrillo.class);
        startActivity(i);
    }



}