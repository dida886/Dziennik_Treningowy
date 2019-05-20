package com.example.dzienniktreningowy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.os.Handler;

import com.example.dzienniktreningowy.tools.GUITools;

import java.sql.Connection;


public class Menu extends AppCompatActivity {

    public static Connection dbConnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);
        GUITools.setAppContext(getApplicationContext());
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        String login = sharedPreferences.getString("login", "");
        pobierzZalogowanegoUsera(login);
    }

    private void pobierzZalogowanegoUsera(final String login) {
        new Thread(){

            @Override
            public void run() {
                MainMenu.zalogowany = DbConnector.getUserByLogin(login);
            }
        }.start();
    }
    public void toast(final String text){
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onBackPressed() {
        //do nothing
        finishAffinity();
    }

    public void rejestracja(View view) {

        Intent intent = new Intent(this, Rejestracja.class);
        startActivity(intent);
    }
    public void zaloguj(View view) {

        Intent intent = new Intent(this, Zaloguj.class);
        startActivity(intent);
    }

    public void bazaCw(View view) {
        Intent intent = new Intent(this, BazaCwiczen.class);
        startActivity(intent);
    }
}
