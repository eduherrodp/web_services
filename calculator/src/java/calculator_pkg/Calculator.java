/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator_pkg;

/**
 *
 * @author eduhe
 */
public class Calculator {

    private double a;
    private double b;
    
    // Constructor 
    public Calculator(String a,String b) {
        this.a = Double.parseDouble(a);
        this.b = Double.parseDouble(b);
    }
    
    // Functions, operations
    public double add() {
        return a + b;
    }
    public double subtract() {
        return a - b;
    }
    public double multipy() {
        return a - b;
    }
    public double divide () {
        if (b == 0) {
            return 0;
        }
        return a / b;
    }
    public double pow () {
        return Math.pow(a, b);
    }
    public double sqrt () {
        return Math.sqrt(a);
    }
    public double log () {
        return Math.log10(a);
    }
}
