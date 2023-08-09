/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Matriz.Matrices;
import Matriz.MatrizInverse;

/**
 *
 * @author cesit
 */
public class AjusteCurvas {

    private final int M1 = 2;
    private final int M2 = 3;
    private final int M3 = 4;
    private final int M4 = 5;
    private final int M5 = 6;
    String[] tipoFunc = {"Linea", "Grado 2", "Grado 3", "Grado 4", "Grado 5", "EXPONENCIAL", "LOGARITMICA", "POTENCIAL"};
    String tipoFuncion;
    double desviacion=0;

    /*  public static void main(String[] cb) {
        new AjusteCurvas();
    }*/
    public AjusteCurvas() {

        /*Vectores de prueba
        double[] x = {2, 4, 6, 8, 10, 12, 14};
        double[] y = {6.5, 7, 13, 17.8, 19, 25.8, 26.9};
        double[] f = {2.5, 3.5, 5, 6, 7.5, 10, 12.5, 15, 17.5, 20};
        double[] z = {13, 11, 8.5, 8.2, 7, 6.2, 5.2, 4.8, 4.6, 4.3};

        System.out.println("Grado 1");
        double[] g1 = this.exponencial(f, z);

        this.calcularAjusteCurva(x, y);*/
    }

    public double[] calcularAjusteCurva(double[] x, double[] y) {

        double[] desviaciones = new double[8];

        Object[] results = new Object[8];
        results[0] = this.grado1(x, y);
        results[1] = this.grado2(x, y);
        results[2] = this.grado3(x, y);
        results[3] = this.grado4(x, y);
        results[4] = this.grado5(x, y);
        results[5] = this.exponencial(x, y);
        results[6] = this.logaritmica(x, y);
        results[7] = this.potencial(x, y);

        desviaciones[0] = this.yResultG1(x, y, (double[]) results[0]);
        desviaciones[1] = this.yResultG2(x, y, (double[]) results[1]);
        desviaciones[2] = this.yResultG3(x, y, (double[]) results[2]);
        desviaciones[3] = this.yResultG4(x, y, (double[]) results[3]);
        desviaciones[4] = this.yResultG5(x, y, (double[]) results[4]);
        desviaciones[5] = this.yResultG1(x, y, (double[]) results[5]);
        desviaciones[6] = this.yResultG1(x, y, (double[]) results[6]);
        desviaciones[7]=10000;
        //desviaciones[7] = this.yResultG1(x, y, (double[]) results[7]);

        int ant = 0;
        for (int i = 0; i < 8; i++) {
            if (desviaciones[i] < desviaciones[ant]) {
                ant = i;
            }
        }
        this.desviacion=desviaciones[ant];
        return (double[]) results[ant];
    }

    private void tipoFunc(int num) {
        this.tipoFuncion = tipoFunc[num];
    }

    public String getTipoFuncion() {
        return tipoFuncion;
    }

    public double getDesviacion() {
        return desviacion;
    }

    //Calculo de constantes
    public double[] grado1(double[] x, double[] y) {
        int n = x.length;

        double[] vector = {n, sumaX(x), sumaXpot(x, 2)};
        double[] vectorC = {sumaX(y), sumaXY(x, y)};
        Matrices objMatrices = new Matrices(M1);
        double[][] matriz = objMatrices.GenerarMatriz(vector);

        double[] constantes = MatrizInverse.calcularConstantes(matriz, vectorC);

        for (int i = 0; i < constantes.length; i++) {
            System.out.print(constantes[i] + " ");
        }
        return constantes;
    }

