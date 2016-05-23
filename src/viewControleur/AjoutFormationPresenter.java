package viewControleur;

import controleur.ServicesLesFormations;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modele.Module;
import view.AjoutFormation;


public class AjoutFormationPresenter {
    private AjoutFormation view;
    private ServicesLesFormations servicesLF;
    
        
    public AjoutFormationPresenter() {
        ControleurViews.borderPane.setRight(null);
        initView();
        view.initialisation();
        action();
        modulePro();
    }
    public AjoutFormationPresenter(List<Module> listeProvisoireModules,String intitule, String description) {
        initView();
        view.setListeProvisoireModules(listeProvisoireModules);
        view.setIntituleS(intitule);
        view.setDescriptionS(description);
        view.initialisation();
       
        view.getSubmit().setVisible(false);
        view.getClear().setVisible(false);
        action();
        modulePro();
    }
    
    
   
    private void initView() {
        view = new AjoutFormation();
        ScrollPane scrollaM = new ScrollPane(view);
        ControleurViews.borderPane.setCenter(scrollaM);
    }
    
    
    private void action() {
        
        view.getSubmit().setOnAction((ActionEvent t) -> { 
            ChoixModulesPourFormationPresenter cMFP = new ChoixModulesPourFormationPresenter(view);
            view.getSubmit().setVisible(false);
            view.getClear().setVisible(false);
            view.afficheModuleSelec();
        });
        
        
        
        
    }
    
    

    private void modulePro() {
       if (view.getListeProvisoireModules() != null){
           view.moduleSelect();
           view.getValide().setOnAction( e -> {
               try {
                   ajoutFormationAvecModules();
               } catch (Exception ex) {
               fenetreErreurPresenter erreur = new fenetreErreurPresenter();
               }
           });
       }
    }
    
    private void ajoutFormationAvecModules() throws Exception{
        int id = 0;
        servicesLF = new ServicesLesFormations();
        id = servicesLF.setNewFormation(view.getIntitule(), view.getDescription());
        for (Module unMod : AjoutFormation.listeProvisoireModules)
            System.out.println("detail:     "+unMod.getIntitule()+"id:    "+id);
        servicesLF.setModulesPourFormation(id, AjoutFormation.listeProvisoireModules);
        confirmation();
    }
    
    private void confirmation() {
        
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.setTitle("Enregistrement reussi");
       
        GridPane gp = new GridPane();
        gp.setVgap(30);
      
        Button newM = new Button("Retour a la liste des formations");
        gp.setMargin(newM, new Insets(8, 0, 0, 15));
        newM.setOnAction(e -> retour(stage) );
        gp.add(newM,0, 0);
              
        Scene sc = new Scene(gp, 510, 60);
        stage.setScene(sc);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
     
    
    private void retour(Stage st) {
            ControleurViews.borderPane.setCenter(null);
            ControleurViews.borderPane.setRight(null);
            LesFormationsPresenter lesFP = new LesFormationsPresenter();
            st.close();
    }
/*
    private boolean controleSaisie (String intitule, String description, String duree) throws Exception{
        ServicesLesFormations ser = new ServicesLesFormations();
        int valide = 0;
        
        if (! intitule.equals("") && intitule.matches("[a-zA-Z0-9éèàç^' ]*") ){
            view.getIntituleErreur().setVisible(false);
            view.setIntitule("-fx-border-width: 0px ;");
            if ( !ser.isIntituleModuleExist(intitule)){
                view.getIntituleErreur1().setVisible(false);
                view.setIntitule("-fx-border-width: 0px ;");            }
             else{
                view.getIntituleErreur1().setVisible(true);
                view.setIntitule("-fx-border-color: red ; -fx-border-width: 1px ; -fx-border-radius: 4px;");
                valide ++;
             }
        }
        else{
            view.getIntituleErreur().setVisible(true);
            view.setIntitule("-fx-border-color: red ; -fx-border-width: 1px ; -fx-border-radius: 4px;");
            valide ++;
        }
        
            
        if ( description.equals("") || !description.matches("[a-zA-Z0-9éèàç^' ]*")){
            view.getDescriptionErreur().setVisible(true);
            view.setDescription("-fx-border-color: red ; -fx-border-width: 1px ; -fx-border-radius: 4px;");
            valide ++;
        }
        else{
            view.getDescriptionErreur().setVisible(false);
            view.setDescription("-fx-border-width: 0px ;");
        }
            
        if ( duree.equals("") || !duree.matches("[0-9]*")){
            view.getDureeErreur().setVisible(true);
            view.setDuree("-fx-border-color: red ; -fx-border-width: 1px ; -fx-border-radius: 4px;");
            valide ++;
        }
        else{
            view.getDureeErreur().setVisible(false);
            view.setDuree("-fx-border-width: 0px ;");
        }
        
        return valide == 0;
               
            
     }     
   */ 
    
}
