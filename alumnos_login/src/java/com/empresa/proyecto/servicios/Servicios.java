package com.empresa.proyecto.servicios;

import java.util.List;

public interface Servicios {
    public List Listar();
    public List ListarID(int Id);
    public String add(int Id, String User, String Pass,String Nombre, String Apellido_P, String Apellido_M, String Mail);
}