package com.example.appproduccioncuyes.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.appproduccioncuyes.ConexionBD.BD_ProduccionCuyes;
import com.example.appproduccioncuyes.ModeloDatos.Actividad;
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

        adaptadorActividad=new RecyclerViewAdaptador(obtenerActividades());
        recyclerViewActividad.setAdapter(adaptadorActividad);
    }

    public List<ActividadCardview>obtenerActividades() {
        List<ActividadCardview> actividad=new ArrayList<>();
        actividad.add(new ActividadCardview("C1","A1",50));
        return actividad;
    }

}