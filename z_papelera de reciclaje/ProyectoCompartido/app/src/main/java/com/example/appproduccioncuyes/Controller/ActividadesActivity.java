    package com.example.appproduccioncuyes.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.appproduccioncuyes.ConexionBD.BD_ProduccionCuyes;
import com.example.appproduccioncuyes.ModeloDatos.Actividad;
import com.example.appproduccioncuyes.MyAdapter;
import com.example.appproduccioncuyes.R;

import java.util.ArrayList;
import java.util.List;

public class ActividadesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        obtenerActividadesEmpadre();
    }

    public List<Actividad>obtenerActividadesEmpadre() {
        List<Actividad> actividad;
        actividad=BD_ProduccionCuyes.obtenerCuyesLimiteEdadEnPoza("Empadre",30);
        Toast.makeText(this,"Valor: "+actividad.get(1).getCuyId(),Toast.LENGTH_LONG);
        return actividad;
    }



}