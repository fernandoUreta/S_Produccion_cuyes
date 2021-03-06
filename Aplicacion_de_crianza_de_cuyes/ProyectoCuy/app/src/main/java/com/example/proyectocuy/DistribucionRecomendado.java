package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectocuy.Controller.RegistroPozasManualActivity;
import com.example.proyectocuy.DatosActividades.DatosActividades;
import com.example.proyectocuy.ModeloDatos.Poza;

public class DistribucionRecomendado extends AppCompatActivity {

    double valor1, valor2, valor3, valor4, valor5, valor6, valor7;
    int empradre, engordeB, recriaB, PePadrillo;
    int cantidadPengordeM, cantidadPengordeH, cantRecH, cantRecM;
    int madresMaduras,madresPimerisas,padrillosConver,Total;

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
        btnSiguienteR=findViewById(R.id.btnDRsiguiente);

        String mMadura = getIntent().getStringExtra("Enviando");
        Log.d("hola", mMadura);
        valor1 = Double.parseDouble(mMadura);

        String mPrimerisa = getIntent().getStringExtra("madreP");
        Log.d("hola", mPrimerisa);
        valor2=Integer.parseInt(mPrimerisa);

        madresMaduras=(int)Math.ceil(valor1/10);
        madresPimerisas=(int)Math.ceil(valor2/10);

        empradre=madresMaduras+madresPimerisas;

        String Padrillo = getIntent().getStringExtra("padrillo");
        Log.d("hola", Padrillo);
        valor3=Double.parseDouble(Padrillo);
        padrillosConver=(int)Math.ceil(valor3);
        PePadrillo=padrillosConver-empradre;

        if(PePadrillo<0)
        {PePadrillo=0;}

        String engMacho = getIntent().getStringExtra("engordeMacho");
        Log.d("hola", engMacho);
        valor4=Double.parseDouble(engMacho);
        String engHembra = getIntent().getStringExtra("engordeHembra");
        Log.d("hola", engHembra);
        valor5=Double.parseDouble(engHembra);
        cantidadPengordeM=(int)Math.ceil(valor4/10);
        cantidadPengordeH=(int)Math.ceil(valor5/10);
        engordeB=cantidadPengordeM+cantidadPengordeH;

        String recMacho = getIntent().getStringExtra("recriaMacho");
        Log.d("hola", recMacho);
        valor6=Double.parseDouble(recMacho);
        String recHembra = getIntent().getStringExtra("recriaHembra");
        Log.d("hola", recHembra);
        valor7=Double.parseDouble(recHembra);
        cantRecH=(int)Math.ceil(valor6/10);
        cantRecM=(int)Math.ceil(valor7/10);
        recriaB=cantRecH+cantRecM;

        Total=empradre+PePadrillo+engordeB+recriaB;

        pozEmpadre.setText(String.valueOf(empradre));
        pozPadrillo.setText(String.valueOf(PePadrillo));
        pozEngorde.setText(String.valueOf(engordeB));
        pozRecria.setText(String.valueOf(recriaB));

        totalpozas.setText(String.valueOf(Total));

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
        Intent i = new Intent(this, RegistroPozasManualActivity.class);
        i.putExtra("show_nextButtom",true);
        startActivity(i);
    }
}