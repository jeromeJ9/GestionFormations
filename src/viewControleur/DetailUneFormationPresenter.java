package viewControleur;

import java.util.List;
import javafx.scene.control.ScrollPane;
import modele.Module;
import view.DetailUneFormation;



public class DetailUneFormationPresenter {
    private DetailUneFormation view;
    private List<Module> listeModules;
       

    public DetailUneFormationPresenter(List<Module> listeModules) {
        this.listeModules = listeModules;
        initView();
        dataForView();
    }

    
    private void initView() {
        view = new DetailUneFormation();
        ScrollPane scroll = new ScrollPane(view);
        ControleurViews.borderPane.setRight(scroll);
        scroll.setStyle("-fx-border-color: #F4F4F4;");
        
    }
    
    private void dataForView()  {
       
        view.setListeModules(listeModules);
        view.initialisation();
        //view.getRetour().setOnAction(e -> retourListeFormation() );
        
    }
/*
    private void retourListeFormation() {
        try {
            ControleurViews c = new ControleurViews();
            c.afficheLesFormations();
        } catch (Exception ex) {
            Logger.getLogger(DetailUneFormationPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
    
    
    
    
}
