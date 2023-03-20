/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.figuras;

/**
 *
 * @author eduhe
 */
public class Triangulo implements Figura {
    private final double base;
    private final double altura;
    
    public Triangulo(double base, double altura) {
        this.altura = altura;
        this.base = base;
    }
    
    @Override
    public double calcularArea() {
        return (base * altura) /2;
    }
}
