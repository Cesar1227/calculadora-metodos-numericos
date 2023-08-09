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
public class Integracion {

    int nTrapecio = 1000;
    int nSimpson3 = 1000;
    int nSimpson8 = 1200;

    public Integracion() {

    }

    public double trapecio(double a, double b, String funcion) {

        int n = this.nTrapecio;
        double h = (b - a) / n;
        double integral, x;

        Evaluador evaluador = new Evaluador(funcion);
        int i = 1;
        double sumatoria = 0;
        x = a;

        while (i < n) {
            x += h;
            sumatoria += evaluador.evaluarX(x);
            i++;
        }

        sumatoria = sumatoria * 2;
        sumatoria = sumatoria + evaluador.evaluarX(a) + evaluador.evaluarX(b);

        integral = (h / 2) * sumatoria;
        
        return integral;
    }

    public double simpson3(double a, double b, String funcion) {
        int n = this.nSimpson3;
        double h = (b - a) / n;
        double sumaP = 0;
        double sumaI = 0;
        double integral, x;

        Evaluador evaluador = new Evaluador(funcion);

        x = a;
        for (int j = 0; j <= n - 1; j++) {
            x += h;
            if (j % 2 == 0) {
                sumaP += evaluador.evaluarX(x);
            } else {
                sumaI += evaluador.evaluarX(x);
            }

        }
        sumaI = sumaI * 4;
        sumaP = sumaP * 2;

        integral = (h / 3) * (evaluador.evaluarX(a) + sumaI + sumaP + evaluador.evaluarX(b));
        
        return integral;
    }

    public double simpson8(double a, double b, String funcion) {
        int n = this.nSimpson8;
        double h = (b - a) / n;
        double sumaP = 0;
        double sumaI = 0;
        double integral;

        Evaluador evaluador = new Evaluador();

        return 0;
    }

}
