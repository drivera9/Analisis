package com.numericos.proyectofinal.views.graficador;

import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by Esteven Quintero on 21/04/14.
 */
public class Datos {
    static int parteTab = 0;
    static String formula="";
    static double Xmin = 0;
    static double Xmax = 0;
    static double Yint = 0;
    static boolean button = false;
    static ArrayList<String> datos = new ArrayList<String>();
    static Matriz matriz = new Matriz(3,3);
    static String UltimaPantalla = "";
    public static Datos qdatos = new Datos();
    boolean inicio = true;
    Parseador parseador = new Parseador();
    Paint paint = new Paint();


    static public void crearLista(){
                datos.clear();
                matriz.Numeros [0][0] = 11.34;
                matriz.Numeros [0][1] = 21;
                matriz.Numeros [0][2] = 21444;
                matriz.Numeros [1][0] = 22231;
                matriz.Numeros [1][1] = 111101;
                matriz.Numeros [1][2] = 11.33331;
                matriz.Numeros [2][0] = 22.221;
                matriz.Numeros [2][1] = 55521;
                matriz.Numeros [2][2] = 988221;
                matriz.Cabecera[0]= "primera";
                matriz.Cabecera[1] = "segunda";
                matriz.Cabecera[2] = "tercera";
               //double[] Hacialista = matriz.getFila(i, 1);
               //for(int j = 0; j < Hacialista.length; j++){
               //    double actual = Hacialista[i];
               //    datos.add(Double.toString(actual));
               //}

    }



}
