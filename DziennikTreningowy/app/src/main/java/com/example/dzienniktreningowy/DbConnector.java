package com.example.dzienniktreningowy;


import com.example.dzienniktreningowy.tools.GUITools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DbConnector {
    private final static String USER = "root";
    private final static String PASSWORD = "1234a";
    private final static String PROTOCOL = "jdbc:mysql";
    private final static String ADDRESS = "10.0.2.2";
    private final static String PORT = "3306";
    private final static String DB_NAME = "dziennik";
    private final static String DRIVER = "com.mysql.jdbc.Driver";


    private static Connection connect() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        Class.forName(DRIVER).newInstance();
        return DriverManager.getConnection(PROTOCOL + "://" + ADDRESS + ":" + PORT + "/" + DB_NAME +
                "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", USER, PASSWORD);
    }

    private static void disconnect(Connection connection) throws SQLException {
        connection.close();
    }

    public static List<Object[]> doSQLQuery(String sql) {
        try {
            Connection con = connect();
            Statement stat = con.createStatement();
            ResultSet result = stat.executeQuery(sql);
            int columnCount = result.getMetaData().getColumnCount();
            List<Object[]> resultList = new ArrayList<>();
            while (result.next()) {
                Object[] array = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    array[i] = result.getObject(i + 1);
                }
                resultList.add(array);
            }
            disconnect(con);
            return resultList;
        } catch (ClassNotFoundException e) {
            GUITools.toast(e.toString());
            e.printStackTrace();
        } catch (SQLException e) {
            GUITools.toast(e.toString());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            GUITools.toast(e.toString());
            e.printStackTrace();
        } catch (InstantiationException e) {
            GUITools.toast(e.toString());
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    public static void addToDatabase(String sql) {
        try {
            Connection con = connect();
            Statement stat = con.createStatement();
            stat.execute(sql);

            disconnect(con);

        } catch (ClassNotFoundException e) {
            GUITools.toast(e.toString());
            e.printStackTrace();
        } catch (SQLException e) {
            GUITools.toast(e.toString());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            GUITools.toast(e.toString());
            e.printStackTrace();
        } catch (InstantiationException e) {
            GUITools.toast(e.toString());
            e.printStackTrace();
        }

    }

    public static void deleteFrom(String sql) {
        try {
            Connection con = connect();
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);

            disconnect(con);

        } catch (ClassNotFoundException e) {
            GUITools.toast(e.toString());
            e.printStackTrace();
        } catch (SQLException e) {
            GUITools.toast(e.toString());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            GUITools.toast(e.toString());
            e.printStackTrace();
        } catch (InstantiationException e) {
            GUITools.toast(e.toString());
            e.printStackTrace();
        }

    }
    public static User getUserByLogin(String login) {
        List<Object[]> result = doSQLQuery("SELECT * FROM konto WHERE login='" + login + "'");
        for (Object[] array : result) {
            User user = new User();
            user.setId((Integer) array[0]);
            user.setLogin(array[1].toString());
            user.setPassword(array[2].toString());
            user.setEmail(array[3].toString());


            return user;
        }
        return null;
    }

    public static void addUser(String user, String email, String haslo) {

            addToDatabase(String.format("INSERT INTO konto (login, password, email) VALUES ('%s', '%s', '%s');", user, haslo, email));

    }
    public static List<PartiaMiesni> getPartieMiesni() {
        List<PartiaMiesni> wynik = new ArrayList<>();
        List<Object[]> result = doSQLQuery("SELECT * FROM partiamiesni");
        for (Object[] array : result) {
            PartiaMiesni p = new PartiaMiesni();
            p.setId((Integer) array[0]);
            p.setNazwa(array[1].toString());
            wynik.add(p);
        }
        return wynik;
    }
}