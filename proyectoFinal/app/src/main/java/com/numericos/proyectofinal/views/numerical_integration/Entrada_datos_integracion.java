package com.numericos.proyectofinal.views.numerical_integration;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.views.interpolation.Fragment_Interpolation;

public class Entrada_datos_integracion extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_datos_integracion);
    }


    public void continuar (View v){
        EditText x0 = (EditText)findViewById(R.id.x0);
        EditText x1 = (EditText)findViewById(R.id.x1);
        EditText funcion = (EditText)findViewById(R.id.fun);
        EditText intervalos = (EditText)findViewById(R.id.intervalos);


        String X0 = x0.getText().toString();
        String X1 = x1.getText().toString();
        String Funcion = funcion.getText().toString();
        String Intervalos = intervalos.getText().toString();


        Bundle parametros = new Bundle();
        parametros.putString("X0", X0);
        parametros.putString("X1", X1);
        parametros.putString("Funcion", Funcion);
        parametros.putString("Intervalos", Intervalos);



        finish();
        Intent SingleVariable = new Intent(this,Fragment_Numerical_Integration.class);
        SingleVariable.putExtras(parametros);
        startActivity(SingleVariable);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entrada_datos_integracion, menu);
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
