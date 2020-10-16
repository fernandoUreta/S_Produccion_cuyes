package com.example.proyectocuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class ConsultarUsuario extends AppCompatActivity implements View.OnClickListener {
    ImageView imagen;
    TextView nombre,email,id,nombre1,nombre2;
    Button SignOut;

    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuario);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);;

        imagen=findViewById(R.id.imgLPPrueba);
        nombre=findViewById(R.id.txtLPNombre);
        nombre1=findViewById(R.id.txtLPNombre1);
        nombre2=findViewById(R.id.txtLPNombre2);
        email=findViewById(R.id.txtLPEmail);
        id=findViewById(R.id.txtLPId);
        SignOut=findViewById(R.id.button_sign_out);
        SignOut.setOnClickListener(this);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();

            nombre.setText(personName);
            nombre1.setText(personGivenName);
            nombre2.setText(personFamilyName);
            email.setText(personEmail);
            id.setText(personId);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sign_out:
                signOut();
                break;
        }
    }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ConsultarUsuario.this,"Signed out successfully",Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
    }
}