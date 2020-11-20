package com.example.proyectocuy;

import com.example.proyectocuy.AccesoBD.ConexionSQLServer;
import com.example.proyectocuy.ModeloDatos.Cuy;
import com.example.proyectocuy.ModeloDatos.Poza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Poza> obtenerPozaBD(){
        List<Poza> poza=new ArrayList<>();
        try {
            Statement st= ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs=st.executeQuery("select * from tblPozas where ID_Pozas like 'A%'");
            while (rs.next()){
                poza.add(new Poza(rs.getString("ID_Pozas"),rs.getFloat("Dimen_L"),
                        rs.getFloat("Dimen_A"),rs.getInt("pozCapacidadCuyes"),
                        rs.getString("pozClasificacion")));
            }
        }catch (SQLException e){
            return null;
        }
        return poza;
    }



    public static int consultarCantidadPozasEmpadre()
    {
        try {
            Statement stm=ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs=stm.executeQuery("select count(*) from tblPozas where ID_Pozas like 'A%'");
            if (rs.next()){
                return rs.getInt(1);
            }
            return 0;
        }catch (Exception e){
            return 0;
        }
    }
    public static int consultarCantidadPozasEngorde()
    {
        try {
            Statement stm=ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs=stm.executeQuery("select count(*) from tblPozas where ID_Pozas like 'B%'");
            if (rs.next()){
                return rs.getInt(1);
            }
            return 0;
        }catch (Exception e){
            return 0;
        }
    }
    public static int consultarCantidadPozasRecria()
    {
        try {
            Statement stm=ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs=stm.executeQuery("select count(*) from tblPozas where ID_Pozas like 'C%'");
            if (rs.next()){
                return rs.getInt(1);
            }
            return 0;
        }catch (Exception e){
            return 0;
        }
    }
    public static int consultarCantidadPozasPadrillo()
    {
        try {
            Statement stm=ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs=stm.executeQuery("select count(*) from tblPozas where ID_Pozas like 'D%'");
            if (rs.next()){
                return rs.getInt(1);
            }
            return 0;
        }catch (Exception e){
            return 0;
        }
    }
    public static int consultarReporteCuy(String idpoza)
    {
        try {
            Statement stm=ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs=stm.executeQuery("EXEC SP_C_ReporteCuy '"+idpoza+"'");
            if (rs.next()){
                return rs.getInt(1);
            }else {
                return 0;
            }
        }catch (Exception e){
            return 0;
        }
    }

    public static Cuy consultarCuy(String cuyID)
    {
        Cuy cuy=new Cuy();
        try {
            Statement stm=ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs=stm.executeQuery("EXEC SP_C_tblCuyes '"+cuyID+"'");
            if (rs.next()){
                cuy.setCuyId(rs.getString(1));
                cuy.setIdPoza(rs.getString(2));
                cuy.setCategoria(rs.getString(3));
                cuy.setGenero(rs.getString(4));
                cuy.setFechaNaci(rs.getDate(5));
            }
            return cuy;
        }catch (Exception e){
            return null;
        }

    }

    public static boolean registrarCuy(Cuy cuy)
    {
        boolean v;
        try {
            PreparedStatement pst= ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_A_tblCuyes1 " +
                    "'"+cuy.cuyId+"','"+cuy.idPoza+"','"+cuy.categoria+"','"+cuy.genero+"','"+cuy.fechaNaci+"'");
            pst.executeUpdate();
            v=true;
        }catch (SQLException e){
            v=false;
        }
        return v;
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

}
