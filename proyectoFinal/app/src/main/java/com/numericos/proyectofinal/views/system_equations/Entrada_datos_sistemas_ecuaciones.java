package com.numericos.proyectofinal.views.system_equations;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.views.single_variable.Fragment_Single_Variable;


public class Entrada_datos_sistemas_ecuaciones extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_datos_sistemas_ecuaciones);
    }

    public void Hacer(View v) {
        EditText MatrizA = (EditText)findViewById(R.id.matriz_a);
        EditText VectorB = (EditText)findViewById(R.id.vector_b);
        EditText Tolerancia = (EditText)findViewById(R.id.tolerancia);
        EditText Iteraciones = (EditText)findViewById(R.id.iteraciones);
        EditText ValoresIniciales = (EditText)findViewById(R.id.valores_iniciales);
        EditText Lambda = (EditText)findViewById(R.id.lambda);


        String matrizA = MatrizA.getText().toString();
        String vectorB = VectorB.getText().toString();
        String tolerancia = Tolerancia.getText().toString();
        String iteraciones = Iteraciones.getText().toString();
        String valoresIniciales = ValoresIniciales.getText().toString();
        String lambda = Lambda.getText().toString();

        Bundle parametros = new Bundle();
        parametros.putString("matrizA", matrizA);
        parametros.putString("vectorB", vectorB);
        parametros.putString("tolerancia", tolerancia);
        parametros.putString("iteraciones", iteraciones);
        parametros.putString("valoresIniciales", valoresIniciales);
        parametros.putString("lambda", lambda);

        finish();
        Intent SingleVariable = new Intent(this,Fragment_System_Equation.class);
        SingleVariable.putExtras(parametros);
        startActivity(SingleVariable);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entrada_datos_sistemas_ecuaciones, menu);
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
