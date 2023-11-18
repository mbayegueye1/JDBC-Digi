package fr.tp1.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class TestConnexionJdbc {
    private static final String DB_URL;
    private static final  String DB_USER;
    private static final  String DB_PWD;
    static{
        System.out.println("Bloc static");
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        DB_URL = bundle.getString("database.url") ;
        DB_USER = bundle.getString("database.user")  ;
        DB_PWD = bundle.getString("database.pwd");
    }

    {
        System.out.println("fin bloc instance");

    }





    public static void main(String[] args) {



     try (Connection cnx = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD)){
        System.out.println(cnx);
    }
    catch(SQLException e ){
        System.out.println("Attention:" + e.getMessage());
    }

    System.out.println("Fin du programme");

    }


}
