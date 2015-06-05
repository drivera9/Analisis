package com.numericos.proyectofinal.logic;


public class IncrementalSearch {

    private Funcion fx;
    private double x0;
    private double delta;
    private double iteraciones;
    String[] resultadoTabla;
    String[] temp;

    public IncrementalSearch(){
        //fx = new Funcion("e^(3x-12) + x*cos(3x) - (x^2) + 4 ");
    }

    private double f(double x){
        return fx.evaluar(x);
    }

    //retorna -1 si es un fracaso, retorna 0 si X0 es una raiz y retorna 1 si es el intervalo X0, X1.
    public String execute(){
        double y0, y1, x1, FxAnt;
        y0 = f(x0);
        int cont=0;

        resultadoTabla = new String[]{"n", "X", "F(X)", "F(X)*F(X ant.)"};
        temp = new String[resultadoTabla.length + 4];
        System.arraycopy(resultadoTabla, 0, temp, 0, resultadoTabla.length);

        temp[temp.length - 4] = String.valueOf(cont); //n
        temp[temp.length - 3] = String.valueOf(x0); //Resultado X
        temp[temp.length - 2] = String.valueOf(y0); //Resultado F(X)
        temp[temp.length - 1] = ""; //Resultado F(X)*F(X ant.)

        resultadoTabla = temp;

        if(y0 == 0){
            System.out.println(x0+" es una raíz.");
            return x0+" es una raíz.";
            //return 0;
        }

        if(delta != 0){
            if(iteraciones > 0){
                x1 = x0 + delta;
                y1 = f(x1);
                FxAnt = y1*y0;

                temp = new String[resultadoTabla.length + 4];
                System.arraycopy(resultadoTabla, 0, temp, 0, resultadoTabla.length);

                temp[temp.length - 4] = String.valueOf(cont+1); //n
                temp[temp.length - 3] = String.valueOf(x1); //Resultado X
                temp[temp.length - 2] = String.valueOf(y1); //Resultado F(X)
                temp[temp.length - 1] = String.valueOf(FxAnt); //Resultado F(X)*F(X ant.)

                resultadoTabla = temp;


                for(int contador = 1; (y1*y0 > 0) && contador < iteraciones  ; contador++){
                    x0 = x1;
                    y0 = y1;
                    x1 = x0 + delta;
                    y1 = f(x1);
                    FxAnt = y1*y0;

                    temp = new String[resultadoTabla.length + 4];
                    System.arraycopy(resultadoTabla, 0, temp, 0, resultadoTabla.length);

                    temp[temp.length - 4] = String.valueOf(contador+1); //n
                    temp[temp.length - 3] = String.valueOf(x1); //Resultado X
                    temp[temp.length - 2] = String.valueOf(y1); //Resultado F(X)
                    temp[temp.length - 1] = String.valueOf(FxAnt); //Resultado F(X)*F(X ant.)

                    resultadoTabla = temp;
                }
                if(y1 == 0){
                    System.out.println(x1+" es una raíz.");
                    return x1+" es una raíz.";
                }else{
                    if(y1*y0 < 0){
                        System.out.println("La raiz esta entre en intervalo (" + x0 +","+ x1 +")");
                        return "La raíz esta entre en intervalo [" + x0 +" , "+ x1 +"]";
                    }else{
                        System.out.println("Fracaso.");
                        return "Fracaso.";
                    }
                }
            }
        }
        return "nada";
    }

    public Funcion getFx() {
        return fx;
    }

    public void setFx(String funct) {
        this.fx = new Funcion(funct);
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getIteraciones() {
        return iteraciones;
    }

    public void setIteraciones(double iteraciones) {
        this.iteraciones = iteraciones;
    }

    public String[] getArrayResultado() {
        return resultadoTabla;
    }
}
