package com.empresa.tenis;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author eduhe
 */
public class NodoArbol {

    private final String atributo;
    private final String clase;
    private final Map<String, NodoArbol> hijos;

    public NodoArbol(String atributo, String clase) {
        this.atributo = atributo;
        this.clase = clase;
        hijos = new HashMap<>();
    }

    public boolean esHoja() {
        return hijos.isEmpty();
    }

    public void agregarRama(String valorAtributo, NodoArbol hijo) {
        hijos.put(valorAtributo, hijo);
    }

    public NodoArbol obtenerHijo(String valorAtributo) {
        return hijos.get(valorAtributo);
    }

    public String getAtributo() {
        return atributo;
    }

    public String getClase() {
        return clase;
    }

    public String getClaseMayoritaria() {
        Map<String, Integer> conteoClases = new HashMap<>();
        for (NodoArbol hijo : hijos.values()) {
            String claseHijo = hijo.getClase();
            conteoClases.put(claseHijo, conteoClases.getOrDefault(claseHijo, 0) + 1);
        }
        String claseMayoritaria = null;
        int maxConteo = 0;
        for (Map.Entry<String, Integer> entry : conteoClases.entrySet()) {
            if (entry.getValue() > maxConteo) {
                claseMayoritaria = entry.getKey();
                maxConteo = entry.getValue();
            }
        }
        return claseMayoritaria;
    }

    public String getValor() {
        if (atributo == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(atributo).append(": {");
        for (Map.Entry<String, NodoArbol> entry : hijos.entrySet()) {
            sb.append(entry.getKey()).append(": ");
            sb.append(entry.getValue().getValor()).append(", ");
        }
        sb.setLength(sb.length() - 2); // para quitar la última coma y espacio
        sb.append("}");
        return sb.toString();
    }

    public Map<String, NodoArbol> getHijos() {
        return hijos;
    }
}