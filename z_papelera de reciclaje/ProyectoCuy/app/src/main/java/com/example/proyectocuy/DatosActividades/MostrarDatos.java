package com.example.proyectocuy.DatosActividades;

import android.content.Intent;
import android.util.Log;
import android.widget.Switch;

import com.example.proyectocuy.DistribucionRecomendado;
import com.example.proyectocuy.MainActivity;

public class MostrarDatos {
    public static DatosActividades consultar(String lanzar){
        DatosActividades datos;
        datos=new DatosActividades();
        try {

            datos.Engorde="1";
            datos.Padrillo="1";
            datos.Empadre="1";
            datos.Recria="1";
            return datos;
        }catch (Exception e){
            return null;
        }
    }
}
