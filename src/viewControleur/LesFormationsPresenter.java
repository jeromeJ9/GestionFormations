package viewControleur;

import controleur.ServicesLesFormations;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ScrollPane;
import modele.Formation;
import modele.Module;
import view.LesFormations;

public class LesFormationsPresenter extends LesFormations{
    private List<Formation> listeDesFormations;
    private LesFormations view;
    private int position = -1;
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
        listeDesFormations = servicesLF.getListeFormations();
      
        int nbJourTot;
        for ( Formation unform : listeDesFormations){
            nbJourTot = 0;
            for (Module unMod : unform.getModule()){
                nbJourTot += unMod.getNb_jour();
            }
            unform.setNbJours(nbJourTot);
        }
          
       view.setNbMaxID(servicesLF.donneMaxIdFormation()); 
       view.setListeFormations(listeDesFormations);
       view.initialisation();
       
       
    }

    private void boutonAction() {
        position=-1;
        for ( int i = 0 ; i < view.getBouton().length ; i++){
            int a = i;
            if (view.getBouton()[i] != null){
                position ++;
                int b = position;
                view.getBouton()[i].setOnAction(e -> detailForm(a, b) );
            }
        }
    }

        
    private void detailForm(int id, int position ) {
        
        view.contraintePourDetail(position);
        DetailUneFormationPresenter dForm = new DetailUneFormationPresenter(servicesLF.donneModuleByFormation(id));
        /*view.getBouton()[id].setOnAction(e ->
        retourBp());
        */
        
        
        //   correction affichage ... couleur de fond non uniforme
        for ( int i = 1 ; i < view.getBlanck().length ; i ++){
             if (view.getBlanck()[i] != null)
                view.getBlanck()[i].setStyle("-fx-background-color: #E4E4D7; ");
        }
        /*
        //   desactivation des boutons details de la liste de formations
        for ( int i = 0 ; i < view.getBouton().length ; i++){
             if (view.getBouton()[i] != null){
                view.getBouton()[i].setDisable(true);
             }
        }
*/
    }

    public void retourBp(){
        ControleurViews.borderPane.setRight(null);
        view.setStyle("-fx-background-color: #F4F4F4; ");
    }

    
    
    
}
