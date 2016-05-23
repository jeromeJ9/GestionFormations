package view;

import com.sun.javafx.css.Style;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class AjoutModule extends GridPane{
    private Button submit;
    private TextField intitule;
    private TextField description;
    private TextField duree;
    private String titre;
    private Label intituleErreur;
    private Label descriptionErreur;
    private Label dureeErreur;
    private Label intituleErreur1;
    
   public Button getSubmit() {
        return submit;
    } 

    public String getIntitule() {
        return intitule.getText();
    }

    public void setIntitule(String css) {
        this.intitule.setStyle(css);
    }
    public void setDescription(String css) {
        this.description.setStyle(css);
    }
    public void setDuree(String css) {
        this.duree.setStyle(css);
    }
    public String getDescription() {
        return description.getText();
    }

    public String getDuree() {
        return duree.getText();
    }

    public Label getIntituleErreur() {
        return intituleErreur;
    }

    public Label getDescriptionErreur() {
        return descriptionErreur;
    }
    public Label getDureeErreur() {
        return dureeErreur;
    }

    public Label getIntituleErreur1() {
        return intituleErreur1;
    }
   
    
    

    public AjoutModule() {
     titre = "Ajouter un module";
     initialisation(); 
     titre();
    }
    
     public void titre(){
        Text texteDetail = new Text(titre);
        texteDetail.setFont(Font.font("Arial", FontWeight.BOLD,30));
        this.setMargin(texteDetail, new Insets(0, 0, 80, -100));
        this.add(texteDetail, 0, 0);
       
    } 
    public void initialisation(){
        Label intitul = new Label("Intitulé:");
        intitule = new TextField();
        this.add(intitul,0, 1);
        this.add(intitule, 0, 2);
        intituleErreur = new Label("Veuillez re-saisir l'intitulé ");
        this.add(intituleErreur,1,2);
        intituleErreur1 = new Label("L'intitule de formation existe deja !");
        this.add(intituleErreur1,1,2);
        this.setMargin(intitul, new Insets(50, 0, 0,0));

        Label des = new Label("Description:");
        description = new TextField();
        description.setPrefSize(200, 120);
        this.add(description, 0, 4);
        descriptionErreur = new Label("Veuillez re-saisir ce champ ");
        this.add(descriptionErreur,1,4);
        this.add(des, 0, 3);
        this.setMargin(des, new Insets(20, 0, 0,0));
       
        Label dur = new Label("Durée:");
        duree = new TextField();
        duree.setMaxWidth(80);
        this.add(duree, 0, 6);
        dureeErreur = new Label("Veuillez saisir un entier ");
        this.add(dureeErreur,1,6);
        this.add(dur, 0, 5);
        this.setMargin(dur, new Insets(20, 0, 0,0));
        
        
        submit = new Button("Ajouter");
        this.add(submit, 0, 7);
        this.setMargin(submit, new Insets(20, 0, 0,0));

       
        Button clear = new Button("Annuler");
        this.add(clear, 0, 7);
        this.setMargin(clear, new Insets(20, 0, 0,80));
        
       
        this.setPadding(new Insets(0, 0, 0, 100));
        //this.setGridLinesVisible(true);
        
        ColumnConstraints cc1 = new ColumnConstraints();
        cc1.setMinWidth(400);
        this.getColumnConstraints().addAll(cc1);
    
    }  
}
