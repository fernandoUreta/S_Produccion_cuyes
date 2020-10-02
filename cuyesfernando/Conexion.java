package com.sosda.cuyesfernando;

import android.os.StrictMode;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection conectarBD(){
        Connection cnn=null;
        try {
            StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);

            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            cnn= DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.5.103;databaseName=BDProduccionCuyes;user=sa;password=12345678;");
        }catch (Exception e){
            return null;
        }
        return cnn;
    }
}
