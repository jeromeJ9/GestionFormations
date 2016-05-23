
package view;

import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import modele.Module;


public class DetailUneFormation extends GridPane{
    private List<Module> listeModules;
    private Button retour;

    public Button getRetour() {
        return retour;
    }
    
    public void setListeModules(List<Module> listeModules) {
        this.listeModules = listeModules;
    }
    
    public void initialisation(){
          int i=1;
            for (Module unMod : listeModules){
               
                Text intitule = new Text(unMod.getIntitule());
                intitule.setFont(Font.font("Arial", FontWeight.NORMAL,20));
                this.setMargin(intitule, new Insets(10, 20, 0, 20));
                
                Text description = new Text(unMod.getDescription());
                description.setWrappingWidth(310);
                description.setFont(Font.font("Arial", FontWeight.NORMAL,15));
                this.setMargin(description, new Insets(0, 20, 0, 40));
                
                Text soulign = new Text("___________________");
                this.setMargin(soulign, new Insets(0, 0, 0, 110));
                this.add(intitule, 0, i);
                this.add(description, 0, i+1);
                this.add(soulign, 0, i+2);
               
              
                i +=3;
               
                  
            }
            /*
            retour = new Button("Retour a la liste");
            this.add(retour, 0 , i);
            this.setMargin(retour, new Insets(30, 0, 0, 70));
          */
      
          
    }
    
    
    
    
    
}