    public double[] grado2(double[] x, double[] y) {
        int n = x.length;

        double[] vector = {n, sumaX(x), sumaXpot(x, 2), sumaXpot(x, 3), sumaXpot(x, 4)};
        double[] vectorC = {sumaX(y), sumaXY(x, y), sumaXpot_Y(x, y, 2)};
        Matrices objMatrices = new Matrices(M2);
        double[][] matriz = objMatrices.GenerarMatriz(vector);
        for (int i = 0; i < vectorC.length; i++) {
            for (int j = 0; j < vectorC.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        //double[][]inversa=MatrizInverse.invert(matriz);

        double[] constantes = MatrizInverse.calcularConstantes(matriz, vectorC);

        for (int i = 0; i < constantes.length; i++) {
            System.out.print(constantes[i] + " ");
        }
        return constantes;
    }

    public double[] grado3(double[] x, double[] y) {
        int n = x.length;

        double[] vector = {n, sumaX(x), sumaXpot(x, 2), sumaXpot(x, 3), sumaXpot(x, 4), sumaXpot(x, 5), sumaXpot(x, 6)};
        double[] vectorC = {sumaX(y), sumaXY(x, y), sumaXpot_Y(x, y, 2), sumaXpot_Y(x, y, 3)};
        Matrices objMatrices = new Matrices(M3);
        double[][] matriz = objMatrices.GenerarMatriz(vector);

        double[] constantes = MatrizInverse.calcularConstantes(matriz, vectorC);

        for (int i = 0; i < constantes.length; i++) {
            System.out.print(constantes[i] + " ");
        }
        return constantes;
    }

    public double[] grado4(double[] x, double[] y) {
        int n = x.length;

        double[] vector = {n, sumaX(x), sumaXpot(x, 2), sumaXpot(x, 3), sumaXpot(x, 4), sumaXpot(x, 5), sumaXpot(x, 6), sumaXpot(x, 7), sumaXpot(x, 8)};
        double[] vectorC = {sumaX(y), sumaXY(x, y), sumaXpot_Y(x, y, 2), sumaXpot_Y(x, y, 3), sumaXpot_Y(x, y, 4)};
        Matrices objMatrices = new Matrices(M4);
        double[][] matriz = objMatrices.GenerarMatriz(vector);

        double[] constantes = MatrizInverse.calcularConstantes(matriz, vectorC);

        for (int i = 0; i < constantes.length; i++) {
            System.out.print(constantes[i] + " ");
        }
        return constantes;
    }

    public double[] grado5(double[] x, double[] y) {
        int n = x.length;

        double[] vector = {n, sumaX(x), sumaXpot(x, 2), sumaXpot(x, 3), sumaXpot(x, 4), sumaXpot(x, 5), sumaXpot(x, 6), sumaXpot(x, 7), sumaXpot(x, 8), sumaXpot(x, 9), sumaXpot(x, 10)};
        double[] vectorC = {sumaX(y), sumaXY(x, y), sumaXpot_Y(x, y, 2), sumaXpot_Y(x, y, 3), sumaXpot_Y(x, y, 4), sumaXpot_Y(x, y, 5)};
        Matrices objMatrices = new Matrices(M5);
        double[][] matriz = objMatrices.GenerarMatriz(vector);

        double[] constantes = MatrizInverse.calcularConstantes(matriz, vectorC);
        for (int i = 0; i < constantes.length; i++) {
            System.out.print(constantes[i] + " ");
        }
        return constantes;
    }

    public double[] logaritmica(double[] x, double[] y) {
        int n = x.length;

        double[] vector = {n, sumaLn(x), sumaXpot(logNatural(x), 2)};
        double[] vectorC = {sumaX(y), sumaXY(y, logNatural(x))};

        Matrices objMatrices = new Matrices(M1);
        double[][] matriz = objMatrices.GenerarMatriz(vector);

        double[] constantes = MatrizInverse.calcularConstantes(matriz, vectorC);
        for (int i = 0; i < constantes.length; i++){
            System.out.print(constantes[i] + " ");
        }

        return constantes;
    }

    public double[] exponencial(double[] x, double[] y) {

        int n = x.length;

        double[] vector = {n, sumaX(x), sumaXpot(x, 2)};
        double[] vectorC = {sumaLn(y), sumaXY(x, logNatural(y))};

        Matrices objMatrices = new Matrices(M1);
        double[][] matriz = objMatrices.GenerarMatriz(vector);

        double[] constantes = MatrizInverse.calcularConstantes(matriz, vectorC);
        constantes[0] = Math.exp(constantes[0]);
        for (int i = 0; i < constantes.length; i++) {

            System.out.print(constantes[i] + " ");
        }

        return constantes;
    }

    public double[] potencial(double[] x, double[] y) {

        return null;
    }

    //Termina calculo de constantes
    //Calculos de los vectores
    public double sumaX(double[] x) {

        double suma = 0;

        for (int i = 0; i < x.length; i++) {
            suma += x[i];
        }

        return suma;
    }

    public double sumaXpot(double[] x, int pot) {

        double suma = 0;

        for (int i = 0; i < x.length; i++) {
            suma += (Math.pow(x[i], pot));
        }

        return suma;
    }

    public double sumaXY(double[] x, double[] y) {
        double suma = 0;

        for (int i = 0; i < x.length; i++) {
            suma += (x[i] * y[i]);
        }
        return suma;
    }

    public double sumaXpot_Y(double[] x, double[] y, int pot) {

        double suma = 0;

        for (int i = 0; i < x.length; i++) {
            suma += (Math.pow(x[i], pot) * y[i]);
        }

        return suma;
    }

    //Devuelve la suma del logaritmo natural de un vector
    public double sumaLn(double[] x) {
        double suma = 0;
        for (int i = 0; i < x.length; i++) {
            suma += (Math.log(x[i]));
        }

        return suma;
    }

    //Devuelve el logaritmo natural de un vector
    public double[] logNatural(double[] x) {
        double[] var = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            var[i] = (Math.log(x[i]));
        }

        return var;
    }
    //Fin calculos de los vectores

    /*Calculo de desviación estandar*/
    //Desviacion estandar de una matriz grado 1
    public double yResultG1(double[] x, double[] y, double[] constantes) {

        double[] yResult = new double[x.length];
        double sumaDifer = 0, desv;
        int j = 0;
        for (int i = 0; i < x.length; i++) {
            yResult[i] = constantes[j] + constantes[j + 1] * x[i];
        }

        for (int i = 0; i < x.length; i++) {
            sumaDifer += Math.pow((y[i] - yResult[i]), 2);
        }

        desv = Math.sqrt(sumaDifer / (x.length - (M1)));
        return desv;
    }

    //Desviacion estandar de una matriz grado 2
    public double yResultG2(double[] x, double[] y, double[] constantes) {

        double[] yResult = new double[x.length];
        double[] x2 = this.potenciaVector(x, 2);
        double sumaDifer = 0, desv;
        int j = 0;
        for (int i = 0; i < x.length; i++) {
            yResult[i] = constantes[j] + constantes[j + 1] * x[i] + constantes[j + 2] * x2[i];
        }

        for (int i = 0; i < x.length; i++) {
            sumaDifer += Math.pow((y[i] - yResult[i]), 2);
        }

        desv = Math.sqrt(sumaDifer / (x.length - (M2)));
        return desv;
    }

    //Desviacion estandar de una matriz grado 3
    public double yResultG3(double[] x, double[] y, double[] constantes) {

        double[] yResult = new double[x.length];
        double[] x2 = this.potenciaVector(x, 2);
        double[] x3 = this.potenciaVector(x, 3);
        double sumaDifer = 0, desv;
        int j = 0;
        for (int i = 0; i < x.length; i++) {
            yResult[i] = constantes[j] + constantes[j + 1] * x[i] + constantes[j + 2] * x2[i] + constantes[j + 3] * x3[i];
        }

        for (int i = 0; i < x.length; i++) {
            sumaDifer += Math.pow((y[i] - yResult[i]), 2);
        }

        desv = Math.sqrt(sumaDifer / (x.length - (M3)));
        return desv;
    }

    //Desviacion estandar de una matriz grado 4
    public double yResultG4(double[] x, double[] y, double[] constantes) {

        double[] yResult = new double[x.length];
        double[] x2 = this.potenciaVector(x, 2);
        double[] x3 = this.potenciaVector(x, 3);
        double[] x4 = this.potenciaVector(x, 4);
        double sumaDifer = 0, desv;
        int j = 0;
        for (int i = 0; i < x.length; i++) {
            yResult[i] = constantes[j] + constantes[j + 1] * x[i] + constantes[j + 2] * x2[i] + constantes[j + 3] * x3[i] + constantes[j + 4] * x4[i];
        }

        for (int i = 0; i < x.length; i++) {
            sumaDifer += Math.pow((y[i] - yResult[i]), 2);
        }

        desv = Math.sqrt(sumaDifer / (x.length - (M4)));
        return desv;
    }

    //Desviacion estandar de una matriz grado 5
    public double yResultG5(double[] x, double[] y, double[] constantes) {

        double[] yResult = new double[x.length];
        double[] x2 = this.potenciaVector(x, 2);
        double[] x3 = this.potenciaVector(x, 3);
        double[] x4 = this.potenciaVector(x, 4);
        double[] x5 = this.potenciaVector(x, 5);

        double sumaDifer = 0, desv;
        int j = 0;
        for (int i = 0; i < x.length; i++) {
            yResult[i] = constantes[j] + constantes[j + 1] * x[i] + constantes[j + 2] * x2[i] + constantes[j + 3] * x3[i] + constantes[j + 4] * x4[i] + constantes[j + 5] * x5[i];
        }

        for (int i = 0; i < x.length; i++) {
            sumaDifer += Math.pow((y[i] - yResult[i]), 2);
        }

        desv = Math.sqrt(sumaDifer / (x.length - (M5)));
        return desv;
    }

    //Fin calculo de desviación estandar
    //Otros
    public double[] potenciaVector(double[] x, int pot) {
        double[] aux = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            aux[i] = Math.pow(x[i], pot);
        }
        return aux;
    }

}
