package com.numericos.proyectofinal.views.interpolation;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.views.single_variable.Fragment_Single_Variable;

public class Entrada_datos_interpolacion extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_datos_interpolacion);
    }

    public void continuar(View v ){

        EditText x = (EditText)findViewById(R.id.puntosx);
        EditText y = (EditText)findViewById(R.id.puntosy);
        EditText interpolar = (EditText)findViewById(R.id.puntosinterpolar);
        EditText valort = (EditText)findViewById(R.id.valorT);
        EditText puntosf = (EditText)findViewById(R.id.puntosf);


        String X = x.getText().toString();
        String Y = y.getText().toString();
        String Interpolar = interpolar.getText().toString();
        String Valort = valort.getText().toString();
        String Puntosf = puntosf.getText().toString();


        Bundle parametros = new Bundle();
        parametros.putString("X", X);
        parametros.putString("Y", Y);
        parametros.putString("Interpolar", Interpolar);
        parametros.putString("Valort", Valort);
        parametros.putString("Puntosf", Puntosf);



        finish();
        Intent SingleVariable = new Intent(this,Fragment_Interpolation.class);
        SingleVariable.putExtras(parametros);
        startActivity(SingleVariable);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entrada_datos_interpolacion, menu);
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
