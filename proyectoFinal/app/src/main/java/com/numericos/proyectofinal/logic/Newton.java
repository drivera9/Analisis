package com.numericos.proyectofinal.logic;

import org.nfunk.jep.function.Str;


public class Newton {
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
    public Newton() {
        // TODO Auto-generated constructor stub
       // this.fx = new Funcion(funcion);
        //this.dfx = new Funcion(funcion2);
    }
    public String newtonMethod(double Xm, double t, double i){
        double aux;
        double E = t+1;
        int cont=1;
        double Ym = f(Xm);
        double Y1m = df(Xm);
        resultadoTabla = new String[]{"n", "Xn", "F(Xn)","F´(Xn)","ErrorAbs","ErrorRel"};
        temp = new String[resultadoTabla.length + 6];
        System.arraycopy(resultadoTabla, 0, temp, 0, resultadoTabla.length);

        temp[temp.length - 6] = String.valueOf(0); //n
        temp[temp.length - 5] = String.valueOf((Xm)); //Xn
        temp[temp.length - 4] = String.valueOf(Ym); //F(Xn)
        temp[temp.length - 3] = String.valueOf((Y1m)); //F´(Xn)
        temp[temp.length - 2] = "No Existe"; //ErrorAbs
        temp[temp.length - 1] = "No Existe"; //ErrorRel

        resultadoTabla = temp;
        tabla = new double[1][4];
        tabla[0][0] = cont;
        tabla[0][1] = Xm;
        tabla[0][2] = Ym;
        double[] Taux = new double[4];
        while(Ym!=0 && E>t && cont<i && Y1m!=0){
            aux = Xm;
            Xm = Xm - (Ym/Y1m);
            Ym = f(Xm);
            Y1m = df(Xm);
            E = Math.abs((Xm - aux));
            cont++;
            Taux[0] = cont;
            Taux[1] = Xm;
            Taux[2] = Ym;
            Taux[3] = E;
            agregarDatos(Taux);
            temp = new String[resultadoTabla.length + 6];
            System.arraycopy(resultadoTabla, 0, temp, 0, resultadoTabla.length);

            temp[temp.length - 6] = String.valueOf(cont-1); //n
            temp[temp.length - 5] = String.valueOf((Xm)); //Xn
            temp[temp.length - 4] = String.valueOf(Ym); //F(Xn)
            temp[temp.length - 3] = String.valueOf((Y1m)); //F´(Xn)
            temp[temp.length - 2] = String.valueOf(E); //ErrorAbs
            temp[temp.length - 1] = String.valueOf(Math.abs(E/Xm));  //ErrorRel

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
                if(Y1m==0){
                    mensaje = "El método de Newton no es apropiado para este caso ya que f'("+Xm+") = 0";
                    return mensaje;
                }else{
                    mensaje = "Fracaso: no se halló raiz en "+i+" iteraciones";
                    return mensaje;
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
