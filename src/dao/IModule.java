package dao;

import java.util.List;
import modele.Formation;
import modele.Module;


public interface IModule extends IDao<Module>{
    
     public List<Module> getModulesByFormation (Formation form) throws Exception;
     
     public void setNewModule(String intitule,String description, int duree ) throws Exception;
    
}
