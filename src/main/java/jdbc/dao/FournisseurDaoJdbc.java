
import jdbc.TestSelect;
import jdbc.dao.FournisseurDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javax.swing.text.html.parser.DTDConstants.ID;

public class FournisseurDaoJdbc implements FournisseurDao {
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;


    static {
        System.out.println("Bloc static");
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        DB_URL = bundle.getString("database.url");
        DB_USER = bundle.getString("database.user");
        DB_PWD = bundle.getString("database.pwd");
    }
    public static final String EXTRAIRE_QUERY = "SELECT ID ,NOM FROM FOURNISSEUR";
    List<TestSelect> lesFournisseursTrouves = new ArrayList<>();

    @Override

    public List<TestSelect> extraire() throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = cnx.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT ID, NOM FROM FOURNISSEUR ");
            while (rs.next()) {
                Integer id = rs.getInt("ID");
                String nomFournisseur = rs.getString("NOM");


                TestSelect testSelect = new TestSelect(id, nomFournisseur);
                lesFournisseursTrouves.add(testSelect);
            }
        }
        return lesFournisseursTrouves;
    }
    @Override
    public void insert(TestSelect testSelect) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = cnx.createStatement()) {
            st.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES ('La Maison de la Peinture')");

        }
    }
    @Override
    public boolean delete(TestSelect testSelect) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = cnx.createStatement()) {
            int rs = st.executeUpdate("DELETE FROM FOURNISSEUR  where nom ='La Maison des Peintures' ");
            return rs >0;
        }

    }



    @Override
    public int update(String ancienNom, String nouveauNom) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = cnx.createStatement()) {
            int rs = st.executeUpdate("UPDATE FOURNISSEUR SET nom ='La Maison des Peintures' where nom = 'La Maison de la Peinture' ");
            return rs;
        }
    }

}