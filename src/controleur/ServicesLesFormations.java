
package controleur;

import dao.FormationDao;
import dao.IFormation;
import dao.IModule;
import dao.IModuleFormation;
import dao.ModuleDao;
import dao.ModuleFormationDao;
import java.util.List;
import modele.Formation;
import modele.Module;
import services.ServiceFormations;


public class ServicesLesFormations implements ServiceFormations {
    private List<Formation> listeFormations;
    private List<Module> listeModules;
    
    //############### Instance Modele
    Formation formation = new Formation();
    Module module = new Module();
    
    //############### Instance DAO
    IFormation formDao = new FormationDao();
    IModule modDao = new ModuleDao();
    IModuleFormation modFormDao = new ModuleFormationDao();
    
    
    public ServicesLesFormations() throws Exception {
        rempliListes();
    }
    
    
    public List<Module> getListeModules() {
        return listeModules;
    }
    public List<Formation> getListeFormations() {
        return listeFormations;
    }

    public void rempliListes() throws Exception{
        listeFormations = getAllFormation();
        donneFormationAvecModule();
        listeModules = getAllModule();
    }
    
    /**
     *
     * @return
     */
    @Override
    public int donneNbEntite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    /**
     * retourne un entier qui correspont a l'id max d'une formation dans la base de donnée
     * @return un entier
     */
    @Override
    public int donneMaxIdFormation() {
        int index = 0;
        for (Formation uneFormation: listeFormations){
            if ( uneFormation.getId() > index)
                index = uneFormation.getId();
        }
        return index;
    }

    /**
     * Rempli dans la liste des formations de la class les modules associés
     */
    @Override
    public void donneFormationAvecModule() throws Exception {
        for ( Formation uneFormation : listeFormations){
            uneFormation.setModule(getModulesByFormation(uneFormation));
        }
    }

    /**
     * retourne une liste de Module par l'identifiant de la formation
     * @param id qui correspond a l'id de la formation
     * @return une List de Module
     */
    @Override
    public List<Module> donneModuleByFormation(int id) {
        for (Formation uneFormation : listeFormations){
            if (uneFormation.getId() == id)
                return uneFormation.getModule();
        }
        return null;
    }
    
    @Override
    public boolean isIntituleModuleExist(String intitule) {
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
    public int donneMaxIdModule() {
        int index = 0;
        for (Module unModule: listeModules){
            if ( unModule.getId() > index)
                index = unModule.getId();
        }
        return index;    }

    /**
     * retourne un Module en rentrant en parametre son Id
     * @param id d'un module
     * @return un objet Module
     */
    @Override
    public Module donneModuleParId(int id) {
        for (Module unModule : listeModules){
            if (unModule.getId() == id)
                return unModule;
        }
        return null;    
    }
    
    @Override
    public Formation donneFormationParId(int id) {
        for (Formation uneForm : listeFormations){
            if (uneForm.getId() == id)
                return uneForm;
        }
        return null;     }
    

    /**
     * retourne la liste de toute les formations
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public List<Formation> getAllFormation() throws Exception{
        return formDao.getAll();    
    }

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
     * recupere tous les modules de la base
     * @return une liste de Module
     */
    @Override
    public List<Module> getAllModule() throws Exception {
        return modDao.getAll();
    }

    /**
     * retourne la liste des modules d'une formation donnée
     * @param form Objet Formation
     * @return List de Module
     */
    @Override
    public List<Module> getModulesByFormation(Formation form) throws Exception {
        return modDao.getModulesByFormation(form);
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
     * sauve dans la base de donnée une liste de module dans la formation designée par son id
     * @param id de la formation dont on veut saisir ses modules
     * @param listeModules 
     */
    @Override
    public void setModulesPourFormation(int id, List<Module> listeModules) throws Exception {
        modFormDao.setModulesPourFormation(id, listeModules);
    }

   

   
    
}
