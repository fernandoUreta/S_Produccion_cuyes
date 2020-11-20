package com.example.proyectocuy.Controller;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.proyectocuy.BD_ProduccionCuyes;
import com.example.proyectocuy.ModeloDatos.Cuy;
import com.example.proyectocuy.ModeloDatos.Poza;
import com.example.proyectocuy.ModeloDatos.Transaccion;
import com.example.proyectocuy.R;
import com.example.proyectocuy.Tools.Transacciones;


public class C_RegistroSalidaCuyes extends AppCompatActivity {

    EditText txtID,txtIdPozaDestino;
    TextView txtIdPoza, txtCantidadMadres,txtCantidadPadrillo, txtCantidadLactantes,txtEdad;
    Spinner cmbTipoSalida, cmbCategoria;

    //AUTOCOMPLETADOS DEL ACTIVITY ANTERIOR

    Poza poza=new Poza();

    String usuarioID="72941896";
    String idPoza="A1";

    //DATOS
    Transaccion transaccion;
    Cuy cuy=new Cuy();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_salida_cuyes);
        showToolbar("Ingreso de cuyes",true);

        //Declarado de textos
        txtID=(EditText)findViewById(R.id.txtCodigoCuy);
        txtEdad=(TextView) findViewById(R.id.txtEdad);
        txtIdPoza=(TextView)findViewById(R.id.txtIdPoza);
        txtCantidadMadres=(TextView)findViewById(R.id.txtCantidadMadres);
        txtCantidadPadrillo=(TextView)findViewById(R.id.txtCantidadPadres);
        txtCantidadLactantes=(TextView)findViewById(R.id.txtCantidadLactantes);
        txtIdPozaDestino=(EditText)findViewById(R.id.txtIdPozaDestino);

        //Declarado y llenado de spiners

        cmbTipoSalida=(Spinner)findViewById(R.id.cmbTipoSalida);
        ArrayAdapter<CharSequence> adapterTipoSalida=ArrayAdapter.createFromResource(this, R.array.tipoSalidaCuy,android.R.layout.simple_spinner_item);
        cmbTipoSalida.setAdapter(adapterTipoSalida);

        cmbCategoria=(Spinner)findViewById(R.id.cmbCategoriaCuy);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.categoriasCuy, android.R.layout.simple_spinner_item);
        cmbCategoria.setAdapter(adapter);

        //////////////////////////////////////////////////////////////////////////////////////
        Bundle pozaRecibida=getIntent().getExtras();
        if(pozaRecibida!=null)
        {
            poza= (Poza) pozaRecibida.getSerializable("poza");
        }

        //Mostrar datos de cuyes en la poza
        cargarDatos(poza.getIdPoza());

        //Genera transaccion para ese instante
        transaccion= Transacciones.generarTransaccion(usuarioID);

    }

    public void registrarClick(View view)
    {
        this.cuy=consultarCuy(txtID.getText().toString());
        String categoria=cuy.getCategoria();
        switch (categoria)
        {
            case "MM":cmbCategoria.setSelection(0);break;
            case "MP":cmbCategoria.setSelection(1);break;
            case "PD":cmbCategoria.setSelection(2);break;
            case "EG":cmbCategoria.setSelection(3);break;
            case "RC":cmbCategoria.setSelection(4);break;
            case "LC":cmbCategoria.setSelection(5);break;
        }
        txtEdad.setText(String.valueOf(cuy.fechaNaci));

        Transacciones.RegistrarSalidaCuyes(cuy,transaccion,txtIdPozaDestino.getText().toString(),cmbTipoSalida.getSelectedItem().toString(),this);
        restablecerCampos();
        cargarDatos(idPoza);
    }

    public Cuy consultarCuy(String idCuy)
    {
        Cuy cuy;
        cuy= BD_ProduccionCuyes.consultarCuy(idCuy);
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
        txtIdPozaDestino.setText("");
    }
    public void showToolbar(String tittle, Boolean upButton)
    {
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }


}
