/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.figuras;

/**
 *
 * @author eduhe
 */
public class Rombo implements Figura {
    private final double dMayor;
    private final double dMenor;

    public Rombo(double dMayor, double dMenor) {
        this.dMayor = dMayor;
        this.dMenor = dMenor;
    }

    @Override
    public double calcularArea() {
        return (dMayor * dMenor) / 2;
    }
}
