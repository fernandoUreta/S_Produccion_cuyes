    package com.example.proyectocuy.AccesoBD;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQLServer {

    public static Connection conectarBD(){
        Connection cnn=null;
        try {
            StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            cnn= DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.103;databaseName=BDProduccionCuyes;user=sa;password=123456;");
            //Conexion AZURE
            //cnn= DriverManager.getConnection("jdbc:jtds:sqlserver://appcuyes.database.windows.net:1433;databasename=BDProduccionCuyes;user=usuario@appcuyes;password=cuyes1000%;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
            //Conexion Google cloud
            //cnn= DriverManager.getConnection("jdbc:jtds:sqlserver://35.193.201.117;databaseName=BDProduccionCuyes;user=sqlserver;password=cuyes1000%;");
        }catch (Exception e){
            return null;
        }
        return cnn;
    }










































}
