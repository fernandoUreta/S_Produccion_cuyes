package com.example.appproduccioncuyes.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appproduccioncuyes.ConexionBD.BD_ProduccionCuyes;
import com.example.appproduccioncuyes.ModeloDatos.ActividadCardview;
import com.example.appproduccioncuyes.R;
import com.example.appproduccioncuyes.RecyclerViewAdaptador;

import java.util.ArrayList;
import java.util.List;

public class ActividadesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewActividad;
    private RecyclerViewAdaptador adaptadorActividad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        recyclerViewActividad=(RecyclerView)findViewById(R.id.recyclerActividad);
        recyclerViewActividad.setLayoutManager(new LinearLayoutManager(this));

        //Obtener list de Actividades
        adaptadorActividad=new RecyclerViewAdaptador(obtenerActividadesEmpadre());
        adaptadorActividad=new RecyclerViewAdaptador(obtenerActividadesRetiroMadre());

        recyclerViewActividad.setAdapter(adaptadorActividad);
    }

    public List<ActividadCardview>obtenerActividadesEmpadre() {
        List<ActividadCardview> actividad;
        actividad=BD_ProduccionCuyes.obtenerCuyesLimiteEdadEnPoza("Empadre",30);
        return actividad;
    }

    //Actualizar
    public List<ActividadCardview>obtenerActividadesRetiroMadre() {
        List<ActividadCardview> actividad;
        actividad=BD_ProduccionCuyes.obtenerCuyesLimiteEdadEnPoza("Recría","",30);
        return actividad;
    }

}