package com.empresa.tenis;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author eduhe
 */
public class ArbolDecision {

    private NodoArbol raiz;

    public ArbolDecision() {
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public String evaluar(String ambiente, String humedad, String viento) {
        return predecir(raiz, ambiente, humedad, viento);
    }

    private String predecir(NodoArbol nodo, String ambiente, String humedad, String viento) {
        if (nodo.esHoja()) {
            return nodo.getClase();
        } else {
            String valorAtributo = null;
            switch (nodo.getAtributo()) {
                case "ambiente":
                    valorAtributo = ambiente;
                    break;
                case "humedad":
                    valorAtributo = humedad;
                    break;
                case "viento":
                    valorAtributo = viento;
                    break;
            }
            for (NodoArbol hijo : nodo.getHijos().values()) {
            if (hijo.getValor().equalsIgnoreCase(valorAtributo)) {
                return predecir(hijo, ambiente, humedad, viento);
            }
        }

            // No se encontró el valor del atributo en los hijos, se devuelve la clase mayoritaria
            return nodo.getClaseMayoritaria();
        }
    }
}