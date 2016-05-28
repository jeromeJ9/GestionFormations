package view;

import java.util.List;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import modele.Module;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.text.TextAlignment;

public class LesModules extends GridPane{
    private List<Module> lesModules;
    private String titre;
   

    public LesModules(String titre) {
        this.titre = titre;
        titre();
    }

    public void setLesModules(List<Module> lesModules) {
        this.lesModules = lesModules;
    }

  
    
    public void titre(){
        Text texteDetail = new Text(titre);
        texteDetail.setFont(Font.font("Arial", FontWeight.BOLD,30));
        this.setMargin(texteDetail, new Insets(15, 0, 0, 0));  
        this.add(texteDetail, 1, 0);
        Text blank = new Text("  ");
        this.add(blank, 1, 1);
        //this.setGridLinesVisible(true);
    } 

    public void initialisation(){
             
        int i =2;
        for(Module unModule : lesModules){
            Label blanck = new Label("  ");
            blanck.setStyle("-fx-background-color: #F4F4F4;");
            blanck.setMinWidth(20);
            blanck.setMinHeight(40);
            GridPane.setHalignment(blanck, HPos.RIGHT);
            this.add( blanck, 0, i);
            //this.setMargin(blanck, new Insets(10, 0,10, 0));
           
            Text intitule = new Text(unModule.getIntitule());
            intitule.setFont(Font.font("Arial", FontWeight.NORMAL,20));
            this.setMargin(intitule, new Insets(15, 0, 0, 15));
            this.add(intitule, 1, i+1);
            
            Text description = new Text(unModule.getDescription());
            description.setTextAlignment(TextAlignment.JUSTIFY);
            description.setWrappingWidth(250);
            description.setFont(Font.font("Arial", FontWeight.NORMAL,15));
            this.setMargin(description, new Insets(10, 20, 0, 25));
            this.add(description, 1, i+2);
            
            Label soulign = new Label("");
            soulign.setMinWidth(200);
            soulign.setStyle("-fx-border-width: 0 0 1 0;-fx-border-color: #353B56 ;");
            this.setMargin(soulign, new Insets(0, 0, -9, 20));
            this.add(soulign, 1, i+3);
            
            Text nbJours = new Text(Integer.toString(unModule.getNb_jour())+" jours");
            this.setMargin(nbJours, new Insets(10, 0, 0, -30));
            this.add(nbJours, 2, i+3);
            
           
            i += 4;
            
            
        }
       Region r = new Region();
        r.setMaxWidth(8);
        GridPane.setHalignment(r, HPos.RIGHT);
        GridPane.setConstraints(r, 0, 1, 1, Integer.MAX_VALUE);
        this.getChildren().set(1, r); 
        r.setStyle("-fx-background-color:#787500 ");
        
                
    }
}
