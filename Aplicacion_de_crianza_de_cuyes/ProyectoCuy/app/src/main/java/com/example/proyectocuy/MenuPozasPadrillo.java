package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.proyectocuy.Adaptador.ExpPCAdapter;
import com.example.proyectocuy.Adaptador.ExpPCAdapterPad;
import com.example.proyectocuy.ModeloDatos.Poza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuPozasPadrillo extends AppCompatActivity {
    private ExpandableListView expLV;
    private ExpPCAdapterPad adapter;
    private ArrayList<String> listCategoria;
    private Map<String,ArrayList<String>> mapChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pozas_padrillo);
        showToolbar("Pozas de padrillos",true);
        expLV=(ExpandableListView) findViewById(R.id.expLV);
        listCategoria=new ArrayList<>();
        mapChild = new HashMap<>();


        cargarDatos();
        
    }

    private void cargarDatos() {
        ArrayList<String> listaA1=new ArrayList<>();

        for (int i=1;i<=BD_ProduccionCuyes.consultarCantidadPozasPadrillo();i++){
            listCategoria.add("D"+i);
        }

        listaA1.add("1");
        for (int i=0;i<BD_ProduccionCuyes.consultarCantidadPozasPadrillo();i++){
            mapChild.put(listCategoria.get(i),listaA1);
        }

        adapter=new ExpPCAdapterPad(listCategoria, mapChild, this);
        expLV.setAdapter(adapter);
    }
    public void showToolbar(String tittle, Boolean upButton)
    {
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}