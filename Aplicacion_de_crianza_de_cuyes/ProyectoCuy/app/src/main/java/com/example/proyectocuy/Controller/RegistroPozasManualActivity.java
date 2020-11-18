package com.example.proyectocuy.Controller;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.proyectocuy.AccesoBD.BD_AccesoDatos;
import com.example.proyectocuy.ModeloDatos.Poza;
import com.example.proyectocuy.R;
import com.example.proyectocuy.Tools.Mensaje;


public class RegistroPozasManualActivity extends AppCompatActivity {

    TextView tvCantidadPozas;
    Spinner spTiposPozas;
    EditText etAncho,etLargo,etCantidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_pozas_manual);
        showToolbar("Registro de pozas",true);

        //Declarado
        tvCantidadPozas=(TextView)findViewById(R.id.tvCantidadPozas);

        etAncho=(EditText)findViewById(R.id.etAncho);
        etLargo=(EditText)findViewById(R.id.etLargo);
        etCantidad=(EditText)findViewById(R.id.etCantidad);

        limpiarCampos();
        etAncho.setText("");
        etLargo.setText("");
        etCantidad.setText("");

        //Declarado y Llenado del spinner
        spTiposPozas = (Spinner) findViewById(R.id.spTipoPozas);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipos_pozas, R.layout.spinner_formato);
        spTiposPozas.setAdapter(adapter);


        //INICIALIZAR
        actualizarTotal();

    }


    public void btnInfoClick(View v)
    {
        String titulo="",mensaje="";

        switch (spTiposPozas.getSelectedItem().toString())
        {
            case "Empadre":titulo="Poza de empadre";mensaje="Para reproducción, gestación y parto, el ancho mínimo es de 60cm y el largo mínimo recomendado es 80cm";
                break;
            case "Engorde":titulo="Poza de engorde";mensaje="Destinados para ventas o consumos,el ancho mínimo es de 60cm y el largo mínimo recomendado es 80cm ";
                break;
            case "Recria":titulo="Poza de recría";mensaje="Destinado al desarrollo de cuyes pequeños, el ancho mínimo es de 60cm y el largo mínimo recomendado es 80cm";
                break;
            case "Padrillo":titulo="Poza para Padrillo";mensaje="Es de corto tamaño y solo se permite un macho padrillo, el ancho mínimo recomendado puede ser 30cm";
                break;
        }
        openDialog(titulo,mensaje);

    }
    public void btnAgregarClick(View v)
    {
        if (TextUtils.isEmpty(etCantidad.getText().toString().trim())||TextUtils.isEmpty(etLargo.getText().toString().trim())||
                TextUtils.isEmpty(etAncho.getText().toString().trim()))
        {
            Toast.makeText(this,"Ingrese todos los valores",Toast.LENGTH_LONG).show();
        }
        else
        {
            registrarPozas();
            limpiarCampos();
            actualizarTotal();
        }
    }

    public void registrarPozas()
    {
        String identificador="";
        int capacidad=0;
        switch (spTiposPozas.getSelectedItem().toString())
        {
            case "Empadre":{identificador="A";capacidad=51;}break;
            case "Engorde":{identificador="B";capacidad=15;}break;
            case "Recría":{identificador="C";capacidad=20;}break;
            case "Padrillo":{identificador="D";capacidad=1;}break;
        }
        int idLast= BD_AccesoDatos.consultarIdPoza(identificador,this);
        int idstart=idLast+1;
        for (int i = 1; i <=Integer.parseInt(etCantidad.getText().toString()) ; i++)
        {
            Poza poza =new Poza();
            idLast++;
            poza.idPoza=identificador+idLast;
            poza.ancho=Float.parseFloat(etAncho.getText().toString());
            poza.largo=Float.parseFloat(etLargo.getText().toString());
            poza.clasificacion=spTiposPozas.getSelectedItem().toString();
            poza.capacidad=capacidad;
            BD_AccesoDatos.registrarPoza(poza,this);
            poza=null;
        }
        openDialog("Confirmación","Se habilitarón los códigos desde " +
                identificador+idstart+" hasta "+identificador+idLast);
    }

    public void actualizarTotal()
    {
        tvCantidadPozas.setText(String.valueOf(BD_AccesoDatos.consultarCantidadPozas(this)));
    }
    public void openDialog(String titulo, String mensaje)
    {
        Mensaje dialogInfoCuy=new Mensaje(titulo,mensaje);
        dialogInfoCuy.show(getSupportFragmentManager(),"Informative dialog");
    }
    public void showToolbar(String tittle, Boolean upButton)
    {
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
    public void limpiarCampos()
    {
        etCantidad.setText("");
        etAncho.setText("");
        etLargo.setText("");
        tvCantidadPozas.setText("");
    }
}