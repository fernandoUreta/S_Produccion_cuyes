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
import com.example.proyectocuy.ModeloDatos.Cuy;
import com.example.proyectocuy.Recursos_Adicionales.Fechas;

public class PozEngordeRecomend extends AppCompatActivity {
    int contador =0;
    int conta=1,cuyTotal=1;
    String texto;
    Button boton;
    TextView cajaTexto;

    TextView cantidaPozas;
    int valor1,recguar,padriguar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poz_engorde_recomend);
        cantidaPozas=findViewById(R.id.txtPEnRcantidad);

        cajaTexto=findViewById(R.id.txtTipoPoza);
        boton=findViewById(R.id.btnSave);

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
        cajaTexto.setText("B1");

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
    public void pulsarBotongu(View v){
        Cuy cuy=new Cuy();
        if (contador<valor1){
            contador ++;
            conta++;
            cajaTexto.setText("B"+conta);
            texto="B"+contador;
            if (cajaTexto.getText().toString().matches("B2")||cajaTexto.getText().toString().matches("B3")){
                for (int i=1;i<=valor1*2.5;i++){
                    cuy.cuyId="CEM"+cuyTotal;
                    cuy.idPoza=texto;
                    cuy.categoria="EG";
                    cuy.genero="Macho";
                    cuy.fechaNaci= Fechas.calcularFechaNacimiento(35);
                    BD_ProduccionCuyes.registrarCuy(cuy);
                    cuyTotal++;
                }
            }else {
                for (int i=1;i<=valor1*2.5;i++){
                    cuy.cuyId="CEH"+cuyTotal;
                    cuy.idPoza=texto;
                    cuy.categoria="EG";
                    cuy.genero="Hembra";
                    cuy.fechaNaci= Fechas.calcularFechaNacimiento(35);
                    BD_ProduccionCuyes.registrarCuy(cuy);
                    cuyTotal++;
                }
            }



        }else {
            cajaTexto.setText("Registro Completo");
            Toast.makeText(this, "Registro completo. Pulse siguiente", Toast.LENGTH_SHORT).show();
        }

    }
}