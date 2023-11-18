package fr.tp1.connexion;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.ResourceBundle;

public class TestInsertion {
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

    {
        System.out.println("Fin bloc instance");
    }

    public static void main(String[] args) {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = cnx.createStatement()) {

            int nb = st.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES ('La Maison de la Peinture')");
            System.out.println("Nombre d'éléments modifiés: " + nb);

        } catch (SQLException e) {
            System.out.println("Attention: " + e.getMessage());
            e.printStackTrace();
        }
    }
}



