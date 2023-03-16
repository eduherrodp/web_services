/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package Tenis;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eduhe
 */
@WebService(serviceName = "Tenis_ws")
public class Tenis_ws {
    private static final String AMBIENTE_SOLEADO = "soleado";
    private static final String AMBIENTE_NUBLADO = "nublado";
    private static final String AMBIENTE_LLUVIA = "lluvia";
    private static final String HUMEDAD_ALTA = "alta";
    private static final String HUMEDAD_NORMAL = "normal";
    private static final String VIENTO_FUERTE = "fuerte";
    private static final String VIENTO_DEBIL = "debil";
    
    @WebMethod(operationName = "arbol")
    public String arbol(
        @WebParam(name = "ambiente") String ambienteParam,
        @WebParam(name = "humedad") String humedadParam,
        @WebParam(name = "viento") String vientoParam
    ) {
        String ambiente = ambienteParam.toLowerCase();
        String humedad = humedadParam.toLowerCase();
        String viento = vientoParam.toLowerCase();
        
        if (AMBIENTE_SOLEADO.equalsIgnoreCase(ambiente) || AMBIENTE_NUBLADO.equalsIgnoreCase(ambiente) || AMBIENTE_LLUVIA.equalsIgnoreCase(ambiente)) {
            
            switch(ambiente) {
                case AMBIENTE_SOLEADO: 
                    if (HUMEDAD_ALTA.equalsIgnoreCase(humedad) || HUMEDAD_NORMAL.equalsIgnoreCase(humedad)) {
                        if (HUMEDAD_ALTA.equalsIgnoreCase(humedad)) {
                            return "No se juega";
                        } else {
                            return "Si se puede jugar";
                        }
                    } else {
                        return "Humedad no reconocida";
                    }
                case AMBIENTE_NUBLADO: 
                    return "Si se puede jugar";
                case AMBIENTE_LLUVIA:
                    if (VIENTO_FUERTE.equalsIgnoreCase(viento) || VIENTO_DEBIL.equalsIgnoreCase(viento)) {
                        if (VIENTO_FUERTE.equalsIgnoreCase(viento)) {
                            return "No se juega";
                        } else {
                            return "Si se puede jugar";
                        }
                    } else {
                        return "Viento no reconocido";
                    }
                default: 
                    return "Ambiente no reconocido";    
            }
        } else {
            return "Ambiente no reconocido";
        }
    }
}