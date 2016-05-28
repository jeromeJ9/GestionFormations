package viewControleur;

import service.ServicesLesFormations;
import java.util.List;
import javafx.scene.control.ScrollPane;
import modele.Formation;
import view.LesFormations;
import view.LesModules;

public class LesFormationsPresenter {
    private List<Formation> listeDesFormations;
    private LesFormations view;
    private LesModules view2;
    private ServicesLesFormations servicesLF;
    
    
    public LesFormationsPresenter() {
        try {
            initView();
            dataForView();
            boutonAction();
        } catch (Exception ex) {
               fenetreErreurPresenter erreur = new fenetreErreurPresenter();
        }
    }
    
    private void initView(){
        view = new LesFormations();
        ScrollPane SP = new ScrollPane(view);
        SP.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        SP.setStyle("-fx-background-color: #EEEDEF; ");
        ControleurViews.borderPane.setCenter(SP);
        ControleurViews.borderPane.setRight(null);
     }

    

    private void dataForView() throws Exception{
        servicesLF = new ServicesLesFormations();
        listeDesFormations = servicesLF.getFormationsAvecModules();
        view.setNbMaxID(servicesLF.donneMaxIdFormation(listeDesFormations)); 
        view.setListeFormations(listeDesFormations);
        view.initialisation();
       
       
    }

    private void boutonAction() {
        for ( int i = 0 ; i < view.getBouton().length ; i++){
            int a = i;
            if (view.getBouton()[i] != null){
               view.getBouton()[i].setOnAction(e -> detailForm(a ) );
            }
        }
    }

        
    private void detailForm(int id ) {
        
        view.contraintePourDetail(id-1);
        view2 = new LesModules("");
        ScrollPane scroll = new ScrollPane(view2);
        ControleurViews.borderPane.setRight(scroll);
        scroll.setStyle("-fx-border-color: #F4F4F4;");
        
        view2.setLesModules(servicesLF.donneModuleByFormation(id,listeDesFormations ));
        view2.initialisation();
         
        
   
        //   correction affichage ... couleur de fond non uniforme
        for ( int i = 1 ; i < view.getBlanck().length ; i ++){
             if (view.getBlanck()[i] != null)
                view.getBlanck()[i].setStyle("-fx-background-color: #E4E4D7; ");
        }
    }

    
    
    
}
