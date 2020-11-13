package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectocuy.ModeloDatos.Cuy;
import com.example.proyectocuy.Recursos_Adicionales.Fechas;

public class PozRecriaRecomend extends AppCompatActivity {
    int contador =0;
    int conta=1,cuyTotal=1;
    String texto;
    Button boton;
    TextView cajaTexto;

    TextView cantidaPozas;
    int valor1,padriguardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poz_recria_recomend);
        cantidaPozas=findViewById(R.id.txtPRCantidad);

        cajaTexto=findViewById(R.id.txtTipoPozaRecria);
        boton=findViewById(R.id.btnSave);

        String recria = getIntent().getStringExtra("pozRecriEnvior");
        Log.d("hola", recria);

        valor1=Integer.parseInt(recria);
        cantidaPozas.setText(String.valueOf(valor1));

        String padrillo=getIntent().getStringExtra("pozPadriEnvior");
        Log.d("hola1",padrillo);
        padriguardar=Integer.parseInt(padrillo);

        cajaTexto.setText("C1");
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
    public void pulsarBotonRe(View v){
        Cuy cuy=new Cuy();
        if (contador<valor1){
            contador ++;
            conta++;
            cajaTexto.setText("C"+conta);
            texto="C"+contador;
            if (cajaTexto.getText().toString().matches("C2")||cajaTexto.getText().toString().matches("C3")){
                for (int i=1;i<=valor1*2.5;i++){
                    cuy.cuyId="CRM"+cuyTotal;
                    cuy.idPoza=texto;
                    cuy.categoria="6";
                    cuy.genero="Macho";
                    cuy.fechaNaci= Fechas.calcularFechaNacimiento(15);
                    BD_ProduccionCuyes.registrarCuy(cuy);
                    cuyTotal++;
                }
            }else {
                for (int i=1;i<=valor1*2.5;i++){
                    cuy.cuyId="CRH"+cuyTotal;
                    cuy.idPoza=texto;
                    cuy.categoria="7";
                    cuy.genero="Hembra";
                    cuy.fechaNaci= Fechas.calcularFechaNacimiento(15);
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