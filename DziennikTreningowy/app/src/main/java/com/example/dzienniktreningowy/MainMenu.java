package com.example.dzienniktreningowy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.example.dzienniktreningowy.tools.GUITools;

public class MainMenu extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    int id;
    String login;

    public static User zalogowany;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mainmenu);
        String nazwa = "";
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        login = sharedPreferences.getString("login", "");
        id = sharedPreferences.getInt("id", 0);


        GUITools.toast("zalogowano: "+id+" "+login);
    }


    public void bazaCw(View view) {
        Intent i = new Intent(this, BazaCwiczen.class );
        startActivity(i);
        GUITools.toast("baza");
    }




    public void plany(View view) {

       // Intent i = new Intent(this, TrainingPlans.class );
        // startActivity(i);

        GUITools.toast("plany");
    }



    public void wiadomosci(View view) {
       GUITools.toast("wiadomości");
        }














    @Override
    public void onBackPressed() {
        //do nothing
    }

    public void wyloguj(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Intent i = new Intent(this, Menu.class);
        startActivity(i);
        GUITools.toast("wylogowano");
        // this.onBackPressed();
    }
}