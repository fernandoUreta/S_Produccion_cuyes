package com.example.proyectocuy;
import com.example.proyectocuy.ConexionBD.ConexionSQLServer;
import com.example.proyectocuy.ModeloDatos.Cuy;
import com.example.proyectocuy.ModeloDatos.Poza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD_ProduccionCuyes {

    //Pozas
    public static boolean registrarPoza(Poza poza)
    {
        boolean v;
        try {
            PreparedStatement pst= ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_A_tblPozas '"+
                    poza.idPoza+"',"+
                    poza.largo+
                    ","+poza.ancho+
                    ",'"+poza.clasificacion+
                    "',"+poza.capacidad);
            pst.executeUpdate();
            v=true;
        }catch (SQLException e){
            v=false;
        }
        return v;
    }
    public static Poza consultarPoza(String idPoza)
    {
        Poza poza=new Poza();
        try {
            Statement stm=ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs=stm.executeQuery("EXEC SP_C_tblPozas "+idPoza);
            if (rs.next()){
                poza.idPoza=rs.getString(1);
                poza.largo=Float.parseFloat(rs.getString(2));
                poza.ancho=Float.parseFloat(rs.getString(3));
                poza.clasificacion=rs.getString(4);
                poza.capacidad=Integer.parseInt(rs.getString(5));
            }
            return poza;
        }catch (Exception e){
            return null;
        }
    }

    public static boolean eliminarPoza(String idPoza)
    {
        boolean v;
        try {
            PreparedStatement pst=ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_E_tblPozas "+idPoza);
            pst.executeUpdate();
            v=true;
        }catch (SQLException e){
            v=false;
        }
        return v;
    }

    public static boolean actualizarPoza(Poza poza)
    {
        boolean v;
        try {
            PreparedStatement pst=ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_M_tblPozas '"+poza.idPoza+
                    "',"+poza.largo+","+poza.ancho+",'"+poza.clasificacion+"',"+ poza.capacidad);
            pst.executeUpdate();
            v=true;
        }catch (SQLException e){
            v=false;
        }
        return v;
    }

    public static int consultarCantidadPozas()
    {
        try {
            Statement stm=ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs=stm.executeQuery("EXEC SP_MostrarTotalPozas ");
            if (rs.next()){
                return rs.getInt(1);
            }
            return 0;
        }catch (Exception e){
            return 0;
        }
    }
    //Fin Pozas

    //Cuyes
    public static boolean registrarCuy(Cuy cuy)
    {
        boolean v;
        try {
            PreparedStatement pst= ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_A_tblCuyes " +
                    "'"+cuy.cuyId+"','"+cuy.idPoza+"','"+cuy.categoria+"','"+cuy.genero+"','"+cuy.fechaNaci+"'");
            pst.executeUpdate();
            v=true;
        }catch (SQLException e){
            v=false;
        }
        return v;
    }

}
