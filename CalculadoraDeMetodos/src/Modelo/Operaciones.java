/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author cesit
 */
public class Operaciones {

    public static final double PI = Math.PI;
    public static final double E = Math.E;

    public Operaciones() {

    }

    public static double suma(double a, double b) {
        return a + b;
    }

    public static int suma(int a, int b) {
        return a + b;
    }

    public static double resta(double a, double b) {
        return a - b;
    }

    public static int resta(int a, int b) {
        return a - b;
    }

    public static double producto(double a, double b) {
        return a * b;
    }

    public static int producto(int a, int b) {
        return a * b;
    }

    public static double divison(double a, double b) {
        if (b != 0) {
            return a / b;
        }
        return Double.NaN;
    }

    public static double potencia(double a, double b) {
        return Math.pow(a, b);
    }

    public static int potencia(int a, int b) {
        return a ^ b;
    }

    public static double raiz(double a) {
        return Math.sqrt(a);
    }

}
