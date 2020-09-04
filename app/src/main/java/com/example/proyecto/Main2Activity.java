package com.example.proyecto;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView listView;
    final static String twitterScreenName = "BBCNews";
    //final static String TAG = "Main2Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView) findViewById(R.id.listViewNoticias);

        //CardArrayAdapter adapter;
       // adapter = new CardArrayAdapter(this, datosArrayList);

       // lv_noticias.setAdapter(adapter); //mostraria los elementos que le mandamos

        new TwitterAsyncTask().execute(twitterScreenName,listView,this);
    }

   /* private void CargarDatos()
    {
        ArrayList<Noticia> datosArrayList;
        CardArrayAdapter adapter;
        datosArrayList = obtenerDatos(); //a futuro la dirección de donde vienen los datos va a cambiar
        //y sería de donde trayeramos datos de twitter

        adapter = new FutbolAdapter(this, R.layout.layout_list_view, datosArrayList);
        lv_noticias.setAdapter(adapter); //mostraria los elementos que le mandamos
    }*/
}
