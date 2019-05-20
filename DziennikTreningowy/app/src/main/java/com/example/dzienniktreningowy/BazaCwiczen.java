package com.example.dzienniktreningowy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dzienniktreningowy.tools.GUITools;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;


public class BazaCwiczen extends AppCompatActivity {
    public static Connection dbConnection;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_baza_cwiczen);
        final ListView prosta_lista =  findViewById(R.id.lv_prostalista);
        new Thread() {
            @Override
            public void run() {
                final ArrayList<PartiaMiesni> wynik = new ArrayList<>();
                PartiaMiesni p = new PartiaMiesni();
                p.setId(0);
                GUITools.toast("xd");
                p.setNazwa("Wszystkie");
                wynik.add(p);
                List<PartiaMiesni> partieMiesni = DbConnector.getPartieMiesni();
                wynik.addAll(partieMiesni);
                final ArrayList<String> lista = new ArrayList<>();
                for (PartiaMiesni partia: wynik) {
                    lista.add(partia.getNazwa());
                }
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter adapter_listy = GUITools.provideStandardListAdapter(getApplicationContext(), lista);
                        prosta_lista.setAdapter(adapter_listy);
                        prosta_lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                SharedPreferences sharedPreferences = getSharedPreferences("miesnie", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                //String s = elementy_listy.get(position);
                                int s = wynik.get(position).getId();
                                editor.putInt("parita", s );
                                editor.commit();
                                Intent startActivityCustomList = new Intent(BazaCwiczen.this,
                                        Cwiczenia_na_parie_miesni.class);
                                startActivity(startActivityCustomList);

                            }
                        });
                    }
                });





            }

        }.start();
    }



}
