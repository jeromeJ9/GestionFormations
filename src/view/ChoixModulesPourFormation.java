package view;

import java.util.List;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import modele.Module;

public class ChoixModulesPourFormation extends GridPane{
    
    private List<Module> lesModules;
    private String titre;
    private CheckBox[] check;
    private int maxIdModule;
    private Button newModule;
   

    public ChoixModulesPourFormation() {
        this.titre = "Choix du module";
        titre();
    }

    public Button getNewModule() {
        return newModule;
    }
    
    public void setMaxIdModule(int maxIdModule) {
        this.maxIdModule = maxIdModule;
    }
    
    public void setLesModules(List<Module> lesModules) {
        this.lesModules = lesModules;
    }

    public CheckBox[] getCheck() {
        return check;
    }

    public void setCheck(CheckBox[] check) {
        this.check = check;
    }

   
    
   
    
    public void titre(){
        Text texteDetail = new Text(titre);
        texteDetail.setFont(Font.font("Arial", FontWeight.BOLD,30));
        this.add(texteDetail, 1, 0);
        Text blank = new Text("  ");
        this.add(blank, 1, 1);
        //this.setGridLinesVisible(true);
    } 

    public void initialisation(){
        check = new CheckBox[maxIdModule+1];    
        int i =2;
        for(Module unModule : lesModules){
            Label blanck = new Label("  ");
            blanck.setStyle("-fx-background-color: #F4F4F4;");
            blanck.setMinWidth(20);
            blanck.setMinHeight(20);
            GridPane.setHalignment(blanck, HPos.RIGHT);
            this.add( blanck, 0, i);
            
           
            Text intitule = new Text(unModule.getIntitule());
            intitule.setFont(Font.font("Arial", FontWeight.NORMAL,20));
            this.setMargin(intitule, new Insets(0, 0, 0, 25));
            this.add(intitule, 1, i+1);
            
            Text description = new Text(unModule.getDescription());
            description.setTextAlignment(TextAlignment.JUSTIFY);
            description.setWrappingWidth(250);
            description.setFont(Font.font("Arial", FontWeight.NORMAL,15));
            this.setMargin(description, new Insets(5, 20, 0, 40));
            this.add(description, 1, i+2);
            
            Label soulign = new Label("");
            soulign.setMinWidth(200);
            soulign.setStyle("-fx-border-width: 0 0 1 0;-fx-border-color: #353B56 ;");
            this.setMargin(soulign, new Insets(0, 0, 0, 20));
            //this.add(soulign, 1, i+3);
            
            Text nbJours = new Text(Integer.toString(unModule.getNb_jour())+" jours");
            nbJours.setFont(Font.font("Arial", FontWeight.NORMAL,15));
            this.setMargin(nbJours, new Insets(0, 0, 10, 40));
            this.add(nbJours, 1, i+3);
            
            check[unModule.getId()] = new CheckBox();
            this.add(check[unModule.getId()],1,i+1);
           
            i += 4;
            
            
        }
        newModule = new Button("Nouveau module");
        this.add(newModule, 0, i);
                
    }
    
}
