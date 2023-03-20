/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.examen.connection;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author eduhe
 */

public class ConexionMySQL {
    private static ConexionMySQL instancia;
    private final Connection conexion;

    private ConexionMySQL(String url, String usuario, String contrasena) throws SQLException {        
        conexion = DriverManager.getConnection(url, usuario, contrasena);
    }
    
    public static ConexionMySQL getInstance() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        instancia = new ConexionMySQL("jdbc:mysql://localhost:3306/ws_examen", "root", "");
    
        return instancia;
    }
    
    /**
     *
     * @return
     */
    public Connection obtenerConexion() {
        return conexion;
    }
}