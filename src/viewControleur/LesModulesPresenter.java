package viewControleur;

import service.ServicesLesFormations;
import javafx.scene.control.ScrollPane;
import view.LesModules;


public class LesModulesPresenter {
    private LesModules view;
        
    public LesModulesPresenter(){
        try {
            initView();
            rempliListModules();
        } catch (Exception ex) {
               fenetreErreurPresenter erreur = new fenetreErreurPresenter();
        }
    }

    private void initView() {
         view = new LesModules("Les Modules");
         ScrollPane scroll = new ScrollPane(view);
         ControleurViews.borderPane.setRight(null);
         ControleurViews.borderPane.setCenter(scroll);
     }
    
    private void rempliListModules() throws Exception {
        ServicesLesFormations servicesLF = new ServicesLesFormations();
        view.setLesModules(servicesLF.getListeModules());
        view.initialisation();

       
    }

    
    
    
}
