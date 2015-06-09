/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numericos.proyectofinal.views.graficador;
/**
 *
 * @author Esteven Quintero & David Rivera
 */
public class Matriz {
    //Atributos
    public  int Filas;
    public  int Columnas;
    public  Matriz A;
    public  Vector b;
    public double [][] Numeros;
    public String[] Cabecera;
    //End Atributos
    public Matriz(int filas, int columnas){
		Filas = filas;
		Columnas = columnas;
        Cabecera = new String[Columnas];
                A = null;
                b = null;
		Numeros = new double[Filas][Columnas];
                LlenarVacia();
	}//End Constructor
    public Matriz(int filas, int columnas, double[][] Numeros){
		Filas = filas;
		Columnas = columnas;
        Cabecera = new String[Columnas];
                A = null;
                b = null;
		this.Numeros = Numeros;
	}//End Constructor
    public Matriz(Matriz A, Vector b){
		Filas = A.Filas;
		Columnas = A.Columnas + 1;
        Cabecera = new String[Columnas];
                this.A = A;
                this.b = b;
		Numeros = new double[Filas][Columnas];
                LlenarCompuesta();
	}//End Constructor2
    public void LlenarVacia(){
        for(int i = 0; i < Filas; i ++){
            for(int j = 0; j < Columnas; j++){
                Numeros[i][j]=0;
            }
        }
    }//End Llenas Vacia
    public void LlenarCompuesta(){
        for(int i = 0;i < Filas;i++){
            for(int j = 0; j < Columnas;j++){
                if(j == Columnas-1){
                    Numeros[i][j]=b.Numeros[i];
                }else{
                    Numeros[i][j]=A.Numeros[i][j];
                }
            }
        }
    }//End Llenas Compuesta
    public void reemplazarFila(int numFila, Vector fila){
        for(int i  = 0; i < fila.Numeros.length; i++){
            Numeros[numFila][i]=fila.Numeros[i];
        }
    }//End reemplazarFila
    public void reemplazarColumna(int numColumna, Vector Columna){
        for(int i  = 0; i < Columna.Numeros.length; i++){
            Numeros[i][numColumna]=Columna.Numeros[i];
        }
    }//End reemplazarColumna
    public Vector getColumna(int numColumna, int numMultiplicacion){
        Vector aux = new Vector(Filas);
        for(int i = 0; i < Filas; i++){
            aux.Numeros[i]= Numeros[numColumna][i] * numMultiplicacion;
        }
        return aux;
    }//End getColumna
    public Vector getFila(int numFila, int numMultiplicacion){
        Vector aux = new Vector(Columnas);
        for(int i = 0; i < Columnas; i++){
            aux.Numeros[i]= Numeros[numFila][i] * numMultiplicacion;
        }
        return aux;
    }//End getFila
    public void cambiarColumnas(int Columna1, int Columna2){
        Vector ColumnaAux = getColumna(Columna1,1);
        reemplazarColumna(Columna1, getColumna(Columna2, 1));
        reemplazarColumna(Columna2, ColumnaAux);
    }//cambiarColumnas
    public void cambiarFilas(int Fila1, int Fila2){
        Vector FilaAux = getFila(Fila1, 1);
        reemplazarFila(Fila1, getFila(Fila2, 1));
        reemplazarFila(Fila2, FilaAux);
    }//End cambiarColumnas
}
