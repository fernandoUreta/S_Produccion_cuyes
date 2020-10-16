package com.example.appcuyes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.appcuyes.AccesoDatos.BD_ProduccionCuyes;
import com.example.appcuyes.ModeloDatos.Poza;
import com.example.appcuyes.Recursos_Adicionales.ExampleDialog;

public class C_RegistroPozas extends AppCompatActivity {

    Spinner tiposPozas;
    EditText txtAncho,txtLargo,txtCantidad,txtCantidadPozasCreadas;
    Button btnRegistrar,btnMasInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_pozas);

        //Declarado y Llenado del spinner
        tiposPozas = (Spinner) findViewById(R.id.spTipodePoza);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipos_pozas, android.R.layout.simple_spinner_item);
        tiposPozas.setAdapter(adapter);

        //Declarar botones
        btnRegistrar = (Button) findViewById(R.id.btnAgregar);
        btnRegistrar.setOnClickListener(btnGuardarClick);

        btnMasInfo = (Button) findViewById(R.id.btnMasInfo);
        btnMasInfo.setOnClickListener(btnMasInfoCLick);

        //Declarar entradas de texto
        txtAncho = (EditText) findViewById(R.id.txtAncho);
        txtLargo = (EditText) findViewById(R.id.txtLargo);
        txtCantidad = (EditText) findViewById(R.id.txtCantidad);
        txtCantidadPozasCreadas = (EditText) findViewById(R.id.txtCantidadPozasTotal);
        actualizarTotal();
    }

    private View.OnClickListener btnMasInfoCLick = new View.OnClickListener() {
        public void onClick(View v) {

            String titulo="";
            String mensaje="";

            switch (tiposPozas.getSelectedItem().toString())
            {
                case "Empadre":titulo="Poza de empadre";mensaje="Para reproducción, gestación y parto, el ancho mínimo es de 60cm y el largo mínimo recomendado es 80cm";
                    break;
                case "Engorde":titulo="Poza de engorde";mensaje="Destinados para ventas o consumos,el ancho mínimo es de 60cm y el largo mínimo recomendado es 80cm ";
                    break;
                case "Recria":titulo="Poza de recria";mensaje="Destinado al desarrollo de cuyes pequeños, el ancho mínimo es de 60cm y el largo mínimo recomendado es 80cm";
                    break;
                case "Padrillo":titulo="Poza para Padrillo";mensaje="Es de corto tamaño y solo se permite un macho padrillo, el ancho mínimo recomendado puede ser 30cm";
                    break;
            }
            openDialog(titulo,mensaje);

        }
    };

    public  void openDialog(String titulo,String mensaje)
    {
        ExampleDialog exampleDialog=new ExampleDialog(titulo,mensaje);
        exampleDialog.show(getSupportFragmentManager(),"example dialog");
    }

    private View.OnClickListener btnGuardarClick = new View.OnClickListener() {
        public void onClick(View v) {

            switch (tiposPozas.getSelectedItem().toString())
            {
                case "Empadre":registrarPozas("A",10);
                    break;
                case "Engorde":registrarPozas("B",10);
                    break;
                case "Recria":registrarPozas("C",15);
                    break;
                case "Padrillo":registrarPozas("D",1);
                    break;
            }
            limpiarTextos();
            actualizarTotal();
        }
    };

    public void limpiarTextos()
    {
        txtCantidadPozasCreadas.setText("");
        txtCantidad.setText("");
        txtLargo.setText("");
        txtAncho.setText("");
    }


    public void registrarPozas(String tipo, int capacidad)
    {
        for (int i = 1; i <=Integer.parseInt(txtCantidad.getText().toString()) ; i++)
        {
            Poza poza =new Poza();
            poza.idPoza=tipo+i;
            poza.ancho=Float.parseFloat(txtAncho.getText().toString());
            poza.largo=Float.parseFloat(txtLargo.getText().toString());
            poza.clasificacion=tiposPozas.getSelectedItem().toString();
            poza.capacidad=capacidad;
            BD_ProduccionCuyes.registrarPoza(poza);
            poza=null;
        }

    }
    public void actualizarTotal()
    {
        txtCantidadPozasCreadas.setText(String.valueOf(BD_ProduccionCuyes.consultarCantidadPozas()));
    }


}