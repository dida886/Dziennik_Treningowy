package com.example.dzienniktreningowy;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.os.Handler;

import com.example.dzienniktreningowy.tools.GUITools;

import java.sql.Connection;
import java.util.List;



public class Rejestracja extends AppCompatActivity {
    public EditText login;
    public EditText mail;
    public EditText password1;
    public EditText password2;

    public static Connection dbConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rejestracja);
        login = findViewById(R.id.login);
        mail = findViewById(R.id.email);
        password1 = findViewById(R.id.password1);
        password2 = findViewById(R.id.password2);

    }

    public void utworz_konto(View view) {

        new Thread() {
            @Override
            public void run() {
                boolean ready = validateFields();
                final String user = login.getText().toString();
                final String email = mail.getText().toString();

                final String haslo = password1.getText().toString();
                if (ready) {
                    List<Object[]> resultLogin = DbConnector.doSQLQuery("SELECT * FROM konto WHERE login='" + user + "'");
                    List<Object[]> resultEmail = DbConnector.doSQLQuery("SELECT * FROM konto WHERE email='" + email + "'");
                    boolean notExistLogin = resultLogin.isEmpty();
                    boolean notExistMail = resultEmail.isEmpty();

                    if (!notExistLogin) GUITools.toast("podany login juz istnieje");
                    else if (!notExistMail) GUITools.toast("podany mail juz istnieje");
                    else {
                        //TODO dodawanie do bazy danych, zrobic, reszte wywalic

//                            GUITools.toast(user);
//                            GUITools.toast(haslo);
//                            GUITools.toast(email);
                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {

                                new Thread() {
                                    @Override
                                    public void run() {


                                        DbConnector.addUser(user, email, haslo);
                                        User u = DbConnector.getUserByLogin(user);


                                        GUITools.toast("zarejesrowano użytkownika o loginie: "+u.getLogin());

                                    }

                                }.start();



                            }
                        });
                        //Toast.makeText(this, "", Toast.LENGTH_SHORT).show(); else

//                            Toast.makeText(this, user, Toast.LENGTH_SHORT).show();
//                            Toast.makeText(this, haslo, Toast.LENGTH_SHORT).show();
//                            Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
//

                    }


                }
            }

        }.start();
    }




    private boolean validateFields() {
        ValidatorClass v = new RejestracjaValidator(login.getText().toString(),password1.getText().toString(),
                password2.getText().toString(),  mail.getText().toString());
        String errorString = v.validate();
        boolean correct = errorString.isEmpty();
        if(!correct){
            GUITools.toast(errorString);
        }
        return correct;
    }

    public void back(){

        onBackPressed();
    }

    public void onBackPressed(){

        super.onBackPressed();
    }
}

