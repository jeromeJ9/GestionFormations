package viewControleur;

import javafx.scene.control.ScrollPane;
import view.fenetreErreur;


public class fenetreErreurPresenter {

    public fenetreErreurPresenter() {
        fenetreErreur view = new fenetreErreur();
        ScrollPane scrollaM = new ScrollPane(view);
        ControleurViews.borderPane.setCenter(scrollaM);
    }
    
    
}
