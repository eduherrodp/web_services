/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.figuras;

/**
 *
 * @author eduhe
 */
public class FiguraFactory {
    public static Figura crearFiguraPorTipo(String tipo, double... parametros) {
        switch (tipo) {
            case "circulo":
                return new Circulo(parametros[0]);
            case "cuadrado":
                return new Cuadrado((double) parametros[0]);
            case "triangulo":
                return new Triangulo(parametros[0], parametros[1]);
            case "rombo":
                return new Rombo((double) parametros[0], (double) parametros[1]);
            case "pentagono":
                return new Pentagono((double) parametros[0], (double) parametros[1]);
            default:
                throw new IllegalArgumentException("Tipo de figura no soportado");
        }
    }
}
