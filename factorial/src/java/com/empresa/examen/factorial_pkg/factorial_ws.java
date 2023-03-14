/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.empresa.examen.factorial_pkg;

import java.math.BigInteger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eduhe
 */
@WebService(serviceName = "factorial_ws")
public class factorial_ws {

    /**
     * This is a sample web service operation
     * @param n
     * @return 
     */
    @WebMethod(operationName = "factorial")
    public String hello(@WebParam(name = "name") Integer n) {
        if (n<0 || n > 100) {
            return "Número inválido";
        } else {
            BigInteger factorial = BigInteger.ONE;
            for (int i = 2; i<= n; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            StringBuilder response = new StringBuilder();
            response.append("Factorial de ").append(n).append(" es ").append(factorial).append("\n");
            response.append("Regla de cálculo ").append(getFactorialRule(n));
            
            return response.toString();
        }
    }
    
    public static String getFactorialRule(int n) {
        StringBuilder rule = new StringBuilder();
        for (int i = 1; i <= n; i++ ) {
            if (i > 1) {
                rule.append(" * ");
            }
            rule.append(i);
        }
        rule.append(" = ").append(factorial(n));
        return rule.toString();
    }
    
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for(int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}


