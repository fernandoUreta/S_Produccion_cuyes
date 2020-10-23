package com.example.proyectocuy;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectocuy.ModeloDatos.Cuy;
import com.example.proyectocuy.ModeloDatos.Transaccion;
import com.example.proyectocuy.Recursos_Adicionales.Fechas;

import org.w3c.dom.Text;

public class C_RegistroIngresoCuyes extends AppCompatActivity {

    EditText txtID,txtEdad;
    TextView txtIdPoza, txtCantidadMadres,txtCantidadPadrillo, txtCantidadLactantes;
    Spinner cmbTipoIngreso, cmbCategoria,cmbGenero;
    Button btnAgregar;
    String usuarioID="72941896";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ingreso_cuyes);

        //Declarado de textos
        txtID=(EditText)findViewById(R.id.txtCodigoCuy);
        txtEdad=(EditText)findViewById(R.id.txtEdad);
        txtIdPoza=(TextView)findViewById(R.id.txtIdPoza);
        txtCantidadMadres=(TextView)findViewById(R.id.txtCantidadMadres);
        txtCantidadPadrillo=(TextView)findViewById(R.id.txtCantidadPadres);
        txtCantidadLactantes=(TextView)findViewById(R.id.txtCantidadLactantes);

        //Declarado y llenado de spiners

        cmbTipoIngreso=(Spinner)findViewById(R.id.cmbTipoIngreso);
        ArrayAdapter<CharSequence> adapterTipoIngreso = ArrayAdapter.createFromResource(this, R.array.tipoIngresoCuy, android.R.layout.simple_spinner_item);
        cmbTipoIngreso.setAdapter(adapterTipoIngreso);

        cmbCategoria=(Spinner)findViewById(R.id.cmbCategoriaCuy);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.categoriasCuy, android.R.layout.simple_spinner_item);
        cmbCategoria.setAdapter(adapter);

        cmbGenero=(Spinner)findViewById(R.id.cmbGenero);
        ArrayAdapter<CharSequence> adapterGenero = ArrayAdapter.createFromResource(this, R.array.generos, android.R.layout.simple_spinner_item);
        cmbGenero.setAdapter(adapterGenero);

        //Declarado de boton
        btnAgregar=(Button)findViewById(R.id.btnAgregar);

        //Mostrar datos de cuyes en la poza
        cargarDatos("A1");

        //Genera transaccion para ese instante
        generarTransaccion();

        //Registra ingreso de cuyes
        registrarCuy();

        //Añade al cuy al detalle de la transaccion



    }

    //Carga datos sobre la cantidad de cuyes de la BD
    private void cargarDatos(String idPoza)
    {
        txtCantidadMadres.setText(String.valueOf(BD_ProduccionCuyes.consultarCantiTipoCuyPoza(idPoza,"MM")));
        txtCantidadLactantes.setText(String.valueOf(BD_ProduccionCuyes.consultarCantiTipoCuyPoza(idPoza,"LC")));
        txtCantidadPadrillo.setText(String.valueOf(BD_ProduccionCuyes.consultarCantiTipoCuyPoza(idPoza,"PD")));
    }


    //Registro de nuevoCuy
    private void registrarCuy()
    {
        Cuy cuy=new Cuy();
        cuy.setCuyId(txtID.getText().toString());
        cuy.setIdPoza(txtIdPoza.getText().toString());
        switch (cmbCategoria.getSelectedItem().toString())
        {
            case "Madre madura":cuy.setCategoria("MM");break;
            case "Madre primeriza":cuy.setCategoria("MP");break;
            case "Padrillo":cuy.setCategoria("PD");break;
            case "Engorde":cuy.setCategoria("EG");break;
            case "Recria":cuy.setCategoria("EC");break;
            case "Lactante":cuy.setCategoria("LC");break;
        }
        cuy.setGenero(cmbGenero.getSelectedItem().toString());
        //cuy.setFechaNaci(Fechas.calcularFechaNacimiento(Integer.parseInt(txtEdad.getText().toString())));

        //BD_ProduccionCuyes.registrarDetalle("1",cuy.cuyId,"IN");
    }

    private void generarTransaccion()
    {
        try {
            Transaccion transaccion=new Transaccion();
            transaccion.setIdUsuario(usuarioID);
            transaccion.setFecha(Fechas.mostrarFechaHoy());
            if (BD_ProduccionCuyes.registrarTransaccion(transaccion)==false)
                throw new Exception("Ocurrio un error");
            else
            Toast.makeText(this,"generado correctamente",Toast.LENGTH_SHORT).show();
        }catch (Exception e)
        {
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }


}
