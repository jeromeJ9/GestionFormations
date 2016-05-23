    package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Module;


public class ModuleFormationDao implements IModuleFormation{

    /**
     * cree l'association entre l'id d'une formation et l'ensemble des id des modules de la liste de modules données en parametre
     * @param id d'une formation
     * @param listeModules
     */
    @Override
    public void setModulesPourFormation(int id, List<Module> listeModules) throws SQLException {
        for(Module unModule : listeModules){
                String sql = "INSERT INTO module_formation ( id_module, id_formation) VALUES (?, '"+id+"')";
                Connection connection = DbAgrioteSP2.getConnection();
                PreparedStatement ordre = connection.prepareStatement(sql);
                ordre.setString(1, Integer.toString(unModule.getId()));
                ordre.executeUpdate();
        }
    }
          
    @Override
    public List<Module> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
