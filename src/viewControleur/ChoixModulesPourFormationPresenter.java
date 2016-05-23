package viewControleur;

import controleur.ServicesLesFormations;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import modele.Module;
import view.AjoutFormation;
import view.ChoixModulesPourFormation;


public class ChoixModulesPourFormationPresenter {
    private ChoixModulesPourFormation view;
    private AjoutFormation viewb;
    private ServicesLesFormations servicesLF;
    

    public ChoixModulesPourFormationPresenter( AjoutFormation viewb) {
        this.viewb = viewb;
        initView();
        initialisation();
        view.initialisation();
        
        if (AjoutFormation.listeProvisoireModules != null){
            //CheckBox[] check = new CheckBox[servicesLF.donneMaxIdModule()];
            for (Module unMod : AjoutFormation.listeProvisoireModules){
                view.getCheck()[unMod.getId()].setSelected(true);

            }
            
        }
        checkbox();
        newModule();
    }
    
    private void initView() {
        view = new ChoixModulesPourFormation();
        ScrollPane scroll = new ScrollPane(view);
        ControleurViews.borderPane.setRight(scroll);
    }

    private void initialisation() {
        try {
            servicesLF = new ServicesLesFormations();
            view.setMaxIdModule(servicesLF.donneMaxIdModule());
            view.setLesModules(servicesLF.getListeModules());
        } catch (Exception ex) {
               fenetreErreurPresenter erreur = new fenetreErreurPresenter();
        }
        
    }

    private void checkbox() {
        for (int i=0 ; i <view.getCheck().length    ; i++){
            if (view.getCheck()[i] != null){
                int a =i;
                view.getCheck()[i].setOnAction((ActionEvent t) -> {
                     if (view.getCheck()[a].isSelected()){
                        remplisageDyna(a);
                     }
                     else
                         remplisageDyna(-a);
                });
            }
        }
    }

    private void remplisageDyna(int a) {
      
            if (viewb.getListeProvisoireModules() == null )
                AjoutFormation.listeProvisoireModules = new ArrayList<>();
            
            
            if (a > 0){
                AjoutFormation.listeProvisoireModules.add(servicesLF.donneModuleParId(a));
                
            }
            else {
                for (Module unMod :AjoutFormation.listeProvisoireModules){
                    if (unMod.getId() == -a){
                        AjoutFormation.listeProvisoireModules.remove(unMod);
                        break;
                    }
                }
            }
                       
            AjoutFormationPresenter aFP = new AjoutFormationPresenter(AjoutFormation.listeProvisoireModules,viewb.getIntitule(),viewb.getDescription());
           
            
       
    }

    private void newModule() {
         view.getNewModule().setOnAction((ActionEvent t) -> {
                   action();
                });
    }
    
    public void action(){
        Stage st = new Stage();
        st.setMaxWidth(1100);
        st.setMaxHeight(570);
        st.setMinWidth(1000);
        st.setMinHeight(540);
        
        AjoutModulePresenter aMP = new AjoutModulePresenter(st,viewb);
        
        
        
        
    }

    

    
}
