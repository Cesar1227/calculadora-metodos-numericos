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
public class Error {
    
    
    public static double errorEstimado(int n){
        double es=0.5*Math.pow(10, (2-n));
        return es;
    }
    
}
