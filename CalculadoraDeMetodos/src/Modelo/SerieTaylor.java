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
public class SerieTaylor {

    String funcion;
    Evaluador evaluar;
    double errorEstimado=Math.pow(0.5*10,4);
    double vreal;
    
    public static void main(String []cb){
        new SerieTaylor("e^X").calcularSerie("e^X", 3);
        
    }

    public SerieTaylor(String funcion) {
        this.funcion = funcion;
    }

    public double calcularSerie(String funcion, double x) {
        this.funcion = funcion;
        evaluar = new Evaluador();
        vreal=evaluar.evaluarX(x,"X", funcion);
        if(Double.isNaN(vreal)){
            return Double.NaN;
        }
        
        double c ;
        double suma, sumaAnt = 0;
        String deriv;
        int i=0;
        
        if(isEntero(x)){
            c=x;
        }else{
            c=calcularC();
        }
        
        suma=evaluar.evaluarX(c,"X", funcion);
        while(errorAprox(sumaAnt,suma)<=errorEstimado){
            sumaAnt+=suma;
            deriv=evaluar.derivar("X", funcion);
            suma=((evaluar.evaluarX(c,"X", deriv))/factorial(i))*(Math.pow((x-c),i));
            funcion=deriv;
            i++;
            System.out.println(i+" iter");
        }
        System.out.println(sumaAnt);
        return sumaAnt;
    }

    private double errorAprox(double anterior, double actual) {
        if (actual != 0) {
            return (actual - anterior) / actual;
        } else {
            return Double.NaN;
        }
    }

    private double errorVerdadero(double calculado) {
        if(!Double.isNaN(calculado)){
            return (vreal-calculado)/vreal;
        }else{
            return Double.NaN;
        }
        
    }
    
    private boolean isEntero(double x){
        
        return x%1==0;
        
    }

    public static boolean isStringInteger(String number) {
        try {
            Integer.parseInt(number);
            System.out.println("Es entero");
        } catch (NumberFormatException e) {
            System.out.println("No es entero");
            return false;
        }
        return true;
    }

    private double calcularC(){
        return 5;
    }

    public int factorial(int i) {
        int fact = 1;
        for (int j = 1; j <= i; j++) {
            fact = j * fact;
        }
        return fact;
    }

}
