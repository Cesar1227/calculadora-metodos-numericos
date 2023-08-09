/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author cesit
 */
public class Matrices {

    double[][] matriz;
    double[][] matrizAux;

    int grado;

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("grade");
        int gradoR = (int) sc.nextDouble();
        System.out.println("valores");
        double[] vectoru = new double[gradoR * 2 - 1];
        for (int i = 0; i < gradoR * 2 - 1; i++) {
            vectoru[i] = Double.valueOf(sc.next());
        }

        Matrices obj = new Matrices(gradoR);
        obj.GenerarMatriz(vectoru);
    }*/

    public Matrices() {

    }

    public Matrices(int grado) {
        matriz = new double[grado][grado];
        this.grado = grado;
    }

    public double[][] GenerarMatriz(double[] vector) {
        int cont = grado * 2 - 1;
        for (int i = 0; i < cont; i++) {
            ingresarDato(vector[i], i + 1);
        }
       
        return matriz;
    }

    private void ingresarDato(double dato, int cont) {
        int ingresado = 0, j = 0;

        for (int i = 0; i < grado; i++) {
            while (ingresado < cont && j < grado) {
                if ((matriz[i][j]) == 0) {
                    matriz[i][j] = dato;
                    ingresado++;
                    j = 0;
                    break;
                } else {
                    j++;
                }
            }
            j = 0;
        }
    }

    public double[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(double[][] matriz) {
        this.matriz = matriz;
    }
    


}
