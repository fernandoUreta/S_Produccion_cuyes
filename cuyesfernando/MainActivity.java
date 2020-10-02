package com.sosda.cuyesfernando;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ControlPozas cpoza=new ControlPozas();
        Poza poza=new Poza();

        //EJEMPLO DE INSERCIÓN DE POZAS
        poza.idPoza="FER";
        poza.largo=20;
        poza.ancho=20;
        poza.altura=20;
        poza.clasificacion="Padrillos";
        poza.capacidad=20;
        cpoza.registrarPoza(poza);

        //EJEMPLO DE CONSULTA DE POZA
        String idPoza="";
        poza=cpoza.consultarPoza(idPoza);
        






    }

}

