package com.example.proyectocuy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class VistaActividades extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    SQLiteDatabase db;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_actividades);
        listView=findViewById(R.id.lsEventos);
        listView.setOnItemLongClickListener(this);

        Bundle bundle=getIntent().getExtras();
        int dia,mes,anio;
        dia=mes=anio=0;
        dia=bundle.getInt("dia");
        mes=bundle.getInt("mes");
        anio=bundle.getInt("anio");
        String cadena=dia+" - "+mes+" - "+anio;

        BDSQLite bd=new BDSQLite(getApplicationContext(),"Agenda",null,1);
        db=bd.getReadableDatabase();

        String sql="select * from eventos where fechadesde='"+cadena+"'";
        Cursor c;
        String nombres,fechadesde,fechahasta,descripcion,ubicacion;
        try {
            c=db.rawQuery(sql,null);
            arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
            if (c.moveToFirst()){
                do {
                    nombres=c.getString(1);
                    ubicacion=c.getString(2);
                    fechadesde=c.getString(3);
                    fechahasta=c.getString(5);
                    descripcion=c.getString(7);
                    arrayAdapter.add(nombres+", "+ubicacion+", "+fechadesde+", "+fechahasta+", "+descripcion);
                }while (c.moveToNext());
                listView.setAdapter(arrayAdapter);
            }else {
                this.finish();
            }
        }catch (Exception ex){
            Toast.makeText(getApplication(), "Error"+ex.getMessage(), Toast.LENGTH_SHORT).show();
            this.finish();
        }
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        CharSequence [] items=new CharSequence[2];
        items[0]="Eliminar Eventos";
        items[1]="Cancelar";
        builder.setTitle("Eliminar Evento").setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==0){
                    eliminar(parent.getItemAtPosition(position).toString());
                }
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
        return false;
    }

    private void eliminar(String dato){

        String []datos=dato.split(", ");
        String sql="delete eventos where concat(nombreEvento,', ',ubicacion,', '," +
                "fechadesde, ', ', fechahasta, ', ', descripcion)='"+dato+"'";
        try {
            arrayAdapter.remove(dato);
            listView.setAdapter(arrayAdapter);
            db.execSQL(sql);
            Toast.makeText(getApplication(), "Evento Eliminado", Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Toast.makeText(getApplication(), "Error: "+ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}