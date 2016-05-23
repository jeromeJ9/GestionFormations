package services;

import java.util.List;
import modele.Formation;
import modele.Module;


public interface ServiceFormations {
    
    void donneFormationAvecModule()throws Exception;
    
    int donneNbEntite();
        
    Module donneModuleParId (int id);
    
    Formation donneFormationParId ( int id);
      
    int donneMaxIdFormation();
    
    int donneMaxIdModule();

    List<Module> donneModuleByFormation(int id);
    
    boolean isIntituleModuleExist(String intitule);
    
    
    //############## DAO Formation
    
    List<Formation> getAllFormation() throws Exception;
    
    int setNewFormation(String intitule,String description)throws Exception;
    
    //##############  DAO Module
    
    List<Module> getAllModule() throws Exception;
    
    List<Module> getModulesByFormation(Formation form)throws Exception;
    
    void setNewModule(String intitule,String description, int duree )throws Exception;
    
    
    //##############   DAO ModuleFormation
    
    void setModulesPourFormation(int id, List<Module> listeModules)throws Exception;
    
   
}
