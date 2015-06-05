package com.numericos.proyectofinal.views.interpolation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.logic.Lagrange;
import com.numericos.proyectofinal.logic.SystemsOfEquations;

/**
 * Created by Sara Castrillón on 25/11/2014.
 */
public class Lagrange_Method extends Activity {

    private Button execute_button;
    private EditText matrix_editText, indepTerms_editText, interpolated_Value_editText;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lagrange_method);

        final Bundle parametros = this.getIntent().getExtras();

        final String X = parametros.getString("X");
        final String Y = parametros.getString("Y");
        final String Interpolar = parametros.getString("Interpolar");
        final String Valort = parametros.getString("Valort");
        final String Puntosf = parametros.getString("Puntosf");

        matrix_editText = (EditText) findViewById(R.id.gaussianMatrix_editText);
        matrix_editText.setText(X);

        indepTerms_editText = (EditText) findViewById(R.id.indep_terms_editText);
        indepTerms_editText.setText(Y);

        interpolated_Value_editText = (EditText) findViewById(R.id.interpolated_value_editText);
        interpolated_Value_editText.setText(Interpolar);

        execute_button = (Button) findViewById(R.id.gaussian_button);

        execute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String mtx = matrix_editText.getText().toString();


                String indepTerms = indepTerms_editText.getText().toString();


                String interpolatedvalue = interpolated_Value_editText.getText().toString();
                Double i_value = Double.valueOf(interpolatedvalue).doubleValue();

                Lagrange lagrange = new Lagrange();
                SystemsOfEquations systemOfEquations = new SystemsOfEquations();
                double [] matrix = systemOfEquations.textToVector(mtx);
                double [] vector = systemOfEquations.textToVector(indepTerms);

                lagrange.Lagrange(matrix, vector, i_value);
                Log.d("ass", lagrange.getRes());

                AlertDialog.Builder builder = new AlertDialog.Builder(Lagrange_Method.this);
                builder.setMessage(lagrange.getRes())
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {

                            }
                        });
                // Create the AlertDialog object and return it
                builder.create();
                builder.show();
            }
        });
    }

    public void help(View v){
        Intent SingleVariable = new Intent(this,HelpLagrange.class);
        startActivity(SingleVariable);
    }
}
