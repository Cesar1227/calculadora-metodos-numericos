/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.la4j.inversion.GaussJordanInverter;
import org.la4j.inversion.MatrixInverter;
import org.la4j.matrix.Matrices;
import org.la4j.matrix.Matrix;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 *
 * @author cesit
 */
public class Evaluador {

    String[] Afuncion;
    String funcion;

    /*
    public static void main(String args[]){
        Evaluador evaluador = new Evaluador();
    }*/
    public Evaluador() {
    }

    public Evaluador(String funcion) {
        this.funcion = funcion;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    //Evaluar para X
    public double evaluarX(double x) {
        JEP objJep = new JEP();
        objJep.addStandardConstants();
        objJep.addStandardFunctions();

        objJep.addVariable("X", x);
        objJep.parseExpression(funcion);

        if (!objJep.hasError()) {
            return objJep.getValue();
        } else {
            return Double.NaN;
        }

    }

    public double evaluarX(double x, String termino) {
        JEP objJep = new JEP();
        objJep.addStandardConstants();
        objJep.addStandardFunctions();

        objJep.addVariable(termino, x);
        objJep.parseExpression(funcion);

        if (!objJep.hasError()) {
            return objJep.getValue();
        } else {
            return Double.NaN;
        }

    }

    public double evaluarX(double x, String termino, String funcion) {
        JEP objJep = new JEP();
        objJep.addStandardConstants();
        objJep.addStandardFunctions();

        objJep.addVariable(termino, x);
        objJep.parseExpression(funcion);

        if (!objJep.hasError()) {
            return objJep.getValue();
        } else {
            return Double.NaN;
        }

    }

    public String derivar(String termino, String funcion) {
        String derivada = "";

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
            diff = derivador.differentiate(diff, termino);
            diff = derivador.simplify(diff);
            derivada = derivador.toString(diff);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return derivada;
    }
    
    public String derivar(String funcion) {
        String derivada = "";
        String termino ="X";

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
            diff = derivador.differentiate(diff, termino);
            diff = derivador.simplify(diff);
            derivada = derivador.toString(diff);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return derivada;
    }

}
