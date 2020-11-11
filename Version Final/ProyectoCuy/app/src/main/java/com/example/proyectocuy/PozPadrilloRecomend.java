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

public class PozPadrilloRecomend extends AppCompatActivity {
    int contador =0;
    int conta=1,cuyTotal=1;
    String texto;
    Button boton;
    TextView cajaTexto;

    TextView cantidaPozas;
    int valor1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poz_padrillo_recomend);
        cantidaPozas=findViewById(R.id.txtPRPCantidad);

        cajaTexto=findViewById(R.id.txtTipoPozaPadrillo);
        boton=findViewById(R.id.btnSave);

        String padrillo = getIntent().getStringExtra("pozPadriEnvioFinal");
        Log.d("hola", padrillo);

        valor1=Integer.parseInt(padrillo);
        cantidaPozas.setText(String.valueOf(valor1));
        cajaTexto.setText("D1");
    }
    public void btnAtras(View v){
        Intent i = new Intent(this,PozRecriaRecomend.class);
        startActivity(i);
    }
    public void btnSiguiente(View v){
        Intent i = new Intent(this,MenuPrincipal.class);
        startActivity(i);
    }
    public void pulsarBotonPa(View v){
        Cuy cuy=new Cuy();
        if (contador<valor1){
            contador ++;
            conta++;
            cajaTexto.setText("D"+conta);
            texto="D"+contador;
            for (int i=1;i<=valor1/valor1;i++){
                cuy.cuyId="CPM"+cuyTotal;
                cuy.idPoza=texto;
                cuy.categoria="3";
                cuy.genero="Macho";
                cuy.fechaNaci= Fechas.calcularFechaNacimiento(15);
                BD_ProduccionCuyes.registrarCuy(cuy);
                cuyTotal++;
            }
        }else {
            cajaTexto.setText("Registro Completo");
            Toast.makeText(this, "Registro completo. Pulse siguiente", Toast.LENGTH_SHORT).show();
        }

    }
}