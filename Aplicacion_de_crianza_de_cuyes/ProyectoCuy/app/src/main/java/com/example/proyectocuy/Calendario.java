package com.example.proyectocuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.proyectocuy.Adapter.ActividadesAdapter;
import com.example.proyectocuy.ModeloDatos.Actividad;
import com.example.proyectocuy.Tools.AdministradorActividades;

import java.util.List;

public class Calendario extends AppCompatActivity implements CalendarView.OnDateChangeListener{
    CalendarView calendarView;
    private RecyclerView rvActividades;
    private ActividadesAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        showToolbar("Calendario",true);
        calendarView=findViewById(R.id.Calendario);
        calendarView.setOnDateChangeListener(this);

        //RecyclerView
        rvActividades = findViewById(R.id.rvActividades);
        rvActividades.setLayoutManager(new LinearLayoutManager(this));

        mAdapter=new ActividadesAdapter(this,llenarLista());
        rvActividades.setAdapter(mAdapter);
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        CharSequence [] items=new CharSequence[3];
        items[0]="Agregar evento";
        items[1]="ver eventos";
        items[2]="Cancelar";


        final int dia,mes,anio;
        dia=dayOfMonth;
        mes=month+1;
        anio=year;


        builder.setTitle("Seleccione una tarea").setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==0){
                    Intent intent=new Intent(getApplication(),AgregarActividad.class);
                    Bundle bundle= new Bundle();
                    bundle.putInt("dia",dia);
                    bundle.putInt("mes",mes);
                    bundle.putInt("anio",anio);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else if(which==1){
                    Intent intent=new Intent(getApplication(),VistaActividades.class);
                    Bundle bundle= new Bundle();
                    bundle.putInt("dia",dia);
                    bundle.putInt("mes",mes);
                    bundle.putInt("anio",anio);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    return;
                }
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    public List<Actividad> llenarLista()
    {
        List<Actividad> actividades;
        AdministradorActividades admAct=new AdministradorActividades(getApplicationContext());
        actividades=admAct.getActividadesAll();
        return actividades;
    }
    public void showToolbar(String tittle, Boolean upButton)
    {
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}