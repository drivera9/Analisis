package com.numericos.proyectofinal.views.single_variable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.views.util.ListViewAdapter;

import java.net.SecureCacheResponse;

/**
 * Created by Juanda on 04/11/2014.
 */
public class Fragment_Single_Variable extends Activity {

    View rootView;
    ListViewAdapter adapter;

    String[] titulo = new String[]{


            "Incremental Search",
            "Bisection",
            "False Position",
            "Fixed Point",
            "Newton",
            "Secant",
            "Multiple roots"
    };

    int[] imagenes = {
            R.drawable.single_variable,
            R.drawable.single_variable,
            R.drawable.single_variable,
            R.drawable.single_variable,
            R.drawable.single_variable,
            R.drawable.single_variable,
            R.drawable.single_variable
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_single_variable);
        final Bundle parametros = this.getIntent().getExtras();

        final String Xinferior = parametros.getString("Xi");
        final String Xsuperior = parametros.getString("Xs");
        final String Delta = parametros.getString("Delta");
        final String Tolerance = parametros.getString("Tolerance");
        final String Iterations = parametros.getString("Iterations");
        final String Fx = parametros.getString("Fx");
        final String Gx = parametros.getString("Gx");
        final String FxP = parametros.getString("FxP");
        final String FxPP = parametros.getString("FxPP");




        final ListView lista = (ListView) findViewById(R.id.listView5);
        adapter = new ListViewAdapter(getApplicationContext(), titulo, imagenes);
        lista.setAdapter(adapter);
        final Bundle parametros2 = new Bundle();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Selected " + position, Toast.LENGTH_SHORT).show();

                Intent ii = null;
                switch (position) {
                    case 0:
                        parametros2.putString("Xi", Xinferior);
                        parametros2.putString("Delta", Delta);
                        parametros2.putString("Iterations", Iterations);
                        parametros2.putString("Fx", Fx);
                        ii = new Intent(getApplicationContext(), IncrementalSearchMethod.class);
                        ii.putExtras(parametros2);
                        startActivity(ii);
                        break;
                    case 1:

                        parametros2.putString("Xi", Xinferior);
                        parametros2.putString("Xs", Xsuperior);
                        parametros2.putString("Tolerance", Tolerance);
                        parametros2.putString("Iterations", Iterations);
                        parametros2.putString("Fx", Fx);
                        ii = new Intent(getApplicationContext(), BisectionPrueba.class);
                        ii.putExtras(parametros2);
                        startActivity(ii);
                        break;
                    case 2:

                        parametros2.putString("Xi", Xinferior);
                        parametros2.putString("Xs", Xsuperior);
                        parametros2.putString("Tolerance", Tolerance);
                        parametros2.putString("Iterations", Iterations);
                        parametros2.putString("Fx", Fx);
                        ii = new Intent(getApplicationContext(), FalsePositionMethod.class);
                        ii.putExtras(parametros2);
                        startActivity(ii);
                        break;
                    case 3:
                        parametros2.putString("Xi", Xinferior);
                        parametros2.putString("Tolerance", Tolerance);
                        parametros2.putString("Iterations", Iterations);
                        parametros2.putString("Fx", Fx);
                        parametros2.putString("Gx", Gx);
                        ii = new Intent(getApplicationContext(), FixedPointMethod.class);
                        ii.putExtras(parametros2);
                        startActivity(ii);
                        break;
                    case 4:
                        parametros2.putString("Xi", Xinferior);
                        parametros2.putString("Tolerance", Tolerance);
                        parametros2.putString("Iterations", Iterations);
                        parametros2.putString("Fx", Fx);
                        parametros2.putString("FxP", FxP);
                        ii = new Intent(getApplicationContext(), NewtonMethod.class);
                        ii.putExtras(parametros2);
                        startActivity(ii);
                        break;
                    case 5:

                        parametros2.putString("Xi", Xinferior);
                        parametros2.putString("Xs", Xsuperior);
                        parametros2.putString("Tolerance", Tolerance);
                        parametros2.putString("Iterations", Iterations);
                        parametros2.putString("Fx", Fx);
                        ii = new Intent(getApplicationContext(), SecantMethod.class);
                        ii.putExtras(parametros2);
                        startActivity(ii);
                        break;
                    case 6:
                        parametros2.putString("Xi", Xinferior);
                        parametros2.putString("Tolerance", Tolerance);
                        parametros2.putString("Iterations", Iterations);
                        parametros2.putString("Fx", Fx);
                        parametros2.putString("FxP", FxP);
                        parametros2.putString("FxPP", FxPP);
                        ii = new Intent(getApplicationContext(), MultipleRootsMethod.class);
                        ii.putExtras(parametros2);
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
