package service;

import java.util.List;
import modele.Formation;
import modele.Module;


public interface ServiceFormations {
    
    
    List<Formation> getFormationsAvecModules() throws Exception; 
    
    List<Module> getListeModules() throws Exception;
    
    Module donneModuleParId (int id)throws Exception;
          
    int donneMaxIdFormation(List<Formation> listeFormation);  
    
    int donneMaxIdModule()throws Exception;

    List<Module> donneModuleByFormation(int id, List<Formation> listeFormations); 
    
    boolean isIntituleModuleExist(String intitule) throws Exception;
    
    int setNewFormation(String intitule,String description)throws Exception;
    
    void setNewModule(String intitule,String description, int duree )throws Exception;
    
    void setModulesPourFormation(int id, List<Module> listeModules)throws Exception;
    
   
}
