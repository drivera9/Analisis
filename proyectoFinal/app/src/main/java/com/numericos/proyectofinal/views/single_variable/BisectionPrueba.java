package com.numericos.proyectofinal.views.single_variable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.Tabla;
import com.numericos.proyectofinal.logic.Bisection;
import com.numericos.proyectofinal.views.util.CustomKeyboard;

import java.util.ArrayList;


public class BisectionPrueba extends Activity {
    private Button tabla_button;
    private Bisection bisection;
    private Button execute_button;
    private TextView Resultado_bisection;
    private String resultado;
    private CustomKeyboard mCustomKeyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bisection_prueba);

        Bundle parametros = this.getIntent().getExtras();
        final String xibiseccion = parametros.getString("Xi");
        final String xsbiseccion = parametros.getString("Xs");
        final String tolerance = parametros.getString("Tolerance");
        final String iterations = parametros.getString("Iterations");
        final String function = parametros.getString("Fx");


        bisection = new Bisection();

        final EditText x0_editText = (EditText) findViewById(R.id.x0_editText);
        final EditText x1_editText = (EditText) findViewById(R.id.x1);
        final EditText tolerance_editText = (EditText) findViewById(R.id.tolerancia);
        final EditText iterations_editText = (EditText) findViewById(R.id.iteraciones);
        final EditText function_editText = (EditText) findViewById(R.id.funcion);
        Resultado_bisection = (TextView)findViewById(R.id.Resultado_bisection);

        x0_editText.setText(xibiseccion);
        x1_editText.setText(xsbiseccion);
        tolerance_editText.setText(tolerance);
        iterations_editText.setText(iterations);
        function_editText.setText(function);


        execute_button = (Button) findViewById(R.id.Bisection_button);
        execute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               /* Double X0=Double.parseDouble(xibiseccion);
                Double X1=Double.parseDouble(xsbiseccion);
                Double TOLERANCE=Double.parseDouble(tolerance);
                Double ITERATIONS=Double.parseDouble(iterations);

                bisection.setX0(X0);
                bisection.setX1(X1);
                bisection.setTolerance(TOLERANCE);
                bisection.setIterations(ITERATIONS);
                bisection.setFx(function);
*/






                double x0 = Double.parseDouble(x0_editText.getText().toString());
                double x1 = Double.parseDouble(x1_editText.getText().toString());
                double tolerance = Double.parseDouble(tolerance_editText.getText().toString());
                double iterations = Double.parseDouble(iterations_editText.getText().toString());
                String funct = function_editText.getText().toString();

                bisection.setX0(x0);
                bisection.setX0(x1);
                bisection.setTolerance(tolerance);
                bisection.setIterations(iterations);
                bisection.setFx(funct);

                resultado = bisection.bisectionMethod(x0,x1,tolerance,iterations);


                //function_editText.setTextColor(Color.RED);
                String displayString = "The result is: " + resultado;


                Resultado_bisection = (TextView) findViewById(R.id.Resultado_bisection);
                Resultado_bisection.setText(resultado);

                Toast msg = Toast.makeText(getBaseContext(), displayString,
                        Toast.LENGTH_LONG);
                msg.show();
            }
        });


        tabla_button = (Button) findViewById(R.id.tabla_button);
        tabla_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 ArrayList<Double> ArrayIteracionesAux = new ArrayList<Double>();
                Bisection bisection;
                bisection = new Bisection();
                ArrayIteracionesAux = bisection.getArray();
                Bundle parametros = new Bundle();
                ArrayList<String> ArrayStrings= new ArrayList<String>();
                for(int i=0;i<bisection.getArray().size(); i++)
                {
                    String aux= ArrayIteracionesAux.get(i).toString();
                    ArrayStrings.add(aux);
                }

                parametros.putStringArrayList("Array", ArrayStrings);
                Intent SingleVariable = new Intent(getApplicationContext(),Tabla.class);
                SingleVariable.putExtras(parametros);
                startActivity(SingleVariable);


            }
        });



    }

    public void helpBiseccion(View v){
        Intent help = new Intent(getApplicationContext(),HelpBiseccion.class);
        startActivity(help);
    }

    public void ejecutar(){
    Bisection bisection;
        Bundle parametros = this.getIntent().getExtras();
        String xibiseccion = parametros.getString("Xi");
        String xsbiseccion = parametros.getString("Xs");
        String tolerance = parametros.getString("Tolerance");
        String iterations = parametros.getString("Iterations");
        String function = parametros.getString("Fx");

        bisection = new Bisection();

        Double X0=Double.parseDouble(xibiseccion);
        Double X1=Double.parseDouble(xsbiseccion);
        Double TOLERANCE=Double.parseDouble(tolerance);
        Double ITERATIONS=Double.parseDouble(iterations);
        bisection.setX0(X0);
        bisection.setX1(X1);
        bisection.setTolerance(TOLERANCE);
        bisection.setIterations(ITERATIONS);
        bisection.setFx(function);


        String resultado = bisection.bisectionMethod(X0,X1,TOLERANCE,ITERATIONS);
        TextView Resultado = (TextView)findViewById(R.id.Resultado_bisection);
        Resultado.setText(resultado);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bisection_prueba, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
