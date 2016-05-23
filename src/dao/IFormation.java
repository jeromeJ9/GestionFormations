package dao;

import modele.Formation;


public interface IFormation extends IDao<Formation>{
    
    public int setNewFormation(String intitule,String description) throws Exception;
    
   // public void setModulesPourFormation(int id, List<Module> listeModules);
    
}
