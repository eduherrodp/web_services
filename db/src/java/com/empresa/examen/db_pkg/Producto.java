/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.examen.db_pkg;

/**
 *
 * @author eduhe
 */
public class Producto {
    private final int id;
    private final String nombre;
    private final float precio;
    private final String nombreFabricante;
    
    public Producto(int id, String nombre, float precio, String nombreFabricante) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.nombreFabricante = nombreFabricante;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public float getPrecio() {
        return precio;
    }
    public String getFabricante(){
        return nombreFabricante;
    }
}
