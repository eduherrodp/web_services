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
            con = conn.getConection();
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
    public List ListarID(int Id) {
        List<Datos> dat = new ArrayList();
        String sql = "SELECT a.id, a.user, a.pass, b.nombre, b.apellido_p, b.apellido_m, b.mail FROM usuarios A" +
                "join user_detalle B on B.id = A.id where A.id = " + Id;
        
        int Control = 0;
        String msg = "";
        
        try {
            con = conn.getConection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.last()) {
               Control = rs.getRow();
            }
            Datos d = new Datos();
            if(Control > 0){
                d.setId(rs.getInt("id"));
                d.setUser(rs.getString("User"));
                d.setPass(rs.getString("Pass"));
                d.setNombre(rs.getString("nombre"));
                d.setApellido_p(rs.getString("apellido_p"));
                d.setApellido_M(rs.getString("apellido_m"));
                d.setMail(rs.getString("mail"));
            }
            else {
                d.setId(Id);
                d.setMensaje("ID no Existe");
            }
            dat.add(d);
        }
        catch(SQLException e){
        }      
       return dat;
    }


    @Override
    public String add(int Id, String User, String Pass, String Nombre, String Apellido_P, String Apellido_M, String Mail) {
        String query = "INSERT INTO usuarios (id, 'user', 'pass') VALUES("+ Id + ", '" + User + "', '" + Pass + "')";
        String query1 = "INSERT INTO user_detalle (id, 'nombre', 'apellido_p', 'apellido_m', 'mail') "
                + "VALUES(" + Id + ", '" + Nombre + "', '" + Apellido_P + "', '" + Apellido_M + "', '" + Mail + "' )";
       String msg = "";
       
        try
        {
          con = conn.getConection();
          ps = con.prepareStatement(query);
          ps.executeUpdate();
          ps = con.prepareStatement(query1);
          ps.executeUpdate();
          msg = "Se agrego el Id" + Id;
        }
        catch(Exception e){   
        }
        return msg;
    }


    }

