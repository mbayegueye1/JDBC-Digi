import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    private static final String DB_URL="jdbc:mysql:bhhgxabse8hpvquadcow-mysql.services.clever-cloud.com:3306/bhhgxabse8hpvquadcow";
    private static final String DB_USER="uywiab60iqpjfowh";
    private static final String DB_PWD= "GaOkn2P5rYioMIa0DVi4";
    public static void main(String[] args) throws SQLException {
        Connection cnx =DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
        System.out.println(cnx);
        System.out.println("Hello world!");
        cnx.close();
    }
}
