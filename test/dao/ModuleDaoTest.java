/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
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
public class ModuleDaoTest extends DaoTest{
    
    public ModuleDaoTest() {
    }

    /**
     * Test of getModulesByFormation method, of class ModuleDao.
     */
    @Test
    public void testGetModulesByFormation() throws SQLException {
        System.out.println("getModulesByFormation");
        
        List<Module> expResult = new ArrayList<>();
        expResult.add(new Module(1, "Mathematiques", "Probabilites, statistiques", 10));
        expResult.add(new Module(5, "Francais", "analyse de documents", 18));
        expResult.add(new Module(6, "Mathematiques 2", "analyse, algebre", 35));
        expResult.add(new Module(7, "Anglais", "niveau B2", 50));
        expResult.add(new Module(10, "Économie et gestion d'entreprise ", "economie de marche et synthese globale", 55));
         
        
        Formation form = new Formation(3, 
                                    "Bac S.T.I. : génie mécanique, génie électrotechnique", 
                                    "Assistance technique industrielle, Forgeage et estampage,Moulage, Étude d'outillage, Contrôle et régulation, Microtechnique, Maintenance et vente automobiles, Moteurs à combustion interne");
        ModuleDao instance = new ModuleDao();
        List<Module> result = instance.getModulesByFormation(form);
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAll method, of class ModuleDao.
     */
    @Test
    public void testGetAll() throws SQLException {
        System.out.println("getAll");
        List<Module> expResult = new ArrayList<>();
        expResult.add(new Module(1, "Mathematiques", "Probabilites, statistiques", 10));
        expResult.add(new Module(2, "Automatisme", "dans l'aeronautique", 15));
        expResult.add(new Module(3, "Physique appliquée", "physique gros niveau", 35));
        expResult.add(new Module(4, "Organisation industrielle", "organiser le fonctionnement", 40));
        expResult.add(new Module(5, "Francais", "analyse de documents", 18));
        expResult.add(new Module(6, "Mathematiques 2", "analyse, algebre", 35));
        expResult.add(new Module(7, "Anglais", "niveau B2", 50));
        expResult.add(new Module(8, "dessin technique", "dessin a l'aide de dao", 35));
        expResult.add(new Module(9, "informatique", "javaEE: Application WEB", 60));
        expResult.add(new Module(10, "Économie et gestion d'entreprise ", "economie de marche et synthese globale", 55));
        expResult.add(new Module(11, "excel 1", "premiers pas pour faire des tableaux", 10));
       
        ModuleDao modDao = new ModuleDao();
        List<Module> result = modDao.getAll();
        //for (int i = 0 ; i <11; i++){
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setNewModule method, of class ModuleDao.
     */
    @Test
    public void testSetNewModule() throws SQLException {
        System.out.println("setNewModule");
        int id = 12;
        String intitule = "module test";
        String description = "avec une petite description";
        int duree = 5;
       
        Module expResult = new Module(id, intitule, description, duree);
        
        ModuleDao instance = new ModuleDao();
        instance.setNewModule(intitule, description, duree);
       
        for (Module result : instance.getAll()){
            if(result.getId() == expResult.getId() ){
                assertEquals(expResult, result);

            }
        }
    }
}
