package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectocuy.DatosActividades.DatosActividades;

public class PozEngordeRecomend extends AppCompatActivity {
    TextView cantidaPozas;
    int valor1,recguar,padriguar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poz_engorde_recomend);
        cantidaPozas=findViewById(R.id.txtPEnRcantidad);
        String engorde = getIntent().getStringExtra("pozEngorgeEnvio");
        Log.d("hola", engorde);

        valor1=Integer.parseInt(engorde);
        cantidaPozas.setText(String.valueOf(valor1));

        String recria=getIntent().getStringExtra("pozRecriEnvio");
        Log.d("hola1",recria);
        String padrillo=getIntent().getStringExtra("pozPadriEnvio");
        Log.d("hola1",padrillo);

        recguar=Integer.parseInt(recria);
        padriguar=Integer.parseInt(padrillo);

    }

    public void btnAtras(View v){
        Intent i = new Intent(this,PozEmpadreRecomend.class);
        startActivity(i);
    }
    public void btnSiguiente(View v){
        Intent i = new Intent(this,PozRecriaRecomend.class);
        String recria=String.valueOf(recguar);
        i.putExtra("pozRecriEnvior",recria);
        String padrillo=String.valueOf(padriguar);
        i.putExtra("pozPadriEnvior",padrillo);
        startActivity(i);
    }
}