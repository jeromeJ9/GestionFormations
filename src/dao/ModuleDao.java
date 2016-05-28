package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modele.Formation;
import modele.Module;


public class ModuleDao implements IModule{
    
    @Override
    public List<Module> getModulesByFormation (Formation form) throws SQLException {
            List<Module> result = new ArrayList<>();
            Connection connection = DbAgrioteSP2.getConnection();
            String sql = "Select * from module m\n" +
                    "				INNER JOIN module_formation mf\n" +
                    "                           ON m.id_module = mf.id_module\n" +
                    "                           where mf.id_formation = '"+ form.getId()+"';";
            Statement ordre = connection.createStatement();
            ResultSet rs = ordre.executeQuery(sql);
            while (rs.next()) {
                Module module = new Module (rs.getInt("id_module"),rs.getString("intitule"),rs.getString("description"), rs.getInt("nb_jours"));
                result.add(module);
            }
            return result;
       
    }
    
    @Override
    public List<Module> getAll() throws SQLException {
            List<Module> result = new ArrayList<>();
            Connection connection = DbAgrioteSP2.getConnection();
            String sql = "SELECT * FROM module ";
            Statement ordre = connection.createStatement();
            ResultSet rs = ordre.executeQuery(sql);
            while (rs.next()) {
                Module module = new Module(rs.getInt("id_module"), rs.getString("intitule"),rs.getString("description"), rs.getInt("nb_jours"));
                result.add(module);
            }
            return result;
    }
    
    @Override
    public void setNewModule(String intitule,String description, int duree ) throws SQLException {
            String sql = "INSERT INTO module ( intitule, description, nb_jours) VALUES (?, ?, ?)";
            Connection connection = DbAgrioteSP2.getConnection();
            PreparedStatement ordre = connection.prepareStatement(sql);
            ordre.setString(1, intitule);
            ordre.setString(2, description);
            ordre.setInt(3, duree);
            ordre.executeUpdate();
    } 
}
