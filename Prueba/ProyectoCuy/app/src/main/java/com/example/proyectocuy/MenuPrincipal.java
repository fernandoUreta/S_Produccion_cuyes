package com.example.proyectocuy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.proyectocuy.Controller.Menu_general_pozasActivity;

public class MenuPrincipal extends AppCompatActivity {
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        showToolbar("Menu Principal",false);
        init();
        String usuario =preferences.getString("usuario_id",null);
        String contraseña=preferences.getString("contraseña_id",null);

        if (usuario !=null && contraseña !=null){
            Toast.makeText(this, "Bienvenido "+usuario, Toast.LENGTH_SHORT).show();
        }
    }

    public void btnPozas(View v){
        Intent i = new Intent(this, Menu_general_pozasActivity.class);
        startActivity(i);
    }
    public void btnCalendario(View v){
        Intent i = new Intent(this, Calendario.class);
        startActivity(i);
    }
    public void btnReporte(View v){
        Intent i = new Intent(this, MenuReportes.class);
        startActivity(i);
    }
    public void showToolbar(String tittle, Boolean upButton)
    {
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
    private void init(){
        preferences=getSharedPreferences("Preferences",MODE_PRIVATE);
    }
    public void cerrarSesion(){
        preferences.edit().clear().apply();
        irLogin();
    }
    private void irLogin(){
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id== R.id.action_salir){
            finish();
            System.exit(0);
        }else if (id== R.id.action_cerrar_sesion){
            cerrarSesion();
        }
        return super.onOptionsItemSelected(item);
    }
}