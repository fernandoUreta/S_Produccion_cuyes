package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.proyectocuy.ModeloDatos.Cuy;
import com.example.proyectocuy.Recursos_Adicionales.Fechas;



public class PozEmpadreRecomend extends AppCompatActivity {
    int contador =0;
    int conta=1,cuyTotal=1,cuyMa=1,cuyLact=1;
    String texto;
    Button boton;
    TextView cajaTexto, pruebita;
    TextView cantidadPozas;
    EditText cantidadGazapos;
    int valor1,engordeguarda,recriaguarda,padrilloguarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poz_empadre_recomend);

        boton=findViewById(R.id.btnSave);
        cajaTexto=findViewById(R.id.txtClasiPozEmpa);
        cantidadGazapos=findViewById(R.id.edtCCregistro);
        pruebita=findViewById(R.id.txtPruebita);

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
        cajaTexto.setText("A1");
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

    public void pulsarBoton(View v){
        int a;
        Cuy cuy=new Cuy();
        a=Integer.parseInt(cantidadGazapos.getText().toString());
        if (contador<valor1){
            contador ++;
            conta ++;
            cajaTexto.setText("A"+conta);
            texto="A"+contador;
            int acuPadri=cuyTotal++;
            cantidadGazapos.setText("");
            for (int i=1;i<=valor1/valor1;i++){
                cuy.cuyId="CP"+acuPadri;
                cuy.idPoza=texto;
                cuy.categoria="3";
                cuy.genero="Macho";
                cuy.fechaNaci= Fechas.calcularFechaNacimiento(80);
                BD_ProduccionCuyes.registrarCuy(cuy);
            }
            for (int i=1;i<=a;i++){
                cuy.cuyId="CG"+cuyLact;
                cuy.idPoza=texto;
                cuy.categoria="8";
                cuy.genero="Macho";
                cuy.fechaNaci= Fechas.calcularFechaNacimiento(80);
                BD_ProduccionCuyes.registrarCuy(cuy);
                cuyLact++;
            }
            if (cajaTexto.getText().toString().matches("A2")||cajaTexto.getText().toString().matches("A3")){
                for (int i=1;i<=valor1*2.5;i++){
                    cuy.cuyId="CMM"+cuyMa;
                    cuy.idPoza=texto;
                    cuy.categoria="1";
                    cuy.genero="Hembra";
                    cuy.fechaNaci= Fechas.calcularFechaNacimiento(80);
                    BD_ProduccionCuyes.registrarCuy(cuy);
                    cuyMa++;
                }
            }else {
                for (int i=1;i<=valor1*2.5;i++){
                    cuy.cuyId="CMP"+cuyMa;
                    cuy.idPoza=texto;
                    cuy.categoria="2";
                    cuy.genero="Hembra";
                    cuy.fechaNaci= Fechas.calcularFechaNacimiento(80);
                    BD_ProduccionCuyes.registrarCuy(cuy);
                    cuyMa++;
                }
            }
        }else {
            cajaTexto.setText("Registro Completo");
            Toast.makeText(this, "Registro completo. Pulse siguiente", Toast.LENGTH_SHORT).show();
        }
    }
}