package com.numericos.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.GridView;
import com.numericos.proyectofinal.logic.Bisection;

import java.util.ArrayList;


public class Tabla extends Activity {
    private ArrayList<String> ArrayIteraciones = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_tabla);
        final Bundle parametros = this.getIntent().getExtras();

        //Obteniendo la instancia del Intent
        Intent intent = getIntent();
        //Extrayendo el extra de tipo cadena
        String[] contenido = intent.getStringArrayExtra("Resultado");
        int cantColumnas = intent.getIntExtra("CantColumnas", 2);
        //String[] contenido;
        //contenido = new String[]{"Texto", "Texto2", "Texto3","Texto4","Texto5","Texto6","Texto7","Texto8"};

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, contenido);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int width = metrics.widthPixels;
        int height = metrics.heightPixels;


        GridView gv = (GridView) findViewById(R.id.gridView);

        gv.setMinimumWidth(gv.getWidth()/cantColumnas);


        gv.setNumColumns(cantColumnas);
        gv.setVisibility(View.VISIBLE);
        gv.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabla, menu);
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
