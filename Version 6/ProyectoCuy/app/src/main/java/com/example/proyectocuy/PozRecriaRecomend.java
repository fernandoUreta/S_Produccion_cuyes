package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class PozRecriaRecomend extends AppCompatActivity {
    TextView cantidaPozas;
    int valor1,padriguardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poz_recria_recomend);
        cantidaPozas=findViewById(R.id.txtPRCantidad);

        String recria = getIntent().getStringExtra("pozRecriEnvior");
        Log.d("hola", recria);

        valor1=Integer.parseInt(recria);
        cantidaPozas.setText(String.valueOf(valor1));

        String padrillo=getIntent().getStringExtra("pozPadriEnvior");
        Log.d("hola1",padrillo);
        padriguardar=Integer.parseInt(padrillo);
    }
    public void btnAtras(View v){
        Intent i = new Intent(this,PozEngordeRecomend.class);
        startActivity(i);
    }
    public void btnSiguiente(View v){
        Intent i = new Intent(this,PozPadrilloRecomend.class);
        String padrillo=String.valueOf(padriguardar);
        i.putExtra("pozPadriEnvioFinal",padrillo);
        startActivity(i);
    }
}