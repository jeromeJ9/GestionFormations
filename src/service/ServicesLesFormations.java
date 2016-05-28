
package service;

import dao.FormationDao;
import dao.IFormation;
import dao.IModule;
import dao.IModuleFormation;
import dao.ModuleDao;
import dao.ModuleFormationDao;
import java.util.ArrayList;
import java.util.List;
import modele.Formation;
import modele.Module;


public class ServicesLesFormations implements ServiceFormations {
   
    //############### Instance DAO
    IFormation formDao = new FormationDao();
    IModule modDao = new ModuleDao();
    IModuleFormation modFormDao = new ModuleFormationDao();
    
    
    public ServicesLesFormations() {
    }
    
    @Override
    public List<Formation> getFormationsAvecModules() throws Exception{
        List<Formation> lesFormations = new ArrayList<>();
        lesFormations = formDao.getAll();
        for (Formation uneFormation : lesFormations){
            uneFormation.setModule(modDao.getModulesByFormation(uneFormation));
            int nbJours = 0;
            for (Module unMod : uneFormation.getModule()){
                nbJours += unMod.getNb_jour();
            }
            uneFormation.setNbJours(nbJours);
        }
        return lesFormations;
    }
    @Override
    public int donneMaxIdFormation(List<Formation> laListe) {
        int index = 0;
        for (Formation uneFormation: laListe){
            if ( uneFormation.getId() > index)
                index = uneFormation.getId();
        }
        return index;
    }
    @Override
    public List<Module> donneModuleByFormation(int id, List<Formation> listeFormations) {
        for (Formation uneFormation : listeFormations){
            if (uneFormation.getId() == id)
                return uneFormation.getModule();
        }
        return null;
    }
    @Override
    public List<Module> getListeModules() throws Exception {
        return modDao.getAll();
    }
    /**
     * sauve un module dans la base de donnée
     * @param intitule
     * @param description
     * @param duree
     */
    @Override
    public void setNewModule(String intitule, String description, int duree) throws Exception {
        modDao.setNewModule(intitule, description, duree);
    }
    /**
     * retourne une liste de Module par l'identifiant de la formation
     * @param id qui correspond a l'id de la formation
     * @return une List de Module
     */
    
    
    @Override
    public boolean isIntituleModuleExist(String intitule) throws Exception {
        List<Module> listeModules = modDao.getAll();
        for (Module unModule : listeModules){
            if (unModule.getIntitule().equals(intitule.trim()))
                return true;
        }
        return false;
    }
    /**
     * retourne un entier qui correspont a l'id max d'un module dans la base de donnée
     * @return un entier
     */
    @Override
    public int donneMaxIdModule() throws Exception {
        List<Module> listeModules = modDao.getAll();
        int index = 0;
        for (Module unModule: listeModules){
            if ( unModule.getId() > index)
                index = unModule.getId();
        }
        return index;    }
    
    /**
     * sauve une formatin dans la base
     * @param intitule de la formation a enregistré
     * @param description de la formation a enregistré
     * @return l'id generé dans la base pour cette formation
     */
    @Override
    public int setNewFormation(String intitule, String description) throws Exception {
        return formDao.setNewFormation(intitule, description);
    }
    /**
     * sauve dans la base de donnée une liste de module dans la formation designée par son id
     * @param id de la formation dont on veut saisir ses modules
     * @param listeModules 
     */
    @Override
    public void setModulesPourFormation(int id, List<Module> listeModules) throws Exception {
        modFormDao.setModulesPourFormation(id, listeModules);
    }
    /**
     * retourne un Module en rentrant en parametre son Id
     * @param id d'un module
     * @return un objet Module
     */
    @Override
    public Module donneModuleParId(int id) throws Exception {
        List<Module> listeModules = modDao.getAll();
        for (Module unModule : listeModules){
            if (unModule.getId() == id)
                return unModule;
        }
        return null;    
    }
    
    
}
