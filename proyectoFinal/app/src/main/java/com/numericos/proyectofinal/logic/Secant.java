package com.numericos.proyectofinal.logic;


public class Secant {

    private double[][] tabla;
    private String mensaje;
    private Funcion fx;
    private Funcion dfx;
    private Funcion ddfx;
    private Funcion gx;
    private double x0;
    private double x1;
    private double tolerance;
    private double iterations;
    String[] resultadoTabla;
    String[] temp;


    public void setdfx(String dfx){
        this.dfx = new Funcion(dfx);
    }

    public void setddfx(String ddfx){
        this.ddfx = new Funcion(ddfx);
    }

    public void setgx(String gx){
        this.gx = new Funcion(gx);
    }

    public double[][] getTabla(){
        return tabla;
    }

    public String getMensaje(){
        return mensaje;
    }

    private double f(double x){
        x = fx.evaluar(x);
        return x;
    }

    private double df(double x){
        x = dfx.evaluar(x);
        return x;
    }

    private double ddf(double x){
        x = ddfx.evaluar(x);
        return x;
    }

    private double g(double x){
        x = gx.evaluar(x);
        return x;
    }

    private void agregarDatos(double[] dato){
        double[][] aux = new double[tabla.length][tabla[0].length];
        for(int i=0;i<tabla.length;i++){
            for(int j=0;j<tabla[0].length;j++){
                aux[i][j] = tabla[i][j];
            }
        }

        tabla = new double[tabla.length+1][tabla[0].length];
        for(int i=0;i<aux.length;i++){
            for(int j=0;j<aux[0].length;j++){
                tabla[i][j] = aux[i][j];
            }
        }
        for(int i=0;i<dato.length;i++){
            tabla[aux.length][i] = dato[i];
        }
    }

    public Secant() {
        //this.fx = new Funcion(funcion);
    }

    public String secanteMethod(double a, double b, double t, double i){
        double Ya=f(a);
        double Yb=f(b);
        if(Ya == 0){
           return "Hay una raiz en x = "+a;
        }else{
            if(Yb == 0){
                return "Hay una raiz en x = "+b;
            }else{
                resultadoTabla = new String[]{"n", "Xn", "F(Xn)","ErrorAbs","ErrorRel"};
                temp = new String[resultadoTabla.length + 5];
                System.arraycopy(resultadoTabla, 0, temp, 0, resultadoTabla.length);

                temp[temp.length - 5] = String.valueOf(0); //n
                temp[temp.length - 4] = String.valueOf((a)); //Xn
                temp[temp.length - 3] = String.valueOf(Ya); //F(Xn)
                temp[temp.length - 2] = "No Existe"; //ErrorAbs
                temp[temp.length - 1] = "No Existe"; //ErrorRel

                resultadoTabla = temp;


                temp = new String[resultadoTabla.length + 5];
                System.arraycopy(resultadoTabla, 0, temp, 0, resultadoTabla.length);

                temp[temp.length - 5] = String.valueOf(1); //n
                temp[temp.length - 4] = String.valueOf((b)); //Xn
                temp[temp.length - 3] = String.valueOf(Yb); //F(Xn)
                temp[temp.length - 2] = "No Existe"; //ErrorAbs
                temp[temp.length - 1] = "No Existe"; //ErrorRel

                resultadoTabla = temp;

                double Xm = b - Yb*((b-a)/(Yb-Ya));
                double Ym = f(Xm);
                double aux = b;
                double Yaux = f(aux);
                double aux2=Xm;
                double Yaux2=Ym;
                double E= t+1;
                int cont=1;
                tabla = new double[1][4];
                tabla[0][0] = cont;
                tabla[0][1] = Xm;
                tabla[0][2] = Ym;
                double[] Taux = new double[4];


                temp = new String[resultadoTabla.length + 5];
                System.arraycopy(resultadoTabla, 0, temp, 0, resultadoTabla.length);

                temp[temp.length - 5] = String.valueOf(cont+1); //n
                temp[temp.length - 4] = String.valueOf((Xm)); //Xn
                temp[temp.length - 3] = String.valueOf(Ym); //F(Xn)
                temp[temp.length - 2] = String.valueOf(Math.abs(Xm-b)); //ErrorAbs
                temp[temp.length - 1] = String.valueOf(Math.abs((Xm-b)/Xm)); //ErrorRel

                resultadoTabla = temp;


                while(Ym!=0 && E>t && cont<i){
                    Xm = aux2 - Yaux2*((aux2-aux)/(Yaux2-Yaux));
                    Ym = f(Xm);
                    aux = aux2;
                    Yaux = Yaux2;
                    aux2 = Xm;
                    Yaux2 = Ym;
                    E=Math.abs(Xm-aux);
                    cont++;
                    Taux[0] = cont;
                    Taux[1] = Xm;
                    Taux[2] = Ym;
                    Taux[3] = E;
                    agregarDatos(Taux);

                    temp = new String[resultadoTabla.length + 5];
                    System.arraycopy(resultadoTabla, 0, temp, 0, resultadoTabla.length);

                    temp[temp.length - 5] = String.valueOf(cont+1); //n
                    temp[temp.length - 4] = String.valueOf((Xm)); //Xn
                    temp[temp.length - 3] = String.valueOf(Ym); //F(Xn)
                    temp[temp.length - 2] = String.valueOf(E); //ErrorAbs
                    temp[temp.length - 1] = String.valueOf(Math.abs(E/Xm)); //ErrorRel

                    resultadoTabla = temp;

                }
                if(Ym == 0){
                    mensaje = "Hay una raiz en x = "+Xm;
                    return mensaje;
                }else{
                    if(E<=t){
                        mensaje = "Hay una raiz en x = "+Xm+" con un Error de "+E;
                        return mensaje;
                    }else{
                        mensaje = "Fracaso: no se halló raiz en "+i+" iteraciones";
                        return mensaje;
                    }
                }
            }
        }
    }
    public Funcion getFx() {
        return fx;
    }

    public void setFx(String funct) {
        this.fx = new Funcion(funct);
    }

    public Funcion getDFx() {
        return dfx;
    }

    public void setDFx(String funct) {
        this.dfx = new Funcion(funct);
    }

    public Funcion getDdFx() {
        return ddfx;
    }

    public void setDdfx(String funct) {
        this.ddfx = new Funcion(funct);
    }

    public Funcion getGx() {
        return gx;
    }

    public void setGx(String funct) {
        this.gx = new Funcion(funct);
    }

    public double getTolerance() {
        return tolerance;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getIterations() {
        return iterations;
    }

    public void setIterations(double iteraciones) {
        this.iterations = iteraciones;
    }
    public String[] getArrayResultado() {
        return resultadoTabla;}
}
