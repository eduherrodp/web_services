package com.empresa.tenis.ws;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */

import com.empresa.tenis.ArbolDecision;
import com.empresa.tenis.NodoArbol;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author eduhe
 */

@WebService(serviceName = "Tenis_ws")
public class Tenis_ws {
    
    private final ArbolDecision arbol;
    
    public Tenis_ws() {
        // Crear el árbol de decisión
        NodoArbol raiz = new NodoArbol("humedad", null);
        NodoArbol nodoSi = new NodoArbol(null, "si");
        nodoSi.agregarRama(null, new NodoArbol(null, "si"));
        NodoArbol nodoNo = new NodoArbol(null, "no");
        nodoNo.agregarRama(null, new NodoArbol(null, "no"));
        raiz.agregarRama("alta", nodoSi);
        raiz.agregarRama("normal", nodoNo);
        arbol = new ArbolDecision();
        arbol.setRaiz(raiz);
    }

    @WebMethod(operationName = "predecir")
    public String predecir(@WebParam(name = "ambiente") String ambiente,
                           @WebParam(name = "humedad") String humedad,
                           @WebParam(name = "viento") String viento) {
        return arbol.evaluar(ambiente, humedad, viento);
    }
}