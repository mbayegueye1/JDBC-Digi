package jdbc;

import jdbc.entities.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestSelect {
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static{
        ResourceBundle bundle = ResourceBundle.getBundle("dataBase");
        DB_URL= bundle.getString("database_url");
        DB_USER= bundle.getString("database_user");
        DB_PWD= bundle.getString("database_password");
    }

    public static void main(String[] args) {
        System.out.println("Connexion à la base");
        List<Fournisseur> fournisseurs = new ArrayList<>();
        try( Connection cnx = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery("SELECT ID, NOM FROM FOURNISSEUR")) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nom = rs.getString("NOM");
                Fournisseur fournisseur = new Fournisseur(id, nom);
                fournisseurs.add(fournisseur);
            }
        }
        catch(SQLException e) {
            System.out.println("voici une erreur :" + e.getMessage());
        }

        for(Fournisseur item : fournisseurs){
            System.out.println(item);
        }



    }


}


