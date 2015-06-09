/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numericos.proyectofinal.views.graficador;
/**
 *
 * @author Esteven Quintero
 */
public class Vector {
    //Atributos
    public double [] Numeros;
    public int Medida;
    //End Atributos
    public Vector(int Medida){
        this.Medida = Medida;
        Numeros = new double[this.Medida];
        Numeros[0] = 0;
        Numeros[1] = 0;
        Numeros[2] = 0;
    }//End Constructor
    public Vector(int Medida, double[] Numeros){
        this.Medida = Medida;
        this.Numeros = Numeros;
    }//End Constructor
    public static Vector Resta(Vector vector1, Vector vector2){
        Vector Solucion = new Vector(vector1.Medida);
        for(int i = 0; i < Solucion.Medida; i++){
            Solucion.Numeros[i] = vector1.Numeros[i] - vector2.Numeros[i];                    
        }
        return Solucion;
    }
    public static double Norma(Vector anterior, Vector actual){
        double Mayor = 0;        
        for(int i = 0; i < anterior.Medida;i++){
            double aux = Math.abs(actual.Numeros[i] - anterior.Numeros[i]);
            if(aux > Mayor){
                Mayor = aux;
            }
        }
        return Mayor;
    }
    public static double Norma(Vector actual){
        double Mayor = 0;        
        for(int i = 0; i < actual.Medida;i++){
            double aux = Math.abs(actual.Numeros[i]);
            if(aux > Mayor){
                Mayor = aux;
            }
        }
        return Mayor;
    }
}
