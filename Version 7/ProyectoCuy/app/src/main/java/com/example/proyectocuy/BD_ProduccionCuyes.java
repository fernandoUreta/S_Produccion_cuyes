package com.example.proyectocuy;
import com.example.proyectocuy.ConexionBD.ConexionSQLServer;
import com.example.proyectocuy.ModeloDatos.Cuy;
import com.example.proyectocuy.ModeloDatos.Poza;
import com.example.proyectocuy.ModeloDatos.Transaccion;

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

    //Fin cuyes

    //Transacciones
    public static boolean registrarTransaccion(Transaccion transaccion)
    {
        try {
            PreparedStatement pst= ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_A_tblTransaccion '"+transaccion.getIdTransaccion()+"'," +
                    "'"+transaccion.getIdUsuario()+"'," +
                    "'"+transaccion.getFecha()+"'");
            pst.executeUpdate();
            return true;
        }catch (SQLException e){
            return false;
        }

    }

    public static int consultarUltimaTransaccion()
    {
        try {
            Statement stm=ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs=stm.executeQuery("EXEC SP_C_UltimoID");
            if (rs.next()){
                return rs.getInt(1);
            }
            else return -1;
        }catch (Exception e){
            return -1;
        }
    }

    public static Transaccion consultarTransaccion(String idTransaccion)
    {
        Transaccion transaccion=new Transaccion();
        try {
            Statement stm=ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs=stm.executeQuery("EXEC SP_C_tblTransaccion "+idTransaccion);
            if (rs.next()){
                transaccion.setIdTransaccion(rs.getInt(1));
                transaccion.setIdUsuario(rs.getString(2));
                transaccion.setFecha(rs.getDate(3));
            }
            return transaccion;
        }catch (Exception e){
            return null;
        }
    }

    public static boolean eliminarTransaccion(String idTransaccion)
    {
        boolean v;
        try {
            PreparedStatement pst=ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_E_tblTransaccion "+idTransaccion);
            pst.executeUpdate();
            v=true;
        }catch (SQLException e){
            v=false;
        }
        return v;
    }

    public static boolean actualizarTransaccion(Transaccion transaccion)
    {
        try {
            PreparedStatement pst=ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_M_tblTransaccion "+transaccion.getIdTransaccion()+
                    ","+transaccion.getIdUsuario()+
                    ",'"+transaccion.getFecha()+"'");
            pst.executeUpdate();
            return true;
        }catch (SQLException e){
            return false;
        }
    }

    public static int consultarCantiTipoCuyPoza(String idPoza,String idCatCuy)
    {
        int cantidad=0;
        try {
            Statement stm=ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs=stm.executeQuery("EXEC SP_C_CantiCuyes_Poza_Tipo_tblPozas '"+idPoza+"','"+idCatCuy+"'");
            if (rs.next()){
                cantidad=Integer.parseInt(rs.getString(1));
            }
            return cantidad;
        }catch (Exception e){
            return 0;
        }
    }
    //Fin transacciones


    //Detalle transacciones

    public static boolean registrarDetalle(String transaID,String cuyID,String TipoMovi)
    {
        boolean v;
        try {
            PreparedStatement pst= ConexionSQLServer.conectarBD().prepareStatement("");
            pst.executeUpdate();
            v=true;
        }catch (SQLException e){
            v=false;
        }
        return v;
    }


    /*
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
    }*/
}
