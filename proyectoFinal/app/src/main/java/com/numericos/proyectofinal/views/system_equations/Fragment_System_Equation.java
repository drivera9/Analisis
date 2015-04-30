package com.numericos.proyectofinal.views.system_equations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.views.single_variable.IncrementalSearchMethod;
import com.numericos.proyectofinal.views.util.ListViewAdapter;

/**
 * Created by Juanda on 04/11/2014.
 */
public class Fragment_System_Equation extends Activity {

    ListViewAdapter adapter;

    String[] titulo = new String[]{
            "Elimination Gaussiana Simple",
            "E. G. Pivoteo Parcial",
            "E. G. Pivoteo Total",
            "E. G. Privoteo Escalonado",
            "Jacobi",
            "Seidel"
    };

    String[] subtitulo = new String[]{
            "",
            "",
            "",
            "",
            "with tolerance",
            "with tolerance"
    };

    int[] imagenes = {
            R.drawable.multiple_variables,
            R.drawable.multiple_variables,
            R.drawable.multiple_variables,
            R.drawable.multiple_variables,
            R.drawable.multiple_variables,
            R.drawable.multiple_variables
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_system_equation);

        final Bundle parametros = this.getIntent().getExtras();

        final String MatrizA = parametros.getString("matrizA");
        final String VectorB = parametros.getString("vectorB");
        final String Tolerancia = parametros.getString("tolerancia");
        final String Iteraciones = parametros.getString("iteraciones");
        final String ValoresIniciales = parametros.getString("valoresIniciales");
        final String Lambda = parametros.getString("lambda");


        final ListView lista = (ListView) findViewById(R.id.listView1);
        adapter = new ListViewAdapter(getApplicationContext(), titulo, imagenes, subtitulo);
        lista.setAdapter(adapter);
        final Bundle parametros2 = new Bundle();
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "presiono " + position, Toast.LENGTH_SHORT).show();

                Intent ii = null;
                switch (position) {
                    case 0:
                        parametros2.putString("MatrizA", MatrizA);
                        parametros2.putString("VectorB", VectorB);
                        parametros2.putString("Iteraciones", Iteraciones);
                        parametros2.putString("Tolerancia", Tolerancia);
                        parametros2.putString("ValoresIniciales", ValoresIniciales);
                        parametros2.putString("Lambda", Lambda);
                        ii = new Intent(getApplicationContext(), SimpleGaussianMethod.class);
                        ii.putExtras(parametros2);
                        startActivity(ii);
                        break;
                    case 1:
                        ii = new Intent(getApplicationContext(), PivoteoParcialMethod.class);
                        startActivity(ii);
                        break;
                    case 2:
                        ii = new Intent(getApplicationContext(), PivoteoTotalMethod.class);
                        startActivity(ii);
                        break;
                    case 3:
                        ii = new Intent(getApplicationContext(), PivoteoEscalonadoMethod.class);
                        startActivity(ii);
                        break;
                    case 4:
                        ii = new Intent(getApplicationContext(), JacobiMethod.class);
                        startActivity(ii);
                        break;
                    case 5:
                        ii = new Intent(getApplicationContext(), SeidelMethod.class);
                        startActivity(ii);
                        break;
                }

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
