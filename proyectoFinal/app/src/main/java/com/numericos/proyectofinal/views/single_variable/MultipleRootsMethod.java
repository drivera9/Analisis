package com.numericos.proyectofinal.views.single_variable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.Tabla;
import com.numericos.proyectofinal.logic.MultipleRoots;
import com.numericos.proyectofinal.views.util.CustomKeyboard;


public class MultipleRootsMethod extends Activity{
    private MultipleRoots multipleRoots;
    private Button execute_button;
    private EditText x0_editText,x1_editText, tolerance_editText, iterations_editText, function_editText,function2_editText,function3_editText, result_editText;
    private String resultado;
    private CustomKeyboard mCustomKeyboard;

    public MultipleRootsMethod(){    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiple_roots_method);

        mCustomKeyboard= new CustomKeyboard(this, R.id.keyboardview, R.xml.hexkbd );
        mCustomKeyboard.registerEditText(R.id.function_editText);
        mCustomKeyboard.registerEditText(R.id.x0_editText);
        mCustomKeyboard.registerEditText(R.id.tolerance_editText);
        //mCustomKeyboard.registerEditText(R.id.iteraciones_editText);
        //mCustomKeyboard.registerEditText(R.id.function2_editText);
        mCustomKeyboard.registerEditText(R.id.function3_editText);

        Bundle parametros = this.getIntent().getExtras();
        final String ximultiple = parametros.getString("Xi");
        final String tolerance = parametros.getString("Tolerance");
        final String iterations = parametros.getString("Iterations");
        final String functionF = parametros.getString("Fx");
        final String functionFP = parametros.getString("FxP");
        final String functionFPP = parametros.getString("FxPP");

        x0_editText = (EditText) findViewById(R.id.x0_editText);
        //x1_editText = (EditText) findViewById(R.id.x1_editText);
        tolerance_editText = (EditText) findViewById(R.id.tolerance_editText);
        iterations_editText = (EditText) findViewById(R.id.iterations_editText);
        function_editText = (EditText) findViewById(R.id.function_editText);
        function2_editText = (EditText) findViewById(R.id.function2_editText);
        function3_editText = (EditText) findViewById(R.id.function3_editText);
        result_editText = (EditText)findViewById(R.id.result_editText);

        x0_editText.setText(ximultiple);
        tolerance_editText.setText(tolerance);
        iterations_editText.setText(iterations);
        function_editText.setText(functionF);
        function2_editText.setText(functionFP);
        function3_editText.setText(functionFPP);

        multipleRoots = new MultipleRoots();

        execute_button = (Button) findViewById(R.id.execute_button);
        execute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                double x0 = Double.parseDouble(x0_editText.getText().toString());
                //double x1 = Double.parseDouble(x1_editText.getText().toString());
                double tolerance = Double.parseDouble(tolerance_editText.getText().toString());
                double iterations = Double.parseDouble(iterations_editText.getText().toString());
                String funct = function_editText.getText().toString();
                String funct2 = function2_editText.getText().toString();
                String funct3 = function3_editText.getText().toString();


                multipleRoots.setX0(x0);
                //fixedPoint.setX0(x1);
                multipleRoots.setTolerance(tolerance);
                multipleRoots.setIterations(iterations);
                multipleRoots.setFx(funct);
                multipleRoots.setDFx(funct2);
                multipleRoots.setddfx(funct3);



                /*Double X0=Double.parseDouble(ximultiple);
                Double TOLERANCE=Double.parseDouble(tolerance);
                Double ITERATIONS=Double.parseDouble(iterations);

                multipleRoots.setX0(X0);
                multipleRoots.setTolerance(TOLERANCE);
                multipleRoots.setIterations(ITERATIONS);
                multipleRoots.setFx(functionF);
                multipleRoots.setDFx(functionFP);
                multipleRoots.setddfx(functionFPP);
*/

                resultado = multipleRoots.multipleRootsMethod(x0,tolerance,iterations);


                //function_editText.setTextColor(Color.RED);
                String displayString = "The result is: " + resultado;
                result_editText = (EditText) findViewById(R.id.result_editText);
                result_editText.setText(resultado);

                //result_editText.setText(displayString, TextView.BufferType.EDITABLE);

                Toast msg = Toast.makeText(getBaseContext(), displayString,
                        Toast.LENGTH_LONG);
                msg.show();

                Intent tabla = new Intent(getApplicationContext(),Tabla.class);
                tabla.putExtra("Resultado",multipleRoots.getArrayResultado());
                tabla.putExtra("CantColumnas", 7);
                startActivity(tabla);
            }
        });

    }

    public void helpMultiple(View v){
        Intent help = new Intent(getApplicationContext(),HelpMultipleRoots.class);
        startActivity(help);
    }
    @Override public void onBackPressed() {
        // NOTE Trap the back key: when the CustomKeyboard is still visible hide it, only when it is invisible, finish activity
        if( mCustomKeyboard.isCustomKeyboardVisible() ) mCustomKeyboard.hideCustomKeyboard(); else this.finish();
    }
}
