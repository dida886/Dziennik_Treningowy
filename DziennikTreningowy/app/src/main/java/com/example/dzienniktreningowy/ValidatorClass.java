package com.example.dzienniktreningowy;


public abstract class ValidatorClass {

    protected boolean isCorrectEmail(String mail){
        boolean correct = true;
        int first = (int) mail.charAt(0);
        if((first<48)||((first>57)&&(first<65))||(first>122)) {correct=false;} else {
            String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
            java.util.regex.Matcher m = p.matcher(mail);
            correct = m.matches();

        }
        return correct;
    }
    public abstract String validate();
}
