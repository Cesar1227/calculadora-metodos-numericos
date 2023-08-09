/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 *
 * @author cesit
 */
public class Derivar {
    
    public String derivar(String funcion) {
        String derivada = "";
        String respecto = "x";

        DJep derivador = new DJep();

        derivador.addStandardFunctions();
        derivador.addStandardConstants();
        derivador.addComplex();
        derivador.setAllowUndeclared(true);
        derivador.setAllowAssignment(true);
        derivador.setImplicitMul(true);
        derivador.addStandardDiffRules();

        try {
            Node diff = derivador.parse(funcion);
            diff = derivador.differentiate(diff, respecto);
            diff = derivador.simplify(diff);
            derivada = derivador.toString(diff);
            funcion = derivada;
        } catch (ParseException e){
            e.printStackTrace();
        }
        
        return funcion;
    }
    
}
