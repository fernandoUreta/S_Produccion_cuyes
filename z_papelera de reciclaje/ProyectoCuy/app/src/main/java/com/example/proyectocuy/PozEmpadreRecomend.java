package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectocuy.DatosActividades.DatosActividades;

import java.util.ArrayList;

public class PozEmpadreRecomend extends AppCompatActivity {
    TextView cantidadPozas;
    int valor1,engordeguarda,recriaguarda,padrilloguarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poz_empadre_recomend);
        cantidadPozas=findViewById(R.id.txtPERcantidad);
        String empadre = getIntent().getStringExtra("pozEmpadre");
        Log.d("hola", empadre);

        valor1=Integer.parseInt(empadre);
        cantidadPozas.setText(String.valueOf(valor1));

        String engorde=getIntent().getStringExtra("pozEngorde");
        Log.d("hola1",engorde);
        String recria=getIntent().getStringExtra("PozRecria");
        Log.d("hola1",recria);
        String padrillo=getIntent().getStringExtra("PozPadrillo");
        Log.d("hola1",padrillo);

        engordeguarda=Integer.parseInt(engorde);
        recriaguarda=Integer.parseInt(recria);
        padrilloguarda=Integer.parseInt(padrillo);

    }

    public void btnAtras(View v){
        Intent i = new Intent(this,DistribucionRecomendado.class);
        startActivity(i);
    }
    public void btnSiguiente(View v){
        Intent i = new Intent(this,PozEngordeRecomend.class);
        String engorde=String.valueOf(engordeguarda);
        i.putExtra("pozEngorgeEnvio",engorde);
        String recria=String.valueOf(recriaguarda);
        i.putExtra("pozRecriEnvio",recria);
        String padrillo=String.valueOf(padrilloguarda);
        i.putExtra("pozPadriEnvio",padrillo);

        startActivity(i);
    }
}