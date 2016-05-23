package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.Formation;
import org.junit.Test;
import static org.junit.Assert.*;

public class FormationDaoTest extends DaoTest{
    
    
    
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        List<Formation> expResult = new ArrayList<>();
        expResult.add(new Formation(1, 
                "BTS Assistance Technique d'Ingénieur", 
                "Le titulaire de ce diplôme peut exercer des fonctions très variées :études, organisation, animation et formation, recherche et développement, production, gestion de production, gestion commerciale"));
        expResult.add(new Formation(2, 
                "Technicien (ne) en systèmes de surveillance ", 
                "Installer, mettre en service et suivre techniquement un chantier d'installation en système de surveillance-intrusion et de vidéoprotection. Maintenir le sytème de surveillance intrusion d'habilitation et de locaux professionnels."));
        expResult.add(new Formation(3, 
                "Bac S.T.I. : génie mécanique, génie électrotechnique", 
                "Assistance technique industrielle, Forgeage et estampage,Moulage, Étude d'outillage, Contrôle et régulation, Microtechnique, Maintenance et vente automobiles, Moteurs à combustion interne"));
        expResult.add(new Formation(4, 
                "BTS Services Informatiques aux Organisations (S.I.O.)", 
                "Le titulaire du BTS SIO travaille, soit en tant que collaborateur d’une organisation, soit en en tant qu'intervenant d'une société d’ingénierie et de services informatiques, d'un éditeur de logiciels, d'une société de conseil en technologies."));
        expResult.add(new Formation(5, 
                "Licence Professionnelle Parcours Sécurité des réseaux ", 
                "La formation vise l’acquisition d’une double compétence informatique et juridique dans le domaine de la sécurité des réseaux et des systèmes informatiques."));
        expResult.add(new Formation(6, 
                "Excel debutant", 
                "bonne formation pour debuter dans le monde d'office !"));
        FormationDao formDao = new FormationDao();
        List<Formation> result = formDao.getAll();
        assertEquals(expResult, result);
       
    }


    /**
     * Test of setNewFormation method, of class FormationDao.
     */
    @Test
    public void testSetNewFormation() throws SQLException {
        System.out.println("setNewFormation");
        int id = 7;
        String intitule = "formation test";
        String description = "avec une grande description";
       
        Formation expResult = new Formation(id, intitule, description);
        
        FormationDao instance = new FormationDao();
        instance.setNewFormation(intitule, description);
       
        for (Formation result : instance.getAll()){
            if(result.getId() == expResult.getId() ){
                assertEquals(expResult, result);

            }
        }
    }

 
  
}
