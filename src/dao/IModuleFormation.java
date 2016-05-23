package dao;

import java.util.List;
import modele.Module;


public interface IModuleFormation extends IDao<Module>{
    
    void setModulesPourFormation(int id, List<Module> listeModules) throws Exception;
    
}
