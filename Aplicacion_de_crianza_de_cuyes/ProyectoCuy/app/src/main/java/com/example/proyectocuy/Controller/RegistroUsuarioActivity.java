package com.example.proyectocuy.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectocuy.AccesoBD.ConexionSQLServer;
import com.example.proyectocuy.MainActivity;
import com.example.proyectocuy.R;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegistroUsuarioActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtNom,edtCel,edtCorreo,edtContra,edtDNI,edtConfirContra;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        edtNom=findViewById(R.id.edtCCnombre);
        edtCel=findViewById(R.id.edtCCcelular);
        edtCorreo=findViewById(R.id.edtCCcorreo);
        edtContra=findViewById(R.id.edtCCcontra);
        edtDNI=findViewById(R.id.edtCCDNI);
        btnRegistro=findViewById(R.id.btnCCregistrarse);
        edtConfirContra=findViewById(R.id.edtCCconfirContra);
        btnRegistro.setOnClickListener(this);

    }

    public void agregarUsuario(){

        try {
            if(validarDatos()==true)
            {
                PreparedStatement pst= ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_A_tblUsuario ?,?,?,?,?");
                pst.setString(1,edtDNI.getText().toString());
                pst.setString(2,edtNom.getText().toString());
                pst.setString(3,edtCel.getText().toString());
                pst.setString(4,edtCorreo.getText().toString());
                pst.setString(5,edtContra.getText().toString());
                pst.executeUpdate();

                Toast.makeText(getApplicationContext(),"REGISTRO AGREGADO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(this, MainActivity.class);
                startActivity(i);
            }
          }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    private boolean validarDatos() {
        if (TextUtils.isEmpty(edtDNI.getText().toString().trim())
                || TextUtils.isEmpty(edtNom.getText().toString().trim())
                || TextUtils.isEmpty(edtCel.getText().toString().trim())
                || TextUtils.isEmpty(edtCorreo.getText().toString().trim())
                || TextUtils.isEmpty(edtContra.getText().toString().trim()))
        {
            Toast.makeText(this,"Ingrese los valores solicitados",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(edtDNI.length()!=8)
        { Toast.makeText(this,"El DNI debe tener 8 caracteres",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (edtCel.length()!=9) {
            Toast.makeText(this, "El número de contacto debe tener 9 caracteres", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (edtContra.length()<8) {
            Toast.makeText(this, "La contraseña debe tener como mínimo 8 caracteres", Toast.LENGTH_SHORT).show();
        return false;
        }
        else if (edtContra.getText().toString().equals(edtConfirContra.getText().toString())) {
            return true;
        }
        else {
            Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
            return false;
            }
    }

    @Override
    public void onClick(View v) {
        agregarUsuario();
    }
}