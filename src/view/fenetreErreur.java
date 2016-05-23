package view;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import viewControleur.ControleurViews;


public class fenetreErreur extends GridPane{

    public fenetreErreur() {

    
    
        Text erreur = new Text("Probleme reseau ");
        Text conseil = new Text("Veuillez ressayer\n"
                                + "ou joindre votre service technique");
                                
        erreur.setFont(Font.font("Arial", FontWeight.NORMAL,25));
        this.setMargin(erreur, new Insets(180, 0, 0, 380));
        this.add(erreur, 1, 1);
        conseil.setFont(Font.font("Arial", FontWeight.NORMAL,18));
        this.setMargin(conseil, new Insets(0, 0, 0, 380));
        this.add(conseil, 1, 2);
    }
    
}
