package viewControleur;

import controleur.ServicesLesFormations;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.AjoutFormation;
import view.AjoutModule;


public class AjoutModulePresenter {
    private AjoutModule view;
    private String intitule;
    private String description;
    private String duree;
   
    public AjoutModulePresenter() {
        initView();
        initialisation();
        ControleurViews.borderPane.setRight(null);
    }

    public AjoutModulePresenter (Stage st, AjoutFormation viewb){
        BorderPane border = new BorderPane();
        Scene sc = new Scene(border, 500, 3500);
        initView(border);
        initialisationbis(border,st,viewb);
        st.setScene(sc);
        st.show();
    }
    
    
    private void initView() {
        view = new AjoutModule();
        initMessageErreur();
        
        ScrollPane scrollaM = new ScrollPane(view);
        ControleurViews.borderPane.setCenter(scrollaM);
    }
    
    private void initialisation() {
        view.getSubmit().setOnAction(e -> {
            try {
                action();
            } catch (Exception ex) {
               fenetreErreurPresenter erreur = new fenetreErreurPresenter();
            }
        });
    }

    private void action() throws Exception {
        int valide = 0;
        intitule = view.getIntitule();
        description = view.getDescription();
        duree = view.getDuree();
        if ( controleSaisie(intitule, description, duree) ){
            ConfirmationAjoutModulePresenter cAMP = new ConfirmationAjoutModulePresenter(intitule,description,duree);
        }
    }
    
    
    
    
    
    
    private void initView(BorderPane border) {
        view = new AjoutModule();
        initMessageErreur();
        ScrollPane scrollaM = new ScrollPane(view);
        border.setCenter(scrollaM);
    }
    
     private void initialisationbis(BorderPane border, Stage st, AjoutFormation viewb) {
      view.getSubmit().setOnAction(e -> {
          try {
              actionbis(border, st, viewb);
          } catch (Exception ex) {
               fenetreErreurPresenter erreur = new fenetreErreurPresenter();
          }
      } );
    }

    private void actionbis(BorderPane border,Stage st, AjoutFormation viewb) throws Exception {
        intitule = view.getIntitule();
        description = view.getDescription();
        duree = view.getDuree();
        if ( controleSaisie(intitule, description, duree) ){
            ConfirmationAjoutModulePresenter cAMP = new ConfirmationAjoutModulePresenter(st, border, viewb, intitule,description,duree);
        }    }
    
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

    private void initMessageErreur() {
        view.getIntituleErreur().setVisible(false);
        view.getIntituleErreur1().setVisible(false);
        view.getDescriptionErreur().setVisible(false);
        view.getDureeErreur().setVisible(false);    }
    
    
    
}
