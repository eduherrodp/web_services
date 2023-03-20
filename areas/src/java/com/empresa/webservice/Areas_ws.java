/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.webservice;

import com.empresa.figuras.Figura;
import com.empresa.figuras.FiguraFactory;


import javax.jws.WebService;

@WebService(endpointInterface = "com.empresa.webservice.AreasWebService")
public class Areas_ws implements AreasWebService {

    @Override
    public double calcularAreaCuadrado(double lado) {
        Figura figura = FiguraFactory.crearFiguraPorTipo("cuadrado", lado);
        return figura.calcularArea();
    }

    @Override
    public double calcularAreaCirculo(double radio) {
        Figura figura = FiguraFactory.crearFiguraPorTipo("circulo", radio);
        return figura.calcularArea();
    }

    @Override
    public double calcularAreaTriangulo(double base, double altura) {
        Figura figura = FiguraFactory.crearFiguraPorTipo("triangulo", base, altura);
        return figura.calcularArea();
    }

    @Override
    public double calcularAreaRombo(double dMayor, double dMenor) {
        Figura figura = FiguraFactory.crearFiguraPorTipo("rombo", dMayor, dMenor);
        return figura.calcularArea();
    }

    @Override
    public double calcularAreaPentagono(double lado, double apotema) {
        Figura figura = FiguraFactory.crearFiguraPorTipo("pentagono", lado, apotema);
        return figura.calcularArea();
    }
}