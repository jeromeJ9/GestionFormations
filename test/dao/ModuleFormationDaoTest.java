/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controleur.ServicesLesFormations;
import java.util.ArrayList;
import java.util.List;
import modele.Formation;
import modele.Module;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jerom
 */
public class ModuleFormationDaoTest extends DaoTest{
    
    public ModuleFormationDaoTest() {
    }

    /**
     * Test of setModulesPourFormation method, of class ModuleFormationDao.
     */
    @Test
    public void testSetModulesPourFormation() throws Exception {
        System.out.println("setModulesPourFormation");
       
        ServicesLesFormations serv = new ServicesLesFormations();
        serv.rempliListes();
        List<Module> expResult = serv.getListeModules();
               
        FormationDao formDao = new FormationDao();
        int idForm = formDao.setNewFormation("test", "test");
        ModuleFormationDao instance = new ModuleFormationDao();
        instance.setModulesPourFormation(idForm, expResult);
        
        ModuleDao modDao = new ModuleDao();
        serv.rempliListes();
        Formation form = (serv.donneFormationParId(idForm));
        System.out.println("formation:    "+form);
        List<Module> result = modDao.getModulesByFormation(form);
        assertEquals(expResult, result);
        
    }

    
}
