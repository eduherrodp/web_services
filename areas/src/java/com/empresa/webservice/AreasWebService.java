/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author eduhe
 */
@WebService
public interface AreasWebService {
    @WebMethod
    double calcularAreaCuadrado(@WebParam(name = "lado") double lado);

    @WebMethod
    double calcularAreaCirculo(@WebParam(name = "radio") double radio);

    @WebMethod
    double calcularAreaTriangulo(@WebParam(name = "base") double base, @WebParam(name = "altura") double altura);

    @WebMethod
    double calcularAreaRombo(@WebParam(name = "dMayor") double dMayor, @WebParam(name = "dMenor") double dMenor);

    @WebMethod
    double calcularAreaPentagono(@WebParam(name = "lados") double lados, @WebParam(name = "apotema") double apotema);
}