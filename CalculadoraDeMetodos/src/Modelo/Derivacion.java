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
public class Derivacion {

    public Derivacion() {

    }

    public double[] derivacionCentral(double x, String funcion) {
        double h = 0.001;

        double deriva1, deriva2, deriva3, deriva4;
        Evaluador evaluador = new Evaluador(funcion);
        double f1, f1p, f1n, f2p, f2n, f3p, f3n, f4p, f4n, f5p, f5n;

        f1 = evaluador.evaluarX(x);
        f1p = evaluador.evaluarX(x + h);
        f1n = evaluador.evaluarX(x - h);

        f2p = evaluador.evaluarX(x + (2 * h));
        f2n = evaluador.evaluarX(x - (2 * h));

        f3p = evaluador.evaluarX(x + (3 * h));
        f3n = evaluador.evaluarX(x - (3 * h));

        f4p = evaluador.evaluarX(x + (4 * h));
        f4n = evaluador.evaluarX(x - (4 * h));

        f5p = evaluador.evaluarX(x + (5 * h));
        f5n = evaluador.evaluarX(x - (5 * h));

        deriva1 = (-f2p + 8 * f1p - 8 * f1n + f2n) / (12 * h);
        deriva2 = (-f2p + 16 * f1p - 30 * f1 + 16 * f1n - f2n) / (12 * (Math.pow(h, 2)));
        deriva3 = (-f3p + 8 * f2p - 13 * f1p + 13 * f1n - 8 * f2n + f3p) / (8 * (Math.pow(h, 3)));
        deriva4 = (-f3p + 12 * f2p - 39 * f1p + 56 * f1 - 39 * f1n + 12 * f2n - f3n) / (6 * (Math.pow(h, 4)));
        double[] derivadas = {deriva1, deriva2, deriva3, deriva4};

        return derivadas;
    }

    public double derivada1Central(double x, String funcion) {
        double h = 0.001;
        double deriva1;
        Evaluador evaluador = new Evaluador(funcion);
        double f1, f1p, f1n, f2p, f2n;
        f1 = evaluador.evaluarX(x);
        f1p = evaluador.evaluarX(x + h);
        f1n = evaluador.evaluarX(x - h);

        f2p = evaluador.evaluarX(x + (2 * h));
        f2n = evaluador.evaluarX(x - (2 * h));

        deriva1 = (-f2p + 8 * f1p - 8 * f1n + f2n) / (12 * h);
        return deriva1;
    }

    public double derivada2Central(double x, String funcion) {
        double h = 0.001;
        double deriva2;
        Evaluador evaluador = new Evaluador(funcion);
        double f1, f1p, f1n, f2p, f2n;

        f1 = evaluador.evaluarX(x);
        f1p = evaluador.evaluarX(x + h);
        f1n = evaluador.evaluarX(x - h);

        f2p = evaluador.evaluarX(x + (2 * h));
        f2n = evaluador.evaluarX(x - (2 * h));
        deriva2 = (-f2p + 16 * f1p - 30 * f1 + 16 * f1n - f2n) / (12 * (Math.pow(h, 2)));
        return deriva2;
    }

    public double derivada3Central(double x, String funcion) {
        double h = 0.001;
        double deriva3;
        Evaluador evaluador = new Evaluador(funcion);
        double f1, f1p, f1n, f2p, f2n, f3p, f3n;

        f1 = evaluador.evaluarX(x);
        f1p = evaluador.evaluarX(x + h);
        f1n = evaluador.evaluarX(x - h);

        f2p = evaluador.evaluarX(x + (2 * h));
        f2n = evaluador.evaluarX(x - (2 * h));

        f3p = evaluador.evaluarX(x + (3 * h));
        f3n = evaluador.evaluarX(x - (3 * h));

        deriva3 = (-f3p + 8 * f2p - 13 * f1p + 13 * f1n - 8 * f2n + f3n) / (8 * (Math.pow(h, 3)));
        return deriva3;
    }

    public double derivada4Central(double x, String funcion) {
        double h = 0.001;
        double deriva4;
        Evaluador evaluador = new Evaluador(funcion);
        double f1, f1p, f1n, f2p, f2n, f3p, f3n;

        f1 = evaluador.evaluarX(x);
        f1p = evaluador.evaluarX(x + h);
        f1n = evaluador.evaluarX(x - h);

        f2p = evaluador.evaluarX(x + (2 * h));
        f2n = evaluador.evaluarX(x - (2 * h));

        f3p = evaluador.evaluarX(x + (3 * h));
        f3n = evaluador.evaluarX(x - (3 * h));

        deriva4 = (-f3p + 12 * f2p - 39 * f1p + 56 * f1 - 39 * f1n + 12 * f2n - f3n) / (6 * (Math.pow(h, 4)));
        return deriva4;
    }
}
