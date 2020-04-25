package com.udgs123.ungdungadmin;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectHelper {
    String IP,DB, DBUserName, DBPassword;
    @SuppressLint("NewApi")
    public Connection connections () {
        //From your Local or website
        DB = "Vidua";
        DBUserName = "sa";
        DBPassword = "123";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        java.sql.Connection connection = null;
        String ConnectionURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL="jdbc:jtds:sqlserver://192.168.1.4" + ";databaseName=" + DB + ";user=" + DBUserName + ";password=" + DBPassword + ";";
            connection = DriverManager.getConnection(ConnectionURL);
        } catch (SQLException se) {
            Log.e("Error From SQL", se.getMessage());
        }
        catch (ClassNotFoundException e) {
            Log.e("Error From Class", e.getMessage());
        }
        catch (Exception e) {
            Log.e("Error From Exception", e.getMessage());
        }
        return connection;
    }
}
