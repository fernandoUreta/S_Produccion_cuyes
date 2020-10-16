package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectocuy.DatosActividades.DatosActividades;
import com.example.proyectocuy.ModeloDatos.Poza;

public class DistribucionRecomendado extends AppCompatActivity {

    int valor1, valor2, valor3, valor4, valor5, valor6, valor7, Total;
    int empradre, engordeB, recriaB, PePadrillo;
    int cantidadPengordeM, cantidadPengordeH, cantRecH, cantRecM;
    int poz;

    TextView totalpozas,pozEmpadre,pozPadrillo,pozEngorde,pozRecria;
    Button btnManual,btnSiguienteR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distribucion_recomendado);

        pozEmpadre=findViewById(R.id.txtDRpozEmpadre);
        pozPadrillo=findViewById(R.id.txtDRpozPadrillo);
        pozEngorde=findViewById(R.id.txtDRpozEngorde);
        pozRecria=findViewById(R.id.txtDRpozRecria);
        totalpozas = findViewById(R.id.txtDRcantidadpozas);
        btnManual=findViewById(R.id.btnDRmanual);
        btnSiguienteR=findViewById(R.id.btnDRsiguiente);

        String mMadura = getIntent().getStringExtra("Enviando");
        Log.d("hola", mMadura);
        valor1 = Integer.parseInt(mMadura);
        String mPrimerisa = getIntent().getStringExtra("madreP");
        Log.d("hola", mPrimerisa);
        valor2=Integer.parseInt(mPrimerisa);

        empradre=(valor1/10)+(valor2/10);

        String Padrillo = getIntent().getStringExtra("padrillo");
        Log.d("hola", Padrillo);
        valor3=Integer.parseInt(Padrillo);
        PePadrillo=valor3-empradre;

        String engMacho = getIntent().getStringExtra("engordeMacho");
        Log.d("hola", engMacho);
        valor4=Integer.parseInt(engMacho);
        String engHembra = getIntent().getStringExtra("engordeHembra");
        Log.d("hola", engHembra);
        valor5=Integer.parseInt(engHembra);
        cantidadPengordeM=valor4/10;
        cantidadPengordeH=valor5/10;
        engordeB=cantidadPengordeM+cantidadPengordeH;

        String recMacho = getIntent().getStringExtra("recriaMacho");
        Log.d("hola", recMacho);
        valor6=Integer.parseInt(recMacho);
        String recHembra = getIntent().getStringExtra("recriaHembra");
        Log.d("hola", recHembra);
        valor7=Integer.parseInt(recHembra);
        cantRecH=valor6/10;
        cantRecM=valor7/10;
        recriaB=cantRecH+cantRecM;

        Total=empradre+PePadrillo+engordeB+recriaB;

        pozEmpadre.setText(String.valueOf(empradre));//cantidad de pozas, Largo
        pozPadrillo.setText(String.valueOf(PePadrillo));//Largo=
        pozEngorde.setText(String.valueOf(engordeB));
        pozRecria.setText(String.valueOf(recriaB));

        totalpozas.setText(String.valueOf(Total));

    /*public void Distribucion(){

        //Cantidad de pozas para empadre 2
        cantidadMMempa=mMadura/10;
        cantidadMPempa=mPrimerisa/10;
        empradre=cantidadMMempa+cantidadMPempa;

        //Cantidad de pozas para Padrillo 8
        PePadrillo=Padrillo-empradre;

        //cantidad de pozas para engorde 2
        cantidadPengordeM=engMacho/10;
        cantidadPengordeH=engHembra/10;
        engorde=cantidadPengordeM+cantidadPengordeH;

        //Cantidad de pozas para recria
        cantRecH = recHembra/10;
        cantRecM=recMacho/10;
        recria=cantRecH+cantRecM;

        Total=empradre+PePadrillo+engorde+recria;
    }*/
    }

    public void pozaEmpadreRecomendada(View v){
        Intent i = new Intent(this,PozEmpadreRecomend.class);
        String empadre=pozEmpadre.getText().toString();
        i.putExtra("pozEmpadre",empadre);
        String engorde=pozEngorde.getText().toString();
        i.putExtra("pozEngorde",engorde);
        String recria=pozRecria.getText().toString();
        i.putExtra("PozRecria",recria);
        String padrillo=pozPadrillo.getText().toString();
        i.putExtra("PozPadrillo",padrillo);

        Poza poza=new Poza();
        for (int j=1;j<=empradre;j++){
            poza.idPoza="A"+j;
            poza.ancho=150;
            poza.largo=100;
            poza.capacidad=10;
            poza.clasificacion="Empadre";
            BD_ProduccionCuyes.registrarPoza(poza);
        }
        for (int j=1;j<=PePadrillo;j++){
            poza.idPoza="D"+j;
            poza.ancho=50;
            poza.largo=50;
            poza.capacidad=1;
            poza.clasificacion="Padrillo";
            BD_ProduccionCuyes.registrarPoza(poza);
        }
        for (int j=1;j<=engordeB;j++){
            poza.idPoza="B"+j;
            poza.ancho=150;
            poza.largo=100;
            poza.capacidad=10;
            poza.clasificacion="Engorde";
            BD_ProduccionCuyes.registrarPoza(poza);
        }
        for (int j=1;j<=recriaB;j++){
            poza.idPoza="C"+j;
            poza.ancho=200;
            poza.largo=150;
            poza.capacidad=15;
            poza.clasificacion="Recria";
            BD_ProduccionCuyes.registrarPoza(poza);
        }

        startActivity(i);
    }

    public void CrearPozaManual(View v) {
        Intent i = new Intent(this, C_RegistroPozas.class);
        startActivity(i);
    }
    /*
    }
    public void pozaManualLAH(View v){
        Intent i = new Intent(this,DistriRecomendEmpadre.class);
        startActivity(i);
    }*/
}