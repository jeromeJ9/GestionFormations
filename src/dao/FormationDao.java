package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modele.Formation;

public class FormationDao implements IFormation{
    
    
   
    @Override
    public List<Formation> getAll() throws SQLException {
            List<Formation> result = new ArrayList<>();
            Connection connection = DbAgrioteSP2.getConnection();
            String sql = "SELECT * FROM formation ";
            Statement ordre = connection.createStatement();
            ResultSet rs = ordre.executeQuery(sql);
            while (rs.next()) {
                Formation formation = new Formation(rs.getInt("id_formation"),rs.getString("intitule"), rs.getString("description"));
                result.add(formation);
            }
            return result;
       
    }
    
    @Override
    public  int setNewFormation(String intitule,String description) throws SQLException{
            int generatedId = 0;
            String sql = "INSERT INTO formation ( intitule, description) VALUES (?, ?)";
            Connection connection = DbAgrioteSP2.getConnection();
            PreparedStatement ordre = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ordre.setString(1, intitule);
            ordre.setString(2, description);
            ordre.executeUpdate();
            ResultSet rs = ordre.getGeneratedKeys();
            if (rs != null && rs.first()) {
                generatedId = rs.getInt(1);
            }
            return generatedId;
    }
   
    
}
