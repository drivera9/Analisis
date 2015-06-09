package com.numericos.proyectofinal.views.graficador;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class Graficador extends View {
    public static Datos datos = new Datos();
    boolean inicio = true;
    Parseador parseador = new Parseador();
        Paint paint = new Paint();
        float dpi = getResources().getDisplayMetrics().density;

        public Graficador(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.setBackgroundColor(Color.WHITE);
            paint.setColor(Color.BLACK);
        }

        public void onDraw(Canvas canvas) {

            if(!inicio && datos.button==true){
                canvas.drawLine(0, 150*dpi,300*dpi,150*dpi, paint);
                double Xmin;
                double Xmax;
                double Yint;
                String formula;
                if(datos.formula!=""){
                    Xmin = datos.Xmin;
                    Xmax = datos.Xmax;
                    Yint = datos.Yint;
                    formula = datos.formula;
                }else{
                    Xmin = -5;
                    Xmax = 5;
                    Yint = 3;
                    formula = "(x)";
                }

                double Delta = (Xmax-Xmin)/300;

                if(Xmin<0 && Xmax>0){
                    float Zerois=(float) (-Xmin*300/(-Xmin+Xmax));
                    canvas.drawLine(Zerois*dpi, 0*dpi,Zerois*dpi,300*dpi, paint);
                }
                String num = datos.Xmax + "";
                canvas.drawText(num,260*dpi,150*dpi,paint);
                String num2 = datos.Xmin + "";
                canvas.drawText(num2,0*dpi,150*dpi,paint);
                String num3 = datos.Yint + "";
                canvas.drawText(num3,150*dpi,10*dpi,paint);
                String num4 = "-" + datos.Yint + "";
                canvas.drawText(num4,150*dpi,300*dpi,paint);

                for(double i = 0; i < 300; i=i+0.05){
                    double valor = parseador.evaluador(formula,(Xmin+(Delta*i)));
                    float valorinY = 150;
                    if(valor<Yint && valor>(-Yint)){
                        if(valor!=0){
                            if(valor>0){
                                valorinY = (float) (150-((150*valor)/Yint));
                            }else{
                                valorinY = (float) (150+((150* Math.abs(valor))/Yint));
                            }
                        }
                        canvas.drawLine((float)(i)*dpi, (valorinY)*dpi,(float)(i)*dpi,(float)(valorinY+2)*dpi, paint);

                    }

                }

            }else{
                canvas.drawLine(0, 150*dpi,300*dpi,150*dpi, paint);
                canvas.drawLine(150*dpi, 0*dpi,150*dpi,300*dpi, paint);
                inicio=false;
            }
        }


}


