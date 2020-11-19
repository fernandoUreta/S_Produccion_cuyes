package com.example.appproduccioncuyes.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appproduccioncuyes.ModeloDatos.Cuy;
import com.example.appproduccioncuyes.ModeloDatos.Poza;
import com.example.appproduccioncuyes.R;
import com.example.appproduccioncuyes.Recursos_Adicionales.Fechas;
import com.google.android.material.textfield.TextInputEditText;

public class IngresoCuyesAPozasActivity extends AppCompatActivity {


    Spinner spTipoIngreso, spCategoria, spGenero;
    TextView tvCantidadCuyes1, tvCantidadCuyes2, tvCantidadCuyes3;
    TextView tvDesc1, tvDesc2, tvDesc3, tvTipoPoza;
    TextInputEditText txtCodigo, txtEdad;

    String[]generos;

    Poza poza=new Poza();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_cuyes_a_pozas);

        //Asignacion
        spTipoIngreso=findViewById(R.id.spTipoIngreso);
        spCategoria=findViewById(R.id.spCategoria);
        spGenero=findViewById(R.id.spGenero);

        tvCantidadCuyes1 =(TextView) findViewById(R.id.tvCantidadCuy1);
        tvCantidadCuyes2 =(TextView)findViewById(R.id.tvCantidadCuy2);
        tvCantidadCuyes3 =(TextView)findViewById(R.id.tvCantidadCuy3);

        txtCodigo=(TextInputEditText)findViewById(R.id.txtCodigoCuy);
        txtEdad=(TextInputEditText)findViewById(R.id.txtEdadCuy);

        tvDesc1=(TextView)findViewById(R.id.tvDescCategoria1);
        tvDesc2=(TextView)findViewById(R.id.tvDescCategoria2);
        tvDesc3=(TextView)findViewById(R.id.tvDescCategoria3);
        tvTipoPoza=(TextView)findViewById(R.id.tvTipoPoza);

        ArrayAdapter<CharSequence> adapterTipoIngreso = ArrayAdapter.createFromResource(this, R.array.tipoIngresoCuy,R.layout.spinner_formato);
        spTipoIngreso.setAdapter(adapterTipoIngreso);

        ArrayAdapter<CharSequence> adapterCategoria = ArrayAdapter.createFromResource(this, R.array.categoriasCuy,R.layout.spinner_formato);
        spCategoria.setAdapter(adapterCategoria);

        try {
            poza.setClasificacion("Recría Hembra");
          
            adaptarInterfaz(poza);

            spGenero.setAdapter(new ArrayAdapter<String>(this,R.layout.spinner_formato,generos));
        }catch (Exception e){
            Toast.makeText(this,"Error: "+e.toString(),Toast.LENGTH_LONG).show();
        }

        
        //-----------------------------------------------------------
    }

    public void registrarClick(View view)
    {
        try {

            Toast.makeText(this,"Registrado",Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            Toast.makeText(this,"Error: "+e.toString(),Toast.LENGTH_LONG).show();
        }

    }

    private Cuy capturarDatosCuy()
    {
        Cuy cuy=new Cuy();
        try {
                if(txtCodigo.getText().toString()!="") {
                    cuy.setCuyId(txtCodigo.getText().toString());
                }else {}
                if (txtEdad.getText().toString()!=""&&Integer.parseInt(txtEdad.getText().toString())!=0){
                    cuy.setFechaNaci(Fechas.calcularFechaNacimiento(Integer.parseInt(txtEdad.getTextLocales().toString())));
                }else {}

        }catch (Exception e){
            Toast.makeText(this,"Revise los campos ingresados",Toast.LENGTH_LONG).show();
        }
        cuy.setCuyId("");
        return cuy;
    }

    private void cargarDatos(String idPoza, String categoriaPoza)
    {
        tvCantidadCuyes1.setText("01");
        tvCantidadCuyes2.setText("02");
        tvCantidadCuyes3.setText("03");
    }

    private void adaptarInterfaz(Poza poza) {
       try {
           tvTipoPoza.setText(poza.getClasificacion());

           tvDesc1.setVisibility(View.INVISIBLE);
           tvCantidadCuyes1.setVisibility(View.INVISIBLE);

           tvDesc2.setVisibility(View.INVISIBLE);
           tvCantidadCuyes2.setVisibility(View.INVISIBLE);

           tvDesc3.setVisibility(View.INVISIBLE);
           tvCantidadCuyes3.setVisibility(View.INVISIBLE);

           switch (poza.getClasificacion())
           {
               case "Empadre": {

                   tvDesc1.setText("Madres");
                   tvDesc2.setText("Padrillos");
                   tvDesc3.setText("Lactantes");

                   generos=new String[2];

                   this.generos[0]="Macho";
                   this.generos[1]="Hembra";

                   tvDesc1.setVisibility(View.VISIBLE);
                   tvCantidadCuyes1.setVisibility(View.VISIBLE);
                   tvDesc2.setVisibility(View.VISIBLE);
                   tvCantidadCuyes2.setVisibility(View.VISIBLE);
                   tvDesc3.setVisibility(View.VISIBLE);
                   tvCantidadCuyes3.setVisibility(View.VISIBLE);
               }break;
               case "Padrillo":{
                   tvDesc1.setText("Padrillos");
                   generos=new String[1];
                   tvDesc1.setVisibility(View.VISIBLE);
                   tvCantidadCuyes1.setVisibility(View.VISIBLE);
                   this.generos[0]="Macho";

               }break;
               case "Recría Macho":{
                   tvDesc1.setText("Machos");
                   generos=new String[1];
                   tvDesc1.setVisibility(View.VISIBLE);
                   tvCantidadCuyes1.setVisibility(View.VISIBLE);
                   this.generos[0]="Macho";
               }break;
               case "Recría Hembra":{
                   tvDesc1.setText("Hembras");
                   generos=new String[1];
                   tvDesc1.setVisibility(View.VISIBLE);
                   tvCantidadCuyes1.setVisibility(View.VISIBLE);
                   this.generos[0]="Hembra";
               }break;
               case "Engorde Macho":{
                   tvDesc1.setText("Machos engorde");
                   generos=new String[1];
                   tvDesc1.setVisibility(View.VISIBLE);
                   tvCantidadCuyes1.setVisibility(View.VISIBLE);
                   this.generos[0]="Macho";
               }break;
               case "Engorde Hembra":{
                   tvDesc1.setText("Hembras engorde");
                   generos=new String[1];
                   tvDesc1.setVisibility(View.VISIBLE);
                   tvCantidadCuyes1.setVisibility(View.VISIBLE);
                   this.generos[0]="Hembra";
               }break;
           }

       }catch (Exception e)
       {
           Toast.makeText(this,"Error: "+e.toString(),Toast.LENGTH_LONG).show();
       }


    }

}