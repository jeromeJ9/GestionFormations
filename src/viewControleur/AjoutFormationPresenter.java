package viewControleur;

import service.ServicesLesFormations;
import java.util.ArrayList;
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
import view.ChoixModulesPourFormation;


public class AjoutFormationPresenter {
    private AjoutFormation viewAjoutForm;
    private ChoixModulesPourFormation viewModulePourFormation;
    private ServicesLesFormations servicesLF;
    
    
    // constructeur utilise lors du clic sur "ajouter une formation"   
    public AjoutFormationPresenter() {
        servicesLF = new ServicesLesFormations();
        ControleurViews.borderPane.setRight(null);
        initView();                       // creaton vue ajoutFormation
        //viewAjoutForm.listeProvisoireModules = new ArrayList<>();   // evite d'affiché la liste precedente cree lors d'une creation de formation anterieur
        viewAjoutForm.initialisation();
        afficheListeModule();             // affiche la liste des modules avec checkbox associé
        modulePro();                      // enregistrement de la formation
    }
   
    // constructeur utilisé pour mettre a jour la vue center ( mise a jour dynamique des modules selectionnés ), au moins un module deja selectionné
    public AjoutFormationPresenter(List<Module> listeProvisoireModules,String intitule, String description) {
        servicesLF = new ServicesLesFormations();
        initView();
        viewAjoutForm.setListeProvisoireModules(listeProvisoireModules);
        viewAjoutForm.setIntituleS(intitule);
        viewAjoutForm.setDescriptionS(description);
        viewAjoutForm.initialisation();
       
        viewAjoutForm.getSubmit().setVisible(false);
        viewAjoutForm.getClear().setVisible(false);
        afficheListeModule();
        modulePro();  // enregistrement de la formation
    }
   
    // constructeur utilisé lors du retour a la creation de la formation apres la creation d'un nouveau module
    public AjoutFormationPresenter( AjoutFormation view) {
        servicesLF = new ServicesLesFormations();
        initView();
        viewAjoutForm.setListeProvisoireModules(view.getListeProvisoireModules());
        viewAjoutForm.setIntituleS(view.getIntitule());
        viewAjoutForm.setDescriptionS(view.getDescription());
        viewAjoutForm.initialisation();
       
        viewAjoutForm.getSubmit().setVisible(false);
        viewAjoutForm.getClear().setVisible(false);
        afficheListeModuleDirect(view);   //modifie car on ne doit plus avoir de bouton pour choisir un module
        modulePro();  // enregistrement de la formation
    }
    
    
    
   
    private void initView() {
        viewAjoutForm = new AjoutFormation();
        ScrollPane scrollaM = new ScrollPane(viewAjoutForm);
        ControleurViews.borderPane.setCenter(scrollaM);
    }
    
    private void afficheListeModule() {
            viewAjoutForm.getSubmit().setOnAction((ActionEvent t) -> {     //action bouton affichage les modules a selectionnés
            creationVueModules();                                          // construction de la vue des modules
            initialisationPresenterModule();
            viewModulePourFormation.initialisation();

            if (viewAjoutForm.listeProvisoireModules != null){             // on re-check les modules deja choisis
                for (Module unMod : viewAjoutForm.listeProvisoireModules){
                    viewModulePourFormation.getCheck()[unMod.getId()].setSelected(true);
                }
            }
            checkbox();
            newModule();
                viewAjoutForm.getSubmit().setVisible(false);
                viewAjoutForm.getClear().setVisible(false);
                viewAjoutForm.afficheModuleSelec();
            });   
    }
    private void creationVueModules() {
        viewModulePourFormation = new ChoixModulesPourFormation();
        ScrollPane scroll = new ScrollPane(viewModulePourFormation);
        ControleurViews.borderPane.setRight(scroll);
    }
    private void initialisationPresenterModule() {
        try {
            viewModulePourFormation.setMaxIdModule(servicesLF.donneMaxIdModule());
            viewModulePourFormation.setLesModules(servicesLF.getListeModules());
        } catch (Exception ex) {
               fenetreErreurPresenter erreur = new fenetreErreurPresenter();
        }
    }
    private void checkbox() {
        for (int i=0 ; i <viewModulePourFormation.getCheck().length    ; i++){
            if (viewModulePourFormation.getCheck()[i] != null){
                int a =i;
                viewModulePourFormation.getCheck()[i].setOnAction((ActionEvent t) -> {
                     if (viewModulePourFormation.getCheck()[a].isSelected()){
                        remplisageDyna(a);
                     }
                     else
                         remplisageDyna(-a);
                });
            }
        }
    }

    private void remplisageDyna(int a) {
            if (viewAjoutForm.getListeProvisoireModules() == null )
                viewAjoutForm.listeProvisoireModules = new ArrayList<>();
            if (a > 0){
                    try {
                        viewAjoutForm.listeProvisoireModules.add(servicesLF.donneModuleParId(a));   //rajoute le module selectionné
                    } catch (Exception ex) {
                        Logger.getLogger(AjoutFormationPresenter.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            else {
                for (Module unMod :viewAjoutForm.listeProvisoireModules){
                    if (unMod.getId() == -a){
                        viewAjoutForm.listeProvisoireModules.remove(unMod);
                        break;
                    }
                }
            }
            AjoutFormationPresenter aFP = new AjoutFormationPresenter(viewAjoutForm.listeProvisoireModules,viewAjoutForm.getIntitule(),viewAjoutForm.getDescription());
            // on va reconstruire la vue pour afficher les modifications de choix de modules
    }
    private void newModule() {
         viewModulePourFormation.getNewModule().setOnAction((ActionEvent t) -> {
        creationNewModule();
        });
    }
    private void creationNewModule(){
        Stage st = new Stage();
        st.setMaxWidth(1100);
        st.setMaxHeight(570);
        st.setMinWidth(1000);
        st.setMinHeight(540);
        AjoutModulePresenter aMP = new AjoutModulePresenter(st,viewAjoutForm);
    } 
    
    private void modulePro() {
       if (viewAjoutForm.getListeProvisoireModules() != null){
           viewAjoutForm.moduleSelect();    // on affiche sous le formulaire de la formation les modules selectionnés
           viewAjoutForm.getValide().setOnAction( e -> {
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
        id = servicesLF.setNewFormation(viewAjoutForm.getIntitule(), viewAjoutForm.getDescription());   // renvoi l'id de la formation crée  (id dans la base)
        servicesLF.setModulesPourFormation(id, viewAjoutForm.listeProvisoireModules);
        confirmation();
    }
    private void confirmation() {
        
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.setTitle("Enregistrement reussi");
       
        GridPane gp = new GridPane();
        gp.setVgap(30);
      
        Button newM = new Button("Retour a la liste des formations");
        gp.setMargin(newM, new Insets(8, 0, 0, 15));
        newM.setOnAction(e -> retourListeFormations(stage) );
        gp.add(newM,0, 0);
              
        Scene sc = new Scene(gp, 510, 60);
        stage.setScene(sc);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
     
    
    private void retourListeFormations(Stage st) {
        viewAjoutForm.initListeProvisoireModules();   // evite de re afficher les precedents module selectionnés lors d'une nouvelle creation de formation
        ControleurViews.borderPane.setCenter(null);
        ControleurViews.borderPane.setRight(null);
        LesFormationsPresenter lesFP = new LesFormationsPresenter();
        st.close();
    }
    
     
    
    
    
    
     
     
     
     
    
    
    // on passe l'etape du bouton selectionné pour affiche la liste des modules
    private void afficheListeModuleDirect(AjoutFormation view) {
            creationVueModules();
            initialisationPresenterModule();
            viewModulePourFormation.initialisation();
            if (view.listeProvisoireModules != null){
                for (Module unMod : view.listeProvisoireModules){
                    viewModulePourFormation.getCheck()[unMod.getId()].setSelected(true);
                }
            }
            checkbox();
            newModule();
                view.getSubmit().setVisible(false);
                view.getClear().setVisible(false);
                view.afficheModuleSelec();
    }
    
    
   

    

    

   
    
      
        
        
    
    
    
    
    
    
    
    
    

    
/*
    private boolean controleSaisie (String intitule, String description, String duree) throws Exception{
        ServicesLesFormations ser = new ServicesLesFormations();
        int valide = 0;
        
        if (! intitule.equals("") && intitule.matches("[a-zA-Z0-9éèàç^' ]*") ){
            viewAjoutForm.getIntituleErreur().setVisible(false);
            viewAjoutForm.setIntitule("-fx-border-width: 0px ;");
            if ( !ser.isIntituleModuleExist(intitule)){
                viewAjoutForm.getIntituleErreur1().setVisible(false);
                viewAjoutForm.setIntitule("-fx-border-width: 0px ;");            }
             else{
                viewAjoutForm.getIntituleErreur1().setVisible(true);
                viewAjoutForm.setIntitule("-fx-border-color: red ; -fx-border-width: 1px ; -fx-border-radius: 4px;");
                valide ++;
             }
        }
        else{
            viewAjoutForm.getIntituleErreur().setVisible(true);
            viewAjoutForm.setIntitule("-fx-border-color: red ; -fx-border-width: 1px ; -fx-border-radius: 4px;");
            valide ++;
        }
        
            
        if ( description.equals("") || !description.matches("[a-zA-Z0-9éèàç^' ]*")){
            viewAjoutForm.getDescriptionErreur().setVisible(true);
            viewAjoutForm.setDescription("-fx-border-color: red ; -fx-border-width: 1px ; -fx-border-radius: 4px;");
            valide ++;
        }
        else{
            viewAjoutForm.getDescriptionErreur().setVisible(false);
            viewAjoutForm.setDescription("-fx-border-width: 0px ;");
        }
            
        if ( duree.equals("") || !duree.matches("[0-9]*")){
            viewAjoutForm.getDureeErreur().setVisible(true);
            viewAjoutForm.setDuree("-fx-border-color: red ; -fx-border-width: 1px ; -fx-border-radius: 4px;");
            valide ++;
        }
        else{
            viewAjoutForm.getDureeErreur().setVisible(false);
            viewAjoutForm.setDuree("-fx-border-width: 0px ;");
        }
        
        return valide == 0;
               
            
     }     
   */ 
    
}
