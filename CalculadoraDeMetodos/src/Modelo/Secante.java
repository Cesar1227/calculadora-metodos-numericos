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
public class Secante {

    public static void main(String[] args) {
        new Secante();
    }

    public Secante() {
        //System.out.println(this.secante("X^2-ln(X)+e^X-205"));
        System.out.println(this.secante("e^(-X^2)-X"));
    }

    public double secante(String funcion) {

        Evaluador evaluador = new Evaluador(funcion);
        double x = 5, xa, xr = 0, xrA = 1, f, fa, ea = 100;
        double es = Error.errorEstimado(10);
        xa = x - 0.5;
        int i = 0;
        while ((ea > es & xr != xrA)) {
            if (i <= 500) {
                f = evaluador.evaluarX(x, "X");
                fa = evaluador.evaluarX(xa, "X");
                xrA = xr;
                xr = x - (f * (x - xa) / (f - fa));

                xa = x;
                x = xr;
                ea = Math.abs((xr - xrA) / xr) * 100;

                i++;
            } else {
                return Double.NaN;
            }
           
        }
        System.out.println("Iteraciones: "+i);
        return xr;
    }
    
    
            
}
