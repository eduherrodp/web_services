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
    public Calculator(double a, double b) {
        this.a = a;
        this.b = b;
    }
    
    // Functions, operations
    public double add() {
        return a + b;
    }
    public double subtract() {
        return a - b;
    }
    public double multipy() {
        return a * b;
    }
    public double divide () {
        
        return b == 0 ? 0 : a / b;
        
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
