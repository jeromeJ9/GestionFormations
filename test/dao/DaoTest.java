package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Before;

public class DaoTest {
     @Before
    public void resetDb() throws SQLException {
        System.out.println("Reninitialiser la base");
        Connection connexion = DbAgrioteSP2.getConnection();
        String sql = "{ CALL reset_massy2016() }";
        CallableStatement ordre = connexion.prepareCall(sql);
        ordre.execute();
        ordre.close();
        connexion.close();
  } 
}
