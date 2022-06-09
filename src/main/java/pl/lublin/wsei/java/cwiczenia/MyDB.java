package pl.lublin.wsei.java.cwiczenia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class MyDB {


private String datab;
private String servName;
private String usero;
private Number portNum;
private String pass;
private Connection conn = null;

public MyDB(String serverName, String database, Number portNumber){
    this.servName = serverName;
    this.datab = database;
    this.portNum = portNumber;
}
public void setUser(String user){
    this.usero = user;
}
public void setPassword(String password) {
    this.pass = password;
}
private void connect(){
    Properties connectionProps = new Properties();
    connectionProps.put("user", usero);
    connectionProps.put("password", pass);
    connectionProps.put("serverTimezone", "Europe/Warsaw");

    String jdbcString = "jdbc:mysql://" + usero + ":" + portNum + "/" +datab;
    try {
        conn = DriverManager.getConnection(
                jdbcString, connectionProps);
    }
    catch (SQLException e){
        System.out.println("Błąd połączenia do bazy: "+datab);
        System.out.println("Komunikat błędu: "+e.getMessage());
        conn = null;
    }
    System.out.println("Connected to database "+datab);
}

    public Connection getConnection() {
    if (conn == null)
        connect();
        return conn;
    }
}
