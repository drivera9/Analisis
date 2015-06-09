package com.numericos.proyectofinal.views.graficador;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.numericos.proyectofinal.R;

/**
 * Created by hp on 08/06/2015.
 */
public class temporal extends Activity {
    double num = 0;
    String solve = "";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metodo_grafico);
    }

    public void draw(View v){
            try{
                Datos.button=true;
                float dpi = getResources().getDisplayMetrics().density;
                findViewById(R.id.graficadorfuncion).setBackgroundColor(Color.GRAY);
                //EditText XminEditText = (EditText) findViewById(R.id.Xmingraf);
                //EditText XmaxEditText = (EditText) findViewById(R.id.Xmaxgraf);
                //EditText YEditText = (EditText) findViewById(R.id.Ygraf);
                EditText Formula = (EditText) findViewById(R.id.formula_ID);
                Graficador.datos.formula =  Formula.getText().toString();


                Graficador.datos.Xmax  = 20;//Double.parseDouble(XmaxEditText.getText().toString());
                Graficador.datos.Xmin  = -20;//Double.parseDouble(XminEditText.getText().toString());
                Graficador.datos.Yint  = 10;//Double.parseDouble(YEditText.getText().toString());
                findViewById(R.id.graficadorfuncion).invalidate();
            }catch (Exception e) {
                Toast toast = Toast.makeText(getApplicationContext(), "Hace faltan datos, por favor verifique", Toast.LENGTH_SHORT);

                toast.show();
            }
        }

    public void izquierda(View v){
        try{
            findViewById(R.id.graficadorfuncion).setBackgroundColor(Color.GRAY);
            EditText Formula = (EditText) findViewById(R.id.formula_ID);
            Graficador.datos.formula =  Formula.getText().toString();
            double Delta = ((Graficador.datos.Xmax-Graficador.datos.Xmin)/8);
            Graficador.datos.Xmax  = Graficador.datos.Xmax - Delta;//Double.parseDouble(XmaxEditText.getText().toString());
            Graficador.datos.Xmin  = Graficador.datos.Xmin - Delta;//Double.parseDouble(XminEditText.getText().toString());
            //Graficador.datos.Yint  = 10;//Double.parseDouble(YEditText.getText().toString());
            findViewById(R.id.graficadorfuncion).invalidate();
        }catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(), "Hace faltan datos, por favor verifique", Toast.LENGTH_SHORT);

            toast.show();
        }
    }

    public void derecha(View v){
        try{
        findViewById(R.id.graficadorfuncion).setBackgroundColor(Color.GRAY);
        EditText Formula = (EditText) findViewById(R.id.formula_ID);
        Graficador.datos.formula =  Formula.getText().toString();
        double Delta = ((Graficador.datos.Xmax-Graficador.datos.Xmin)/8);
        Graficador.datos.Xmax  = Graficador.datos.Xmax + Delta;//Double.parseDouble(XmaxEditText.getText().toString());
        Graficador.datos.Xmin  = Graficador.datos.Xmin + Delta;//Double.parseDouble(XminEditText.getText().toString());
        //Graficador.datos.Yint  = 10;//Double.parseDouble(YEditText.getText().toString());
        findViewById(R.id.graficadorfuncion).invalidate();
    }catch (Exception e) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hace faltan datos, por favor verifique", Toast.LENGTH_SHORT);

        toast.show();
        }
    }

    public void masY(View v){
        try{
            findViewById(R.id.graficadorfuncion).setBackgroundColor(Color.GRAY);
            EditText Formula = (EditText) findViewById(R.id.formula_ID);
            Graficador.datos.formula =  Formula.getText().toString();
            double Delta = Graficador.datos.Yint/3;
            Graficador.datos.Yint  = Graficador.datos.Yint + Delta;//Double.parseDouble(YEditText.getText().toString());
            findViewById(R.id.graficadorfuncion).invalidate();
        }catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(), "Hace faltan datos, por favor verifique", Toast.LENGTH_SHORT);
            toast.setDuration(1000);
            toast.show();
        }
    }

    public void menosY(View v){
        try{
            findViewById(R.id.graficadorfuncion).setBackgroundColor(Color.GRAY);
            EditText Formula = (EditText) findViewById(R.id.formula_ID);
            Graficador.datos.formula =  Formula.getText().toString();
            double Delta = Graficador.datos.Yint/3;
            Graficador.datos.Yint  = Graficador.datos.Yint - Delta;//Double.parseDouble(YEditText.getText().toString());
            findViewById(R.id.graficadorfuncion).invalidate();
        }catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(), "Hace faltan datos, por favor verifique", Toast.LENGTH_SHORT);
            toast.setDuration(1000);
            toast.show();
        }
    }

    public void zoomMas(View v){
        try{
            findViewById(R.id.graficadorfuncion).setBackgroundColor(Color.GRAY);
            EditText Formula = (EditText) findViewById(R.id.formula_ID);
            Graficador.datos.formula =  Formula.getText().toString();
            double Delta = ((Graficador.datos.Xmax-Graficador.datos.Xmin)/8);
            Graficador.datos.Xmax  = Graficador.datos.Xmax - Delta;//Double.parseDouble(XmaxEditText.getText().toString());
            Graficador.datos.Xmin  = Graficador.datos.Xmin + Delta;//Double.parseDouble(XminEditText.getText().toString());
            double Delta2 = Graficador.datos.Yint/3;
            Graficador.datos.Yint  = Graficador.datos.Yint - Delta2 ;//Double.parseDouble(YEditText.getText().toString());
            findViewById(R.id.graficadorfuncion).invalidate();
        }catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(), "Hace faltan datos, por favor verifique", Toast.LENGTH_SHORT);
            toast.setDuration(1000);
            toast.show();
        }
    }

    public void zoomMenos(View v){
        try{
            findViewById(R.id.graficadorfuncion).setBackgroundColor(Color.GRAY);
            EditText Formula = (EditText) findViewById(R.id.formula_ID);
            Graficador.datos.formula =  Formula.getText().toString();
            double Delta = ((Graficador.datos.Xmax-Graficador.datos.Xmin)/8);
            Graficador.datos.Xmax  = Graficador.datos.Xmax + Delta;//Double.parseDouble(XmaxEditText.getText().toString());
            Graficador.datos.Xmin  = Graficador.datos.Xmin - Delta;//Double.parseDouble(XminEditText.getText().toString());
            double Delta2 = Graficador.datos.Yint/3;
            Graficador.datos.Yint  = Graficador.datos.Yint + Delta2 ;//Double.parseDouble(YEditText.getText().toString());
            findViewById(R.id.graficadorfuncion).invalidate();
        }catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(), "Hace faltan datos, por favor verifique", Toast.LENGTH_SHORT);
            toast.setDuration(1000);
            toast.show();
        }
    }
}