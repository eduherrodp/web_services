/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.examen.db_pkg;

import com.empresa.examen.connection.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private static final String SELECT_BY_ID_QUERY = "SELECT p.id, p.nombre, p.precio, f.nombre AS nombre_fabricante FROM productos p INNER JOIN fabricante f ON p.id_fabricante = f.id WHERE p.id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT p.id, p.nombre, p.precio, f.nombre AS nombre_fabricante FROM productos p INNER JOIN fabricante f ON p.id_fabricante = f.id";

    public static Producto getById(int id) throws SQLException, ClassNotFoundException {
        try (Connection connection = ConexionMySQL.getInstance().obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Producto(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getFloat("precio"),
                            resultSet.getString("nombre_fabricante"));
                } else {
                    return null;
                }
            }
        }
    }

    public static List<Producto> getAll() throws SQLException, ClassNotFoundException {
        List<Producto> productos = new ArrayList<>();

        try (Connection connection = ConexionMySQL.getInstance().obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                productos.add(new Producto(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getFloat("precio"),
                        resultSet.getString("nombre_fabricante")));
            }
        }
        return productos;
    }
}