package com.example.proyectocuy;

import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.Statement;

public class InicioSesion {

    public static Usuarios Consultar(String usuario){
        Usuarios user;
        user=new Usuarios();
        try {
            Statement stm= Conexion.conectarBD().createStatement();
            ResultSet rs=stm.executeQuery("SELECT * FROM tblUsuario WHERE usuCorreo ='"+usuario+"'");

            if (rs.next()){
                user.Correo=rs.getString(4);
                user.Contraseña=rs.getString(5);

                user.Correo=String.valueOf(user.Correo);
                user.Contraseña=String.valueOf(user.Contraseña);
            }return user;
        }catch (Exception e){
            return null;
        }
    }
}
