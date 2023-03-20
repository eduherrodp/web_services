package com.empresa.proyecto.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.print("No se conecto a la abse de datos");
        }
    }
    
    public Connection getConecction(){
        System.out.print("Se conecto a la abse de datos");
        return con;
    }
}
