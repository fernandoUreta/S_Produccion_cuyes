package com.example.pdf.AccesoBD;


import android.content.Context;
import android.widget.Toast;


import com.example.pdf.FilaReporte;
import com.example.pdf.ModeloDatos.Actividad;
import com.example.pdf.ModeloDatos.Poza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BD_AccesoDatos {

    //Pozas
    public static void registrarPoza(Poza poza, Context context) {
        try {
            PreparedStatement pst = ConexionSQLServer.conectarBD().prepareStatement("EXEC SP_A_tblPozas '" +
                    poza.getIdPoza() + "'," +
                    poza.getLargo() +
                    "," + poza.getAncho() +
                    ",'" + poza.getClasificacion() +
                    "'," + poza.getCapacidad());
            pst.executeUpdate();
        } catch (SQLException e) {
            Toast.makeText(context, "Error: " + e.toString(), Toast.LENGTH_LONG).show();
        }
    }


    public static int consultarCantidadPozas(Context context)
    {
        try {
            Statement stm=ConexionSQLServer.conectarBD().createStatement();
            ResultSet rs=stm.executeQuery("EXEC SP_MostrarTotalPozas");
            if (rs.next()){
                return rs.getInt(1);
            }
            return 0;
        }catch (Exception e){
            Toast.makeText(context,"Error: "+e.toString(),Toast.LENGTH_LONG);
            return 0;
        }
    }

//Obtener pozas con cuyes en maxima edad
public static List<Actividad> obtenerCuyesLimiteEdadEnPoza(String tipoCuy, String tipoPoza, int edadLimite, String descripcion, Context context)
{
    List<Actividad> actividad=new ArrayList<>();
    try {
        Statement stm=ConexionSQLServer.conectarBD().createStatement();
        ResultSet rs=stm.executeQuery("EXEC SP_C_CuyesEdadMax '"+tipoCuy+"','"+tipoPoza+"',"+edadLimite);
        while (rs.next()){
            actividad.add(new Actividad(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),descripcion));
        }
    }catch (Exception e) {
        Toast.makeText(context,"Error: ",Toast.LENGTH_LONG);
    }
    return actividad;
}
public static List<FilaReporte> reporte(String tipoReporte,Context context)
{
    List<FilaReporte> report=new ArrayList<>();
    try {
        Statement stm=ConexionSQLServer.conectarBD().createStatement();
        ResultSet rs=stm.executeQuery("EXEC SP_ConsultarReporte "+tipoReporte);
        while (rs.next()){
            report.add(new FilaReporte(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)));
        }
    }catch (Exception e){
        Toast.makeText(context,e.toString(),Toast.LENGTH_LONG).show();
        report=null;
    }
    return report;
}

}



