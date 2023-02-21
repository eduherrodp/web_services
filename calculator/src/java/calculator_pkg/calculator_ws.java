/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package calculator_pkg;

import java.util.Arrays;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eduhe
 */
@WebService(serviceName = "calculator_ws")
public class calculator_ws {

    /**
     * This is a sample web service operation
     * @param a
     * @param b
     * @param option
     * @return 
     */
    public boolean validate(String a, String b, String option) {
        
        // Check if any parameter is null
        if( "".equals(a) || "".equals(b) || "".equals(option)) {
           return false;
        }
        String[] options = new String[]{"+", "-", "*", "/", "^", "s", "l"};
        List<String> list = Arrays.asList(options);
        
        if(!list.contains(option)) {
            return true;
        }
        return true;
    }
    @WebMethod(operationName = "Calculator")
    public String calculator(@WebParam(name = "number1") String a, @WebParam(name = "number2") String b, @WebParam(name = "option") String option) {
        double res;
        // Validate call function
        if (!validate(a,b,option)) {
            return "Check your parameters";
        } else {
            // object calculator
            Calculator c = new Calculator(a,b);
            switch(option) {
                case "+": res = c.add(); break;
                case "-": res = c.subtract(); break;
                case "*": res = c.multipy(); break;
                case "/": res = c.divide(); break;
                case "^": res = c.pow(); break;
                case "s": res = c.sqrt(); break;
                case "l": res = c.log(); break;
                default: return "Select an correct option";
            }
            return Double.toString(res);
        }
    }
}