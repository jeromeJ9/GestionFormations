package viewControleur;

import service.ServicesLesFormations;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.AjoutFormation;
import view.AjoutModule;


public class AjoutModulePresenter {
    private AjoutModule view;
    private String intitule;
    private String description;
    private String duree;
    private ServicesLesFormations servicesLF;
   
    public AjoutModulePresenter() {
        initView();
        initialisation();
        ControleurViews.borderPane.setRight(null);
        servicesLF = new ServicesLesFormations();
    }

   
    private void initView() {
        view = new AjoutModule();
        initMessageErreur();  // cache les messages d'erreurs
        ScrollPane scrollaM = new ScrollPane(view);
        ControleurViews.borderPane.setCenter(scrollaM);
    }
    
    private void initialisation() {
        view.getSubmit().setOnAction(e -> {
            try {
                validationNewModule();
            } catch (Exception ex) {
                fenetreErreurPresenter erreur = new fenetreErreurPresenter();
            }
        });
    }

    private void validationNewModule() throws Exception {
        intitule = view.getIntitule();
        description = view.getDescription();
        duree = view.getDuree();
        if ( controleSaisie(intitule, description, duree) ){
            confirmationAjoutModule(intitule,description,duree);
        }
    }
    private void confirmationAjoutModule(String intitule,String description, String duree) throws Exception {
        servicesLF.setNewModule(intitule, description, Integer.parseInt(duree));
       
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.setTitle("Enregistrement reussi");
        stage.setOnCloseRequest(e -> retourListeModule(stage) );
       
        GridPane gp = new GridPane();
        gp.setVgap(30);
      
        Button newM = new Button("Creation d'un nouveau module");
        gp.setMargin(newM, new Insets(8, 0, 0, 15));
        newM.setOnAction(e -> newAjout(stage) );
        gp.add(newM,0, 0);
        
        Button liste = new Button("Retour a la liste des modules");
        gp.setMargin(liste, new Insets(8, 0, 0, 15));
        liste.setOnAction(e -> retourListeModule(stage) );
        gp.add(liste, 1, 0);
        
        Scene sc = new Scene(gp, 510, 60);
        stage.setScene(sc);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    
    private void newAjout(Stage st) {
            ControleurViews cV = new ControleurViews();
            cV.afficheAjoutModule();
            ControleurViews.borderPane.setRight(null);
            st.close();
    }
    
    private void retourListeModule(Stage st) {
            ControleurViews cV = new ControleurViews();
            cV.affichageLesModules();
            ControleurViews.borderPane.setRight(null);
            st.close();
    }
    
    
    
    
    
    
    
    
    // constructeur utilise lors de la creation de formation dans un nouveau stage
    
     public AjoutModulePresenter (Stage st, AjoutFormation viewb){
        BorderPane border = new BorderPane();
        Scene sc = new Scene(border, 500, 3500);
        initView(border);
        initialisationbis(border,st,viewb);
        st.setScene(sc);
        st.show();
        servicesLF = new ServicesLesFormations();
    }
    
    private void initView(BorderPane border) {
        view = new AjoutModule();
        initMessageErreur();  // cache les message d'erreur
        ScrollPane scrollaM = new ScrollPane(view);
        border.setCenter(scrollaM);
    }
    
     private void initialisationbis(BorderPane border, Stage st, AjoutFormation viewb) {
      view.getSubmit().setOnAction(e -> {
          try {
              validationNewModuleBis(border, st, viewb);
          } catch (Exception ex) {
               fenetreErreurPresenter erreur = new fenetreErreurPresenter();
          }
      } );
    }

    private void validationNewModuleBis(BorderPane border,Stage st, AjoutFormation viewb) throws Exception {
        intitule = view.getIntitule();
        description = view.getDescription();
        duree = view.getDuree();
        if ( controleSaisie(intitule, description, duree) ){
            confirmationbis(border, st, viewb,intitule,description,duree);
        }    
    }
    
    private void confirmationbis(BorderPane border,Stage st, AjoutFormation viewb,String intitule,String description, String duree) throws Exception {
        servicesLF.setNewModule(intitule, description, Integer.parseInt(duree));
       
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.setTitle("Enregistrement reussi");
        stage.setOnCloseRequest(e -> retourAjoutFormation(stage,st,border, viewb) );
       
        GridPane gp = new GridPane();
        gp.setVgap(30);
      
              
        Button liste = new Button("Retour a la creation de la formation");
        gp.setMargin(liste, new Insets(8, 0, 0, 15));
        liste.setOnAction(e -> retourAjoutFormation(stage,st,border, viewb) );
        gp.add(liste, 1, 0);
        
        Scene sc = new Scene(gp, 510, 60);
        stage.setScene(sc);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
       
      
    }
    private void retourAjoutFormation(Stage st,Stage stage,  BorderPane bp, AjoutFormation viewb) {
        st.close();
        stage.close();
        AjoutFormationPresenter dd = new AjoutFormationPresenter(viewb);
    }
    
    private boolean controleSaisie (String intitule, String description, String duree) throws Exception{
        int valide = 0;
        
        if (! intitule.equals("") && intitule.matches("[a-zA-Z0-9éèàç^', ]*") ){
            view.getIntituleErreur().setVisible(false);
            view.setIntitule("-fx-border-width: 0px ;");
            if ( !servicesLF.isIntituleModuleExist(intitule)){
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
        
            
        if ( description.equals("") || !description.matches("[a-zA-Z0-9éèàç^', ]*")){
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
