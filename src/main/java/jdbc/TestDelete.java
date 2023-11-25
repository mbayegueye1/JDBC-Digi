package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {

    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        System.out.println("Bloc static pour recup file .properties");
        ResourceBundle bundle = ResourceBundle.getBundle("dataBase");

        DB_URL = bundle.getString("database_url");
        DB_USER = bundle.getString("database_user");
        DB_PWD = bundle.getString("database_password");
    }
    public static void main(String[] args)  {
        System.out.println("Definition du bloc instance");
        try (Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
             Statement st = connection.createStatement()){

            int nbInser= st.executeUpdate("DELETE FROM FOURNISSEUR where nom = 'La Maison des Peintures' ");
            System.out.println("nb elements insert = " + nbInser);

        }
        catch (SQLException e){
            System.out.println("le message d'exception = "+ e.getMessage());

        }
    }



}
