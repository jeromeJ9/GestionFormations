package view;

import java.util.List;
import javafx.geometry.HPos;
import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import modele.Formation;



public class LesFormations extends GridPane{
    public List<Formation> listeFormations;
    private String titre;
    private Button[] bouton;
    private int nbMaxID;
    private Label[] blanck;
 
    
    public LesFormations() {
        this.titre = "Les Formations";
        titre();
    }
    public Button[] getBouton() {
        return bouton;
    }
    public Label[] getBlanck() {
        return blanck;
    }
    public void setListeFormations(List<Formation> listeFormations) {
        this.listeFormations = listeFormations;
    }
    public void setNbMaxID(int nbMaxID) {
        this.nbMaxID = nbMaxID;
    }
    
    public void titre(){
        Text texteDetail = new Text(titre);
        texteDetail.setFont(Font.font("Arial", FontWeight.BOLD,30));
        this.setMargin(texteDetail, new Insets(15, 0, 0, 0));        
        this.add(texteDetail, 1, 0);
        Text blank = new Text();
        this.add(blank,0,1);
         Text blank1 = new Text();
        this.add(blank1,0,2);
        Text blank2 = new Text();
        this.add(blank2,0,2);
    } 
    
    public void initialisation(){
        bouton = new Button[nbMaxID+1];
        blanck = new Label[nbMaxID+1];
        int i=3;
        int j =1;
            for (Formation uneForm : listeFormations){
                blanck[uneForm.getId()] = new Label("  ");
                blanck[uneForm.getId()].setStyle("-fx-background-color: #F4F4F4;");
                blanck[uneForm.getId()].setMinWidth(20);
                blanck[uneForm.getId()].setMinHeight(35);
                GridPane.setHalignment(blanck[uneForm.getId()], HPos.RIGHT);
                this.add( blanck[uneForm.getId()], 0, i);
            
                Text intitule = new Text(uneForm.getIntitule());
                intitule.setFont(Font.font("Arial", FontWeight.NORMAL,20));
                this.setMargin(intitule, new Insets(25, 0, 0, 20));
                
                Text description = new Text(uneForm.getDescription());
                description.setWrappingWidth(573);
                description.setTextAlignment(TextAlignment.JUSTIFY);
                description.setFont(Font.font("Arial", FontWeight.NORMAL,15));
                this.setMargin(description, new Insets(10, 20, 0, 40));
                
                Text nbJours = new Text("durée: "+uneForm.getNbJours()+" jours");
                nbJours.setFont(Font.font("Arial", FontWeight.NORMAL,15));
                this.setMargin(nbJours, new Insets(10, 0, 0, 40));
                Label soulign = new Label("");
                soulign.setMinWidth(350);
                soulign.setStyle("-fx-border-width: 1 0 0 0;-fx-border-color: #353B56 ;");
                this.setMargin(soulign, new Insets(-20, 0, 0, 20));
                
                
                this.add(intitule, 1, i+1);
                this.add(description, 1, i+2);
                this.add(nbJours, 1, i+3);
                this.add(soulign, 1, i+5);
                
           
                bouton[uneForm.getId()] = new Button("+ details"); 
                this.setMargin(bouton[uneForm.getId()], new Insets(0, 0, 0, 550));
                bouton[uneForm.getId()].setPadding(new Insets(1, 10, 1, 8));
                bouton[uneForm.getId()].setStyle("-fx-background-radius: 10;");
                this.add(this.bouton[uneForm.getId()],1,i+4);
                
                i +=5;
                j++;
            }
           
            ColumnConstraints cc1 = new ColumnConstraints();
          
            cc1.setHalignment(HPos.LEFT); 
            
            Region r1 = new Region();
            r1.setMaxWidth(8);
            GridPane.setHalignment(r1, HPos.RIGHT);
            GridPane.setConstraints(r1, 0, 3, 1, Integer.MAX_VALUE);
            this.getChildren().set(1, r1); 
            r1.setStyle("-fx-background-color:#787500 ");
            this.getChildren().set(1, r1); // this.getColumnConstraints().addAll(cc1);
        
    }
    
    public void contraintePourDetail( int position){
        this.setStyle("-fx-background-color: #E4E4D7; ");
        Region r = new Region();
        GridPane.setConstraints(r, 1, ((position)*5+4), 1, 5); 
        r.setStyle("-fx-background-color: #F4F4F4 ");
        this.getChildren().set(2, r);  
    }
}
