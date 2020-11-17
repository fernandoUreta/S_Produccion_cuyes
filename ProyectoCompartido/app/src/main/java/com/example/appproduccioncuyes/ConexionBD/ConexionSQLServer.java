package com.example.appproduccioncuyes.ConexionBD;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQLServer {

    public static Connection conectarBD() {
        Connection cnn = null;
        try {
            StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);

            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            cnn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.103;databaseName=BDProduccionCuyes;user=sa;password=123456;");
        } catch (Exception e) {
            return null;
        }
        return cnn;
    }
}









































}
