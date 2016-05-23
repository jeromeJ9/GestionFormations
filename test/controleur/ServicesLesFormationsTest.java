        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

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
public class ServicesLesFormationsTest extends DaoTest{
    
    public ServicesLesFormationsTest() {
    }

   
    /**
     * Test of donneMaxIdFormation method, of class ServicesLesFormations.
     */
    @Test
    public void testDonneMaxIdFormation() throws Exception {
        System.out.println("donneMaxIdFormation");
        ServicesLesFormations instance = new ServicesLesFormations();
        instance.setNewFormation("", "");
        instance.setNewFormation("", "");
        instance.setNewFormation("", "");
        int result = instance.donneMaxIdFormation();
        assertEquals(9, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of donneFormationAvecModule method, of class ServicesLesFormations.
     */
    
    @Test
    public void testDonneFormationAvecModule() throws Exception {
        System.out.println("donneFormationAvecModule");
        ServicesLesFormations instance = new ServicesLesFormations();
        instance.donneFormationAvecModule();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of donneModuleByFormation method, of class ServicesLesFormations.
     */
    @Test
    public void testDonneModuleByFormation() throws Exception {
        System.out.println("donneModuleByFormation");
        int id = 0;
        ServicesLesFormations instance = new ServicesLesFormations();
        List<Module> expResult = null;
        List<Module> result = instance.donneModuleByFormation(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of donneMaxIdModule method, of class ServicesLesFormations.
     */
    @Test
    public void testDonneMaxIdModule() throws Exception {
        System.out.println("donneMaxIdModule");
        ServicesLesFormations instance = new ServicesLesFormations();
        int expResult = 0;
        int result = instance.donneMaxIdModule();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of donneModuleParId method, of class ServicesLesFormations.
     */
    @Test
    public void testDonneModuleParId() throws Exception {
        System.out.println("donneModuleParId");
        int id = 0;
        ServicesLesFormations instance = new ServicesLesFormations();
        Module expResult = null;
        Module result = instance.donneModuleParId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllFormation method, of class ServicesLesFormations.
     */
    @Test
    public void testGetAllFormation() throws Exception {
        System.out.println("getAllFormation");
        ServicesLesFormations instance = new ServicesLesFormations();
        List<Formation> expResult = null;
        List<Formation> result = instance.getAllFormation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNewFormation method, of class ServicesLesFormations.
     */
    @Test
    public void testSetNewFormation() throws Exception {
        System.out.println("setNewFormation");
        String intitule = "";
        String description = "";
        ServicesLesFormations instance = new ServicesLesFormations();
        int expResult = 0;
        int result = instance.setNewFormation(intitule, description);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllModule method, of class ServicesLesFormations.
     */
    @Test
    public void testGetAllModule() throws Exception {
        System.out.println("getAllModule");
        ServicesLesFormations instance = new ServicesLesFormations();
        List<Module> expResult = null;
        List<Module> result = instance.getAllModule();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModulesByFormation method, of class ServicesLesFormations.
     */
    @Test
    public void testGetModulesByFormation() throws Exception {
        System.out.println("getModulesByFormation");
        Formation form = null;
        ServicesLesFormations instance = new ServicesLesFormations();
        List<Module> expResult = null;
        List<Module> result = instance.getModulesByFormation(form);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNewModule method, of class ServicesLesFormations.
     */
    @Test
    public void testSetNewModule() throws Exception {
        System.out.println("setNewModule");
        String intitule = "";
        String description = "";
        int duree = 0;
        ServicesLesFormations instance = new ServicesLesFormations();
        instance.setNewModule(intitule, description, duree);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModulesPourFormation method, of class ServicesLesFormations.
     */
    @Test
    public void testSetModulesPourFormation() throws Exception {
        System.out.println("setModulesPourFormation");
        int id = 0;
        List<Module> listeModules = null;
        ServicesLesFormations instance = new ServicesLesFormations();
        instance.setModulesPourFormation(id, listeModules);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
