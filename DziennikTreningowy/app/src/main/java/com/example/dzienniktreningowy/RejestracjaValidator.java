package com.example.dzienniktreningowy;


public class RejestracjaValidator extends ValidatorClass {
    String user;
    String haslo;
    String haslo2;
    String email;
    String tel ;

    public RejestracjaValidator(String user, String haslo,String haslo2, String email) {
        this.user = user;
        this.haslo = haslo;
        this.haslo2 = haslo2;
        this.email = email;

    }

    @Override
    public String validate() {
        String error = "";
        if (user.matches(""))
            error+="podaj login\n";
        if (email.matches("")) {error+="podaj adres e-mail\n";
        } else if (!isCorrectEmail(email))
            error+="podany adres e-mail jest niepoprawny\n";

        if (haslo.matches("")) {
            error += "podaj haslo\n";
        } else {
            if (!haslo.matches(haslo2)) {
                error+="powtórzone hasło jest nie poprawne\n";
            }
        }
        return error;
    }
}
