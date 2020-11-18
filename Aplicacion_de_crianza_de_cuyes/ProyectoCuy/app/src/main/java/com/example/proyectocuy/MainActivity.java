package com.example.proyectocuy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectocuy.ConexionBD.ConexionSQLServer;
import com.example.proyectocuy.ModeloDatos.Poza;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int RC_SIGN_IN = 0;
    EditText usuario,contraseña;
    GoogleSignInClient mGoogleSignInClient;

    SignInButton SignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //captura el dato que ingresa
        usuario=findViewById(R.id.edtIScorreo);
        contraseña=findViewById(R.id.edtIScontraseña);

        obtenerPozaBD();

        SignIn= findViewById(R.id.sign_in_button);
        SignIn.setOnClickListener(this);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Set the dimensions of the sign-in button.
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        findViewById(R.id.sign_in_button).setOnClickListener(this);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea salir de la aplicación?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void Registrar(View v){
        Intent i = new Intent(this,InicioCorreo.class);
        startActivity(i);
    }
    public void RecuperarContraseña(View v){
        Intent i = new Intent(this,ContrasenaOlvidada.class);
        startActivity(i);
    }
    public void AutentificarIngresar(View v){
        Intent i = new Intent(this,RegistroCuy.class);
        Usuarios user=new Usuarios();
        user=InicioSesion.Consultar(usuario.getText().toString());
        try {
            if (usuario.getText().toString().matches(user.Correo.replace(" ",""))){
                if (contraseña.getText().toString().matches(user.Contraseña.replace(" ",""))){
                    startActivity(i);
                }else {
                    Toast.makeText(this, "Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, "Usuario no existe", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Toast.makeText(this, "Usuario No existe", Toast.LENGTH_SHORT).show();
        }
    }
    public List<Poza> obtenerPozaBD(){
        List<Poza> poza=new ArrayList<>();
        try {
            Statement st= ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs=st.executeQuery("select * from tblPozas where ID_Pozas like 'A%'");
            while (rs.next()){
                poza.add(new Poza(rs.getString("ID_Pozas"),rs.getFloat("Dimen_L"),rs.getFloat("Dimen_A"),rs.getInt("pozCapacidadCuyes"),rs.getString("pozClasificacion")));
            }
            return poza;
        }catch (SQLException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return poza;
    }

    public void Consultar(View v){
        Intent i = new Intent(this,Usuario.class);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sign_in_button:
                signIn();
                break;
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            Intent i = new Intent( MainActivity.this,ConsultarUsuario.class);
            startActivity(i);
        } catch (ApiException e) {

            Log.w("Error", "signInResult:failed code=" + e.getStatusCode());
        }
    }
}