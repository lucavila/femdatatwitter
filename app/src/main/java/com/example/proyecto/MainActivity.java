package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_equipo1;
    Button btn_equipo2;
    Button btn_equipo3;
    Button btn_equipo4;

    ArrayList<String> vecEquipos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LlenarArray();
        ObtenerReferencias();
        SetearListener();
    }

    private void ObtenerReferencias()
    {
        btn_equipo1 = (Button) findViewById(R.id.btn_equipo1);
        btn_equipo2 = (Button) findViewById(R.id.btn_equipo2);
        btn_equipo3 = (Button) findViewById(R.id.btn_equipo3);
        btn_equipo4 = (Button) findViewById(R.id.btn_equipo4);
    }

    private void SetearListener()
    {
        btn_equipo1.setOnClickListener(btn_equipo1_Click);
        btn_equipo2.setOnClickListener(btn_equipo2_Click);
        btn_equipo3.setOnClickListener(btn_equipo3_Click);
        btn_equipo4.setOnClickListener(btn_equipo4_Click);
    }

    View.OnClickListener btn_equipo1_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                EquipoSeleccionado();
            //TOmar equipo seleccionado
        }
    };

    View.OnClickListener btn_equipo2_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EquipoSeleccionado();
            //TOmar equipo seleccionado
        }
    };

    View.OnClickListener btn_equipo3_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EquipoSeleccionado();
            //TOmar equipo seleccionado
        }
    };

    View.OnClickListener btn_equipo4_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EquipoSeleccionado();
            //TOmar equipo seleccionado
        }
    };

    private void EquipoSeleccionado()
    {
        //Obtengo el equipo y paso a menu noticias

        //COdigo de equipo

        Intent miIntent = new Intent(MainActivity.this, Main2Activity.class );
        startActivity(miIntent);
    }

    private void LlenarArray()
    {
        vecEquipos.add("Boca");
        vecEquipos.add("River");
        vecEquipos.add("Racing");
        vecEquipos.add("Independiente");
        System.out.println(vecEquipos);
    }

}
