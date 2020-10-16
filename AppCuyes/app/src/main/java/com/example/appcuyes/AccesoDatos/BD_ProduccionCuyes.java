package com.example.appcuyes.AccesoDatos;
import android.widget.Toast;

import com.example.appcuyes.ModeloDatos.*;
import com.example.appcuyes.ConexionBD.ConexionSQLServer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD_ProduccionCuyes {

    //Pozas
    public static boolean registrarPoza(Poza poza) {
        try {
            PreparedStatement pst = ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_A_tblPozas '" +
                    poza.idPoza + "'," +
                    poza.largo +
                    "," + poza.ancho +
                    ",'" + poza.clasificacion +
                    "'," + poza.capacidad);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static Poza consultarPoza(String idPoza) {
        Poza poza = new Poza();
        try {
            Statement stm = ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs = stm.executeQuery("EXEC SP_C_tblPozas " + idPoza);
            if (rs.next()) {
                poza.idPoza = rs.getString(1);
                poza.largo = Float.parseFloat(rs.getString(2));
                poza.ancho = Float.parseFloat(rs.getString(3));
                poza.clasificacion = rs.getString(4);
                poza.capacidad = Integer.parseInt(rs.getString(5));
            }
            return poza;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean eliminarPoza(String idPoza) {
        try {
            PreparedStatement pst = ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_E_tblPozas " + idPoza);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean actualizarPoza(Poza poza) {

        try {
            PreparedStatement pst = ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_M_tblPozas '" + poza.idPoza +
                    "'," + poza.largo + "," + poza.ancho + ",'" + poza.clasificacion + "'," + poza.capacidad);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static int consultarCantidadPozas() {
        try {
            Statement stm = ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs = stm.executeQuery("EXEC SP_MostrarTotalPozas ");
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
    //Fin Pozas

    //Cuyes
    public static boolean registrarCuy(Cuy cuy) {
        try {
            PreparedStatement pst = ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_A_tblCuyes " +
                    "'" + cuy.cuyId + "','" + cuy.idPoza + "','" + cuy.categoria + "','" + cuy.genero + "','" + cuy.fechaNaci + "'");
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean registrarUsuario(Usuario usuario) {
        try {

            PreparedStatement pst = ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_A_tblUsuario '" + usuario.id_usuario + "'" +
                    ",'" + usuario.nombres + "'" +
                    ",'" + usuario.numeroContacto + "'" +
                    ",'" + usuario.correo + "'" +
                    ",'" + usuario.clave + "'");
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static Usuario consultarUsuario(String id) {
        Usuario usuario = new Usuario();
        try {
            Statement stm = ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs = stm.executeQuery("EXEC SP_c_tblUsuario " + id);
            if (rs.next()) {
                usuario.id_usuario = rs.getString(1);
                usuario.nombres = rs.getString(2);
                usuario.numeroContacto = rs.getString(3);
                usuario.correo = rs.getString(4);
                usuario.clave = rs.getString(5);
            }
            return usuario;
        } catch (Exception e) {
            return null;
        }
    }

    public  static boolean  eliminarUsuario(String id)
    {
        try {
            PreparedStatement pst = ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_E_tblUsuario " +id);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public  static boolean actualizarUsuario(Usuario usuario)
    {
        try {
            PreparedStatement pst = ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_M_tblUsuario '"+usuario.id_usuario+"'," +
                    "'"+usuario.nombres+"'," +
                    "'"+usuario.numeroContacto+"'," +
                    "'"+usuario.correo+"'," +
                    "'"+usuario.clave+"'");
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }


}
