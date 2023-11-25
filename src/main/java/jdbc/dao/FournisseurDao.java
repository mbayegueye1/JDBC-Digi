package jdbc.dao;

import jdbc.TestSelect;
import jdbc.entities.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface FournisseurDao {
    List<TestSelect> extraire() throws SQLException;
    void insert(TestSelect testSelect) throws SQLException;
    int update(String ancienNom, String nouveauNom) throws SQLException;
    boolean delete(TestSelect testSelect) throws SQLException;


}
