package com.example.dzienniktreningowy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.dzienniktreningowy.tools.GUITools;

import java.sql.Connection;


public class Zaloguj extends AppCompatActivity {
    public EditText l;
    public EditText password;
    public static Connection dbConnection;

    Menu m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_zaloguj);
        l = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        if(MainMenu.zalogowany != null){
            startActivity(new Intent(getApplicationContext(), MainMenu.class));
        }

    }


    public void zaloguj(View view) {
        new Thread() {
            @Override
            public void run() {
                String alert = "Podane login lub hasło są niepoprawne";
                String login = l.getText().toString();
                boolean log_in = false;

                User u = DbConnector.getUserByLogin(login);
                if (u!=null) {

                    if (password.getText().toString().equals(u.getPassword())) {

                        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("login", login);
                        editor.putInt("id", u.getId());

                        editor.commit();Intent i;

                        i = new Intent(getApplicationContext(), MainMenu.class);


                        startActivity(i);
                    } else
                        GUITools.toast(alert);

                } else GUITools.toast(alert);

            }

        }.start();
    }
}



