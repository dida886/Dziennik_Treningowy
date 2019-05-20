package com.example.dzienniktreningowy;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.example.dzienniktreningowy.tools.GUITools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Cwiczenia_na_parie_miesni extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    public static Connection dbConnection;
    private final ArrayList<String> elementy_listy = new ArrayList<>();
    private final ArrayList<String> lista_linkow = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cwiczenia_na_parie_miesni);
        SharedPreferences sharedPreferences = getSharedPreferences("miesnie", MODE_PRIVATE);
        final int partia = sharedPreferences.getInt("parita", 0);
        //Toast.makeText(this, "Wybrana partia: "+partia, Toast.LENGTH_LONG).show();
        final ListView prosta_lista = (ListView) findViewById(R.id.lv_prostalista);
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    dbConnection = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/dziennik", "root", "1234a");
                    // toast("dziala");

                } catch (SQLException e) {
                    e.printStackTrace();

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {

                    e.printStackTrace();
                }

                if (dbConnection == null) {

                    return;
                }
                try {

                    Statement zapytanie = dbConnection.createStatement();
                    String sql_querry = "";
                    if (partia > 0) {
                        sql_querry = " WHERE partiaMiesni=" + partia;
                    }
                    ResultSet wynik = zapytanie.executeQuery("SELECT * FROM cwiczenie" + sql_querry);

                    while (wynik.next()) {
                        String s = wynik.getString("nazwa");
                        String l = wynik.getString("link");
                        elementy_listy.add(s);
                        lista_linkow.add(l);

                    }
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ArrayAdapter adapter_listy = GUITools.provideStandardListAdapter(getApplicationContext(), elementy_listy);
                            prosta_lista.setAdapter(adapter_listy);
                            prosta_lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                                    Intent i = new Intent(getApplicationContext(), Cwiczenie_activity.class);
//
//                                    startActivity(i);
                                    if(lista_linkow.get(position)!=null) GUITools.showYouTubeVideo(lista_linkow.get(position));
                                    else GUITools.toast("brak linku do filmu");
                                }
                            });
                            EditText szukaj = findViewById(R.id.szukaj);
                            szukaj.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {

                                }

                                @Override
                                public void afterTextChanged(Editable s) {
                                    //GUITools.toast(s.toString());
                                    ArrayAdapter adapter_listy = GUITools.provideStandardListAdapter(getApplicationContext(), filterElements(s.toString()));
                                    prosta_lista.setAdapter(adapter_listy);

                                }
                            });
                        }
                    });
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }.start();
    }

    private ArrayList<String> filterElements(String filter) {
        ArrayList<String> wynik = new ArrayList<>();
        for(String str : elementy_listy){
            if(str.toUpperCase().contains(filter.toUpperCase())){
                wynik.add(str);
            }
        }

        return wynik;
    }

    public void toast(final String text) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
            }
        });
    }

}