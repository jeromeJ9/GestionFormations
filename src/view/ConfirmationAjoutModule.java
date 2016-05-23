package view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class ConfirmationAjoutModule extends GridPane{
    private String intitule;
    private String description;
    private String duree;
    private Button submit;
    private Button modif;

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Button getSubmit() {
        return submit;
    }

    public Button getModif() {
        return modif;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    
    
  
    
    
    public void initialisation(){
        Text blank = new Text("  ");
        this.add(blank, 0, 0);
        Label blanck = new Label("  ");
        blanck.setStyle("-fx-background-color: #F4F4F4;");
        blanck.setMinWidth(20);
        blanck.setMinHeight(50);
        GridPane.setHalignment(blanck, HPos.RIGHT);
        this.add( blanck, 0, 1);
        //this.setMargin(blanck, new Insets(100, 0, 0, 0));

        Text intitule = new Text(this.intitule);
        intitule.setFont(Font.font("Arial", FontWeight.NORMAL,20));
        this.setMargin(intitule, new Insets(0, 0, 0, 10));
        this.add(intitule, 1, 2);

        Text description = new Text(this.description);
        description.setTextAlignment(TextAlignment.JUSTIFY);
        description.setWrappingWidth(250);
        description.setFont(Font.font("Arial", FontWeight.NORMAL,15));
        this.setMargin(description, new Insets(10, 0, 0, 25));
        this.add(description, 1, 3);

        Text nbJours = new Text(duree+" jours");
        this.setMargin(nbJours, new Insets(10, 0, 0, 25));
        this.add(nbJours, 2, 3);
        
        this.setPadding(new Insets(200, 0, 0, 15));
        
        submit = new Button("Confirmer");
        this.add(submit, 1, 4);
        this.setMargin(submit, new Insets(50, 0, 0, 10));
        modif = new Button("Modifier");
        this.add(modif, 1, 4);
        this.setMargin(modif, new Insets(50, 0, 0, 105));
        
    }
}
