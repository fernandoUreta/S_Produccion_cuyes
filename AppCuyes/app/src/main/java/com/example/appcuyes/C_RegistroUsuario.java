package com.example.appcuyes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appcuyes.AccesoDatos.BD_ProduccionCuyes;
import com.example.appcuyes.ConexionBD.ConexionSQLServer;


public class C_RegistroUsuario extends AppCompatActivity implements View.OnClickListener {

    EditText edtNom,edtCel,edtCorreo,edtContra,edtDNI;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        /*
        edtNom=findViewById(R.id.edtCCnombre);
        edtCel=findViewById(R.id.edtCCcelular);
        edtCorreo=findViewById(R.id.edtCCcorreo);
        edtContra=findViewById(R.id.edtCCcontra);
        edtDNI=findViewById(R.id.edtCCDNI);
        btnRegistro=findViewById(R.id.btnCCregistrarse);
        btnRegistro.setOnClickListener(this);
    */
    }

    @Override
    public void onClick(View v) {
       //BD_ProduccionCuyes.registrarUsuario();
    }

}
