/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import service.ServicesLesFormations;
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
        ServicesLesFormations serv  = new ServicesLesFormations();
        ModuleFormationDao mfd = new ModuleFormationDao();
        Module unMod = serv.donneModuleParId(3);
        List<Module> listeMod = new ArrayList<>();
        listeMod.add(unMod);
        mfd.setModulesPourFormation(6, listeMod);
        
        List<Formation> lesForm = serv.getFormationsAvecModules();
        boolean result = false;
        for (Formation uneForm : lesForm){
            for (Module unModule : uneForm.getModule()){
                if (uneForm.getId() == 6 && unModule.getId() == 3)
                    result = true;
            }
        }
        assertTrue(result);
        
        
        
    }

    
}
