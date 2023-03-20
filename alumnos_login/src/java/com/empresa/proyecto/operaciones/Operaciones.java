package com.empresa.proyecto.operaciones;

import com.empresa.proyecto.bean.Datos;
import com.empresa.proyecto.conexion.Conexion;
import com.empresa.proyecto.servicios.Servicios;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Operaciones implements Servicios{
   PreparedStatement ps;
   ResultSet rs;
   Connection con;
   Conexion conn = new Conexion();

    
    @Override
    public List Listar() {
        List<Datos> dat = new ArrayList();
        String sql = "SELECT * FROM `usuarios`";
        try{
            con = conn.getConecction();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Datos d = new Datos();
                d.setId(rs.getInt("id"));
                d.setUser(rs.getString("User"));
                d.setPass(rs.getString("Pass"));
                dat.add(d);
            }
        }
        catch(SQLException e){  
           
        }
        return dat;
    }

    
    @Override
    public List<Datos> ListarID(int id) {
        String sql = "SELECT a.id, a.user, a.pass, b.nombre, b.apellido_p, b.apellido_m, b.mail " +
                "FROM usuarios a JOIN user_detalle b ON b.id = a.id WHERE a.id = ?";
        List<Datos> datosList = new ArrayList<>();

        try {
            Connection con = conn.getConecction();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Datos d = new Datos();
                    d.setId(rs.getInt("id"));
                    d.setUser(rs.getString("user"));
                    d.setPass(rs.getString("pass"));
                    d.setNombre(rs.getString("nombre"));
                    d.setApellido_p(rs.getString("apellido_p"));
                    d.setApellido_M(rs.getString("apellido_m"));
                    d.setMail(rs.getString("mail"));
                    datosList.add(d);
                } else {
                    Datos d = new Datos();
                    d.setId(id);
                    d.setMensaje("ID no existe");
                    datosList.add(d);
                }
            }
        } catch (SQLException e) {
            // Manejar la excepción de manera adecuada (log, mensaje de error, etc.)
        }
        return datosList;
    }


    @Override
    public String add(int Id, String User, String Pass, String Nombre, String Apellido_P, String Apellido_M, String Mail) {
        String query = "INSERT INTO usuarios (id, user, pass) VALUES("+ Id + ", '" + User + "', '" + Pass + "')";
        String query1 = "INSERT INTO user_detalle (id, nombre, apellido_p, apellido_m, mail) "
                + "VALUES(" + Id + ", '" + Nombre + "', '" + Apellido_P + "', '" + Apellido_M + "', '" + Mail + "' )";
       String msg = "";
       
        try
        {
          con = conn.getConecction();
          ps = con.prepareStatement(query);
          ps.executeUpdate();
          ps = con.prepareStatement(query1);
          ps.executeUpdate();
          msg = "Se agrego el ID " + Id;
        }
        catch(SQLException e){ 
            msg = "Error insertando datos " + e.getLocalizedMessage();
        }
        return msg;
    }
}