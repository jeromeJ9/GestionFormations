package viewControleur;

import controleur.ServicesLesFormations;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.HPos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import view.LesModules;


public class LesModulesPresenter {
    private LesModules view;
    private ServicesLesFormations servicesLF;
        
    public LesModulesPresenter(){
        try {
            initView();
            rempliListModules();
        } catch (Exception ex) {
               fenetreErreurPresenter erreur = new fenetreErreurPresenter();
        }
    }

    private void initView() {
         view = new LesModules();
         ScrollPane scroll = new ScrollPane(view);
         ControleurViews.borderPane.setRight(null);
         ControleurViews.borderPane.setCenter(scroll);
     }
    
    private void rempliListModules() throws Exception {
        servicesLF = new ServicesLesFormations();
        view.setLesModules(servicesLF.getListeModules());
        view.initialisation();

        Region r = new Region();
        r.setMaxWidth(8);
        GridPane.setHalignment(r, HPos.RIGHT);
        GridPane.setConstraints(r, 0, 1, 1, Integer.MAX_VALUE);
        view.getChildren().set(1, r); 
        r.setStyle("-fx-background-color:#353B56 ");
    }

    
    
    
}
