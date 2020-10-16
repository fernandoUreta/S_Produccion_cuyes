package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class PozPadrilloRecomend extends AppCompatActivity {
    TextView cantidaPozas;
    int valor1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poz_padrillo_recomend);
        cantidaPozas=findViewById(R.id.txtPRPCantidad);

        String padrillo = getIntent().getStringExtra("pozPadriEnvioFinal");
        Log.d("hola", padrillo);

        valor1=Integer.parseInt(padrillo);
        cantidaPozas.setText(String.valueOf(valor1));
    }
    public void btnAtras(View v){
        Intent i = new Intent(this,PozRecriaRecomend.class);
        startActivity(i);
    }
    public void btnSiguiente(View v){
        Intent i = new Intent(this,MenuPrincipal.class);
        startActivity(i);
    }
}