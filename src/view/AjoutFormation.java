package view;

import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import modele.Module;


public class AjoutFormation extends GridPane{
    private Button submit;
    private Button clear;
    private Button valide;
    private TextField intitule;
    private TextField description;
    private String intituleS;
    private String descriptionS;
    private String titre = "Ajouter une formation";
    public static List<Module> listeProvisoireModules;

    public Button getSubmit() {
        return submit;
    } 

    public Button getValide() {
        return valide;
    }
    
    public TextField getIntituleText(){
        return intitule;
    }
    public TextField getDescriptionText(){
        return description;
    }
    public String getIntitule() {
        return intitule.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public void setListeProvisoireModules(List<Module> module) {
        listeProvisoireModules= module;
    }

    public List<Module> getListeProvisoireModules() {
        return listeProvisoireModules;
    }

    public void setIntituleS(String intituleS) {
        this.intituleS = intituleS;
    }

    public void setDescriptionS(String descriptionS) {
        this.descriptionS = descriptionS;
    }

    public void setIntituleString(TextField intitule) {
        this.intitule = intitule;
    }

    public Button getClear() {
        return clear;
    }
    
    public void setDescription(TextField description) {
        this.description = description;
    }

    public AjoutFormation(String intitule, String description) {
        System.out.println("view.AjoutFormation.<init>()"+ intitule);
        this.intituleS  = intitule;
        this.descriptionS = description;
        titre();
       
    }

    public AjoutFormation() {
        titre();
      
    }
    
      

    
    
     public void titre(){
        Text texteDetail = new Text(titre);
        texteDetail.setFont(Font.font("Arial", FontWeight.BOLD,30));
        this.setMargin(texteDetail, new Insets(0, 0, 30, -100));
        this.add(texteDetail, 0, 0);
       
    }
    
    
    public void initialisation(){
        Label intitul = new Label("Intitulé:");
        intitule = new TextField(intituleS);
        this.add(intitul,0, 1);
        this.add(intitule, 0, 2);
        this.setMargin(intitul, new Insets(50, 0, 0,0));

        Label des = new Label("Description:");
        description = new TextField(descriptionS);
        description.setPrefSize(200, 120);
        this.add(description, 0, 4);
        this.add(des, 0, 3);
        this.setMargin(des, new Insets(20, 0, 0,0));
       
        
        
        submit = new Button("Ajouter un/des module(s)");
        this.add(submit, 0, 7);
        this.setMargin(submit, new Insets(20, 0, 0,0));

       
        clear = new Button("Annuler");
        this.add(clear, 0, 7);
        this.setMargin(clear, new Insets(20, 0, 0,210));
        
       
        this.setPadding(new Insets(0, 0, 0, 100));
        //this.setGridLinesVisible(true);
        
        ColumnConstraints cc1 = new ColumnConstraints();
        cc1.setMinWidth(400);
        this.getColumnConstraints().addAll(cc1);
        //this.setGridLinesVisible(true);
    }  
   
    public void afficheModuleSelec(){
        Label titre = new Label("Modules selectionnés :");
        titre.setFont(Font.font("Arial", FontWeight.NORMAL,20));
        this.add(titre, 0, 8);
    }
    
    public void moduleSelect(){
      
        int i =11;
        int comt = 0;
        
        for(Module unModule : listeProvisoireModules){
           
           comt += unModule.getNb_jour();
            Text intitule = new Text(unModule.getIntitule());
            intitule.setFont(Font.font("Arial", FontWeight.NORMAL,20));
            this.setMargin(intitule, new Insets(15, 0, 0, 15));
            this.add(intitule, 0, i);
            i++;
        }
        
        Text comptJour = new Text("La duree de a formation sera de "+Integer.toString(comt)+" jours");
        comptJour.setFont(Font.font("Arial", FontWeight.NORMAL,16));
        this.add(comptJour, 0, 9);
        
        Text ligne = new Text("__________________________________________________");
        this.add(ligne, 0, 10);
        
        ColumnConstraints cc1 = new ColumnConstraints();
        cc1.setMinWidth(400);
        this.getColumnConstraints().addAll(cc1);
    
        valide = new Button("Valider la formation");
        this.add(valide, 0, i);
        this.setMargin(valide, new Insets(20, 0, 0,0));
        //if (listeProvisoireModules.size() == 0)
            //valide.setDisable(true);

       
        Button annule = new Button("Annuler");
        this.add(annule, 0, i);
        this.setMargin(annule, new Insets(20, 0, 0,210));
    }
}
