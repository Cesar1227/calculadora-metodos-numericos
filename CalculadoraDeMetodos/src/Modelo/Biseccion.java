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
public class Biseccion {

    public Biseccion() {

    }

    public double MetBiseccion(String funcion, double e) {

        Evaluador evaluador = new Evaluador(funcion);
        double[] intervalo = this.IntervaloRaiz(funcion);
        double a = intervalo[0];
        double b = intervalo[1];
        double x;
        int cont = 0;
        System.out.println(a+"--"+b+ "intervalos");
        x = Double.NaN;
        double fa = evaluador.evaluarX(a);

        if (!Double.isNaN(fa)) {
            double fb = evaluador.evaluarX(b);

            if (fa * fb < 0) {

                do {
                    x = (a + b) / 2;
                    cont++;
                    fa = evaluador.evaluarX(a);
                    fb = evaluador.evaluarX(b);

                    if (fa * evaluador.evaluarX(x) < 0) {
                        b = x;
                    } else {
                        a = x;
                    }
                } while (Math.abs(evaluador.evaluarX(x)) > e);
            }

            if (!Double.isNaN(x)) {
                return x;
            } else {
                System.out.println("x es NaN");
            }
        } else {
            System.out.println("funcion evaluada es NaN");
        }

        return Double.NaN;
    }

    private double[] IntervaloRaiz(String funcion) {
        Evaluador evaluador = new Evaluador(funcion);
        int[] rango = {-500, 500};
        double[] limites = new double[2];
        double a, b;
        a = evaluador.evaluarX(rango[0]);
        if (a < 0) {
            for (int i = rango[0]; i <= rango[1]; i++) {
                b = evaluador.evaluarX(i);

                if (b > 0 || b == 0) {
                    if (b > 0) {
                        limites[0] = (a);
                        limites[1] = (b);
                    } else {
                        limites[0] = (b);
                        limites[1] = (b);
                    }

                    return limites;
                } else {
                    a = b;
                }
            }
        } else if (a > 0) {
            for (int i = rango[0]; i <= rango[1]; i++) {
                b = evaluador.evaluarX(i);

                if (b < 0 || b == 0) {
                    if (b < 0) {
                        limites[0] = (a);
                        limites[1] = (b);
                    } else {
                        limites[0] = (b);
                        limites[1] = (b);
                    }

                    return limites;
                } else {
                    a = b;
                }
            }
        } else if (a == 0) {
            limites[0] = (a);
            limites[1] = (a);
        } else {
            limites[0] = Double.NaN;
            limites[1] = Double.NaN;
        }
        System.out.println(limites[0]+limites[1]);
        return limites;
    }
}
