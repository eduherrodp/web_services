/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.figuras;

/**
 *
 * @author eduhe
 */
public class Cuadrado implements Figura {
    private final double lado;
    
    public Cuadrado(double lado){
        this.lado = lado;
    }
    @Override
    public double calcularArea(){
        return Math.pow(lado,2);
    }
}
