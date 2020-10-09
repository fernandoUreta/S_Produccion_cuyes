package ControlPozas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControlPozas {


    public boolean registrarPoza(Poza poza)
    {
        boolean v;
        try {
            PreparedStatement pst=Conexion.conectarBD().prepareStatement("INSERT INTO tblPozas VALUES " +
                    "('"+poza.idPoza+"'," +
                    "'"+poza.largo+"'," +
                    "'"+poza.ancho+"'," +
                    "'"+poza.altura+"'," +
                    "'"+poza.clasificacion+"'," +
                    "'"+poza.capacidad+"')");
            pst.executeUpdate();
            v=true;
        }catch (SQLException e){
            v=false;
        }
        return v;
    }
    public Poza consultarPoza(String idPoza)
    {
        Poza poza=new Poza();
        try {
            Statement stm=Conexion.conectarBD().createStatement();
            ResultSet rs=stm.executeQuery("SELECT * FROM tblPozas WHERE ID_Pozas='"+idPoza+"'");
            if (rs.next()){
                poza.idPoza=rs.getString(1);
                poza.largo=Float.parseFloat(rs.getString(2));
                poza.ancho=Float.parseFloat(rs.getString(3));
                poza.altura=Float.parseFloat(rs.getString(4));
                poza.clasificacion=rs.getString(5);
                poza.capacidad=Integer.parseInt(rs.getString(6));
            }
            return poza;
        }catch (Exception e){
            return null;
        }
    }

    public boolean eliminarPoza(String idPoza)
    {
        boolean v;
        try {
            PreparedStatement pst=Conexion.conectarBD().prepareStatement("DELETE FROM tblPozas WHERE ID_Pozas='"
                    +idPoza+"'");
            pst.executeUpdate();
            v=true;
        }catch (SQLException e){
            v=false;
        }
        return v;
    }

    public boolean actualizarPoza(Poza poza)
    {
        boolean v;
        try {
            PreparedStatement pst=Conexion.conectarBD().prepareStatement("UPDATE tblPozas SET " +
                    "Dimen_L='"+poza.largo+"'," +
                    "Dimen_A='"+poza.ancho+"'," +
                    "Dimen_H='"+poza.altura+"'," +
                    "pozClasificacion='"+poza.clasificacion+"'," +
                    "pozCapacidadCuyes='"+poza.capacidad+"'" +
                    "WHERE ID_Pozas='"+poza.idPoza+"'");
            pst.executeUpdate();
            v=true;
        }catch (SQLException e){
            v=false;
        }
        return v;
    }
}
