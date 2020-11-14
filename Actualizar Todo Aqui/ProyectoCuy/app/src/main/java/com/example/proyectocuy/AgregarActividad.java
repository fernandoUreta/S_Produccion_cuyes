package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarActividad extends AppCompatActivity implements View.OnClickListener {
    EditText nombreEvento,ubicacion,fechadesde,horadesde,fechahasta,horahasta,descripcion;
    Button guardar,cancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_actividad);
        nombreEvento=findViewById(R.id.edtNombreEvento);
        ubicacion=findViewById(R.id.edtUbicacion);
        fechadesde=findViewById(R.id.edtFechaDesde);
        horadesde=findViewById(R.id.edtHoraInicio);
        fechahasta=findViewById(R.id.edtFechaHasta);
        horahasta=findViewById(R.id.edtHoraHasta);
        descripcion=findViewById(R.id.edtDescripcion);

        Bundle bundle=getIntent().getExtras();
        int dia=0,mes=0,anio=0;
        bundle.getInt("dia");
        bundle.getInt("mes");
        bundle.getInt("anio");
        dia=bundle.getInt("dia");
        mes=bundle.getInt("mes");
        anio=bundle.getInt("anio");


        fechadesde.setText(dia+" - " +mes+" - "+anio);
        fechahasta.setText(dia+" - " +mes+" - "+anio);

        guardar=findViewById(R.id.btnGuardarEvento);
        cancelar=findViewById(R.id.btnCancelarEvento);
        guardar.setOnClickListener(this);
        cancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==guardar.getId()){
            BDSQLite bd= new BDSQLite(getApplication(),"Agenda",null,1);
            SQLiteDatabase db=bd.getWritableDatabase();
            String sql="insert into eventos"+
                    "(nombreEvento, ubicacion, fechadesde, horadesde, fechahasta, horahasta, descripcion) " +
                    "values('" +
                    nombreEvento.getText()+
                    "','"+ubicacion.getText()+
                    "','"+fechadesde.getText()+
                    "','"+horahasta.getText()+
                    "','"+fechahasta.getText()+
                    "','"+horahasta.getText()+
                    "','"+descripcion.getText()+"')";
            try {
                db.execSQL(sql);
                nombreEvento.setText("");
                ubicacion.setText("");
                fechadesde.setText("");
                horadesde.setText("");
                fechahasta.setText("");
                horahasta.setText("");
                descripcion.setText("");
            }catch (Exception e){
                Toast.makeText(getApplication(), "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }else {
            this.finish();
            return;
        }
    }
}