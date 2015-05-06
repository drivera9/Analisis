package com.numericos.proyectofinal.views.system_equations;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.logic.SystemsOfEquations;
import com.numericos.proyectofinal.views.single_variable.HelpMultipleRoots;

/**
 * Created by JU on 10/21/2014.
 */

public class SimpleGaussianMethod extends Activity {

    private Button execute_button;
    private EditText matrix_editText, indepTerms_editText;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_gaussian_method);

        Bundle parametros = this.getIntent().getExtras();
        final String MatrizA = parametros.getString("MatrizA");
        final String VectorB = parametros.getString("VectorB");

        final EditText matrizA = (EditText) findViewById(R.id.gaussianMatrix_editText);
        final EditText vectorB = (EditText) findViewById(R.id.indep_terms_editText);

        matrizA.setText(MatrizA);
        vectorB.setText(VectorB);


        execute_button = (Button) findViewById(R.id.gaussian_button);

        execute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mtx = matrizA.getText().toString();

                String indepTerms = vectorB.getText().toString();

                SystemsOfEquations systemOfEquations = new SystemsOfEquations();
                double [][] matrix = systemOfEquations.textToMatrix(mtx);
                double [] vector = systemOfEquations.textToVector(indepTerms);

                systemOfEquations.eliminacionGauss(matrix, vector, -1);
                Log.d("ass", systemOfEquations.getRes());

                AlertDialog.Builder builder = new AlertDialog.Builder(SimpleGaussianMethod.this);
                builder.setMessage(systemOfEquations.getRes())
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

    public void helpSimpleEliminacion(View v){
        Intent help = new Intent(getApplicationContext(),HelpEliminacionSimple.class);
        startActivity(help);
    }
}
