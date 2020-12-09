package com.example.proyectocuy.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyectocuy.R;
import com.example.proyectocuy.RegistroCuy;

public class PreguntaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);
    }
    public void btnManualClick(View view)
    {
        Intent i = new Intent(this, RegistroPozasManualActivity.class);
        i.putExtra("show_nextButtom",true);
        startActivity(i);
    }
    public void btnRecomendadoClick(View view)
    {
        Intent i=new Intent(this, RegistroCuy.class);
        startActivity(i);
    }
}