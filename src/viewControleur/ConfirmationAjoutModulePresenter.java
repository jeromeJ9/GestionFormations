package viewControleur;

import controleur.ServicesLesFormations;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.AjoutFormation;
import view.ConfirmationAjoutModule;


public class ConfirmationAjoutModulePresenter {
    private ConfirmationAjoutModule view;
    private String intitule;
    private String description;
    private String duree;
    private ServicesLesFormations servicesLF;
 
    public ConfirmationAjoutModulePresenter(String intitule, String description, String duree) {
        this.intitule = intitule;
        this.description = description;
        this.duree = duree;
        initView();
        initialisation();
    }
    
     public ConfirmationAjoutModulePresenter(Stage stant, BorderPane bpant,AjoutFormation viewb, String intitule, String description, String duree) {
        this.intitule = intitule;
        this.description = description;
        this.duree = duree;
        initView(bpant);
        initialisation(stant, bpant, viewb);
    }
     
     
     
     
    //############## premier constructeur
    private void initView() {
        view = new ConfirmationAjoutModule();
        ControleurViews.borderPane.setRight(view);
    }
    
    private void initialisation(){
        view.setIntitule(intitule);
        view.setDescription(description);
        view.setDuree(duree);
        view.initialisation();
        Region r = new Region();
            r.setMaxWidth(8);
            GridPane.setHalignment(r, HPos.RIGHT);
            GridPane.setConstraints(r, 0, 1, 1, Integer.SIZE);
            view.getChildren().set(0, r); 
            r.setStyle("-fx-background-color:#353B56 ");
            view.getChildren().set(0, r);
                    
            view.getSubmit().setOnAction(e -> {
            try {
                confirmation();
            } catch (Exception ex) {
               fenetreErreurPresenter erreur = new fenetreErreurPresenter();
            }
        } );
        view.getModif().setOnAction(e -> ControleurViews.borderPane.setRight(null));
    }
    private void confirmation() throws Exception {
        servicesLF = new ServicesLesFormations();
        servicesLF.setNewModule(intitule, description, Integer.parseInt(duree));
       
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.setTitle("Enregistrement reussi");
        stage.setOnCloseRequest(e -> liste(stage) );
       
        GridPane gp = new GridPane();
        gp.setVgap(30);
      
        Button newM = new Button("Creation d'un nouveau module");
        gp.setMargin(newM, new Insets(8, 0, 0, 15));
        newM.setOnAction(e -> ajout(stage) );
        gp.add(newM,0, 0);
        
        Button liste = new Button("Retour a la liste des modules");
        gp.setMargin(liste, new Insets(8, 0, 0, 15));
        liste.setOnAction(e -> liste(stage) );
        gp.add(liste, 1, 0);
        
        Scene sc = new Scene(gp, 510, 60);
        stage.setScene(sc);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
       
      
    }
    private void ajout(Stage st) {
            ControleurViews cV = new ControleurViews();
            cV.afficheAjoutModule();
            ControleurViews.borderPane.setRight(null);
            st.close();
    }
    
    private void liste(Stage st) {
            ControleurViews cV = new ControleurViews();
            cV.affichageLesModules();
            ControleurViews.borderPane.setRight(null);
            st.close();
    }

    
    
    
    
    
    
    
    //############## deuxieme constructeur
    private void initView(BorderPane bp) {
        view = new ConfirmationAjoutModule();
        bp.setRight(view);
    }
    
    private void initialisation(Stage st, BorderPane bp, AjoutFormation viewb){
        view.setIntitule(intitule);
        view.setDescription(description);
        view.setDuree(duree);
        view.initialisation();
        Region r = new Region();
            r.setMaxWidth(8);
            GridPane.setHalignment(r, HPos.RIGHT);
            GridPane.setConstraints(r, 0, 1, 1, Integer.SIZE);
            view.getChildren().set(0, r); 
            r.setStyle("-fx-background-color:#353B56 ");
            view.getChildren().set(0, r);
                    
        view.getSubmit().setOnAction(e -> {
            try {
                confirmation(st, bp, viewb);
            } catch (Exception ex) {
               fenetreErreurPresenter erreur = new fenetreErreurPresenter();
            }
        } );
        view.getModif().setOnAction(e -> bp.setRight(null));
    }

    private void confirmation(Stage st, BorderPane bp, AjoutFormation viewb) throws Exception {
        servicesLF = new ServicesLesFormations();
        servicesLF.setNewModule(intitule, description, Integer.parseInt(duree));
                
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.setTitle("Enregistrement reussi");
        
       
        GridPane gp = new GridPane();
        gp.setVgap(30);
      
        Button newM = new Button("Retour a la creation de la formation");
        gp.setMargin(newM, new Insets(8, 0, 0, 15));
        newM.setOnAction(e -> ajout(stage, st, bp, viewb) );
        gp.add(newM,0, 0);
        
        Scene sc = new Scene(gp, 510, 60);
        stage.setScene(sc);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
       
      
    }

    private void ajout(Stage st, Stage stant, BorderPane bp, AjoutFormation viewb) {
       
        st.close();
        stant.close();
        ChoixModulesPourFormationPresenter ll = new ChoixModulesPourFormationPresenter(viewb);
        
        
    }

}
