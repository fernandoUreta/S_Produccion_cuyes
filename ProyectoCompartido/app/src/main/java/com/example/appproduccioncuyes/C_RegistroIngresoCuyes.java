package com.example.appproduccioncuyes;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appproduccioncuyes.ConexionBD.BD_ProduccionCuyes;
import com.example.appproduccioncuyes.Gestion.Transacciones;
import com.example.appproduccioncuyes.ModeloDatos.Cuy;
import com.example.proyectocuy.ModeloDatos.Transaccion;
import com.example.proyectocuy.Recursos_Adicionales.Fechas;

public class C_RegistroIngresoCuyes extends AppCompatActivity {

    EditText txtID,txtEdad;
    TextView txtIdPoza, txtCantidadMadres,txtCantidadPadrillo, txtCantidadLactantes;
    Spinner cmbTipoIngreso, cmbCategoria,cmbGenero;

    //AUTOCOMPLETADOS DEL ACTIVITY ANTERIOR
    String usuarioID="72941896";
    String idPoza="A1";

    //df
    Transaccion transaccion;
    int idTransaccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ingreso_cuyes_a_pozas);

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

    //////////////////////////////////////////////////////////////////////////////////////

        //Mostrar datos de cuyes en la poza
        cargarDatos(idPoza);

        //Genera transaccion para ese instante
        transaccion= Transacciones.generarTransaccion(usuarioID);



    }

    public void registrarClick(View view)
    {
        Transacciones.RegistrarEntradaCuyes(capturarCuy(),transaccion,cmbTipoIngreso.getSelectedItem().toString());
        cargarDatos(idPoza);
        restablecerCampos();
    }

    //Registro de ingreso de cuy
    private Cuy capturarCuy()
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
        cuy.setFechaNaci(Fechas.calcularFechaNacimiento(Integer.parseInt(txtEdad.getText().toString())));

        return cuy;
    }

    //Carga datos sobre la cantidad de cuyes de la BD
    private void cargarDatos(String idPoza)
    {
        txtCantidadMadres.setText(String.valueOf(BD_ProduccionCuyes.consultarCantiTipoCuyPoza(idPoza,"MM")));
        txtCantidadLactantes.setText(String.valueOf(BD_ProduccionCuyes.consultarCantiTipoCuyPoza(idPoza,"LC")));
        txtCantidadPadrillo.setText(String.valueOf(BD_ProduccionCuyes.consultarCantiTipoCuyPoza(idPoza,"PD")));
    }

    //Restablece las entradas de texto
    public void restablecerCampos()
    {
        txtID.setText("");
        txtEdad.setText("");
    }

    //Validar entradas
    public void validarEntradas()
    {
        if (txtID.getText().toString()=="")
            Toast.makeText(this,"Debe ingresar un ID",Toast.LENGTH_SHORT).show();
    }


}
