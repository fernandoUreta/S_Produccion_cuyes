package com.example.proyectocuy;

import android.widget.Toast;

import com.example.proyectocuy.ConexionBD.ConexionSQLServer;

import java.sql.ResultSet;
import java.sql.Statement;

public class InicioSesion {

    public static Usuarios Consultar(String usuario){
        Usuarios user;
        user=new Usuarios();
        try {
            Statement stm= ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs=stm.executeQuery("SELECT * FROM tblUsuario WHERE usuCorreo ='"+usuario+"'");

            if (rs.next()){
                user.Correo=rs.getString(4);
                user.Contraseña=rs.getString(5);
            }return user;
        }catch (Exception e){
            return null;
        }
    }
}
