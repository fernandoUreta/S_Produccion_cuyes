package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InicioCorreo extends AppCompatActivity implements View.OnClickListener {
    EditText edtNom,edtCel,edtCorreo,edtContra,edtDNI;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_correo);
        edtNom=findViewById(R.id.edtCCnombre);
        edtCel=findViewById(R.id.edtCCcelular);
        edtCorreo=findViewById(R.id.edtCCcorreo);
        edtContra=findViewById(R.id.edtCCcontra);
        edtDNI=findViewById(R.id.edtCCDNI);
        btnRegistro=findViewById(R.id.btnCCregistrarse);
        btnRegistro.setOnClickListener(this);
    }

    public void agregarUsuario(){
        try {

            PreparedStatement pst= Conexion.conectarBD().prepareStatement("insert into tblUsuario values(?,?,?,?,?)");
            pst.setString(1,edtDNI.getText().toString());
            pst.setString(2,edtNom.getText().toString());
            pst.setString(3,edtCel.getText().toString());
            pst.setString(4,edtCorreo.getText().toString());
            pst.setString(5,edtContra.getText().toString());
            pst.executeUpdate();

            Toast.makeText(getApplicationContext(),"REGISTRO AGREGADO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        agregarUsuario();
    }
}