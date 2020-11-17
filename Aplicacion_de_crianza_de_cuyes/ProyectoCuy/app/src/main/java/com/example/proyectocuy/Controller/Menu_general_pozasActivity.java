package com.example.proyectocuy.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.proyectocuy.MenuVerPozas;
import com.example.proyectocuy.R;


public class Menu_general_pozasActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_general_pozas);
        showToolbar("Menú de pozas",true);
    }

    public void showToolbar(String tittle, Boolean upButton)
    {
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public void btnConsultarPozasClick(View view)
    {
        Intent intent=new Intent(this, MenuVerPozas.class);
        startActivity(intent);
    }
    public void btnRegistrarPozasClick(View view)
    {
        //Intent intent=new Intent(this, RegistroPozasManualActivity.class);
        //startActivity(intent);
    }
    public void btnEliminarPozasClick(View view)
    {
        Intent intent=new Intent(this,Eliminar_PozasActivity.class);
        startActivity(intent);
    }
}