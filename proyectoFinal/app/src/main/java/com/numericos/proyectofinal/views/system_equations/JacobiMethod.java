package com.numericos.proyectofinal.views.system_equations;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.logic.SystemsOfEquations;

/**
 * Created by JU on 10/21/2014.
 */

public class JacobiMethod extends Activity {

    private Button execute_button;
    private EditText matrix_editText, indepTerms_editText, tolerance_editText, iterations_editText, initial_values_editText, lambda_editText ;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jacobi_method);

        Bundle parametros = this.getIntent().getExtras();
        final String MatrizA = parametros.getString("MatrizA");
        final String VectorB = parametros.getString("VectorB");
        final String Iteraciones = parametros.getString("Iteraciones");
        final String Tolerancia = parametros.getString("Tolerancia");
        final String ValoresIniciales = parametros.getString("ValoresIniciales");
        final String Lambda = parametros.getString("Lambda");

        final EditText matrizA = (EditText) findViewById(R.id.matrix_editText);
        final EditText vectorB = (EditText) findViewById(R.id.indep_terms_editText);
        final EditText iteraciones = (EditText) findViewById(R.id.iteraciones);
        final EditText tolerancia = (EditText) findViewById(R.id.tolerance_editText);
        final EditText valoresIniciales = (EditText) findViewById(R.id.valores_iniciales);
        final EditText lambda = (EditText) findViewById(R.id.lambda);

        matrizA.setText(MatrizA);
        vectorB.setText(VectorB);

        execute_button = (Button) findViewById(R.id.gaussian_button);

        execute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                matrix_editText = (EditText) findViewById(R.id.gaussianMatrix_editText);
                String mtx = matrix_editText.getText().toString();

                indepTerms_editText = (EditText) findViewById(R.id.indep_terms_editText);
                String indepTerms = indepTerms_editText.getText().toString();

                tolerance_editText = (EditText) findViewById(R.id.editText);
                double tolerance = Double.parseDouble(tolerance_editText.getText().toString());

                iterations_editText = (EditText) findViewById(R.id.editText2);
                int iterations = Integer.parseInt(iterations_editText.getText().toString());

                initial_values_editText = (EditText) findViewById(R.id.editText3);
                String initialValues = initial_values_editText.getText().toString();

                lambda_editText = (EditText) findViewById(R.id.editText4);
                double lambda = Double.parseDouble(lambda_editText.getText().toString());

                SystemsOfEquations systemOfEquations = new SystemsOfEquations();
                double [][] matrix = systemOfEquations.textToMatrix(mtx);
                double [] vector = systemOfEquations.textToVector(indepTerms);
                double [] initialVal = systemOfEquations.textToVector(initialValues);

                systemOfEquations.Jacobi(matrix, vector, tolerance, iterations, initialVal, lambda);
                String resultado = systemOfEquations.printTabla(systemOfEquations.getTabla());
                Log.d("ass", resultado);

                AlertDialog.Builder builder = new AlertDialog.Builder(JacobiMethod.this);
                builder.setMessage(resultado)
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
}
