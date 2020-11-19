package com.example.proyectocuy;

import com.example.proyectocuy.AccesoBD.ConexionSQLServer;

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
                user.correo =rs.getString(4).replace(" ","");
                user.contraseña =rs.getString(5).replace(" ","");
            }return user;
        }catch (Exception e){
            return null;
        }
    }
}
