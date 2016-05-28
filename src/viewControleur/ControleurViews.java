package viewControleur;

import java.io.File;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ControleurViews {
    private Stage stage;
    public static BorderPane borderPane;
    

    public ControleurViews(Stage stage)  {
        this.stage = stage;
    }
    public ControleurViews()  {
    }
                 
    public void initialisation() throws SQLException{   
        stage.setTitle("__  Agriote  __  Ecole de formation");
        borderPane = new BorderPane();
        afficheLesFormations();
        
        //#############  MENU
        MenuBar menubar = new MenuBar();
            Menu menu = new Menu("Affichage");
                MenuItem add0 = new MenuItem("formations");
                add0.setOnAction((ActionEvent t) -> {afficheLesFormations();});
                MenuItem add = new MenuItem("Modules");
                add.setOnAction((ActionEvent t) -> {affichageLesModules();});
                menu.getItems().addAll(add0, add);
            
            Menu gestion = new Menu("Gestion");
                MenuItem add1 = new MenuItem("Ajout d'une formation");
                add1.setOnAction((ActionEvent t) -> { afficheAjoutFormation(); });
                MenuItem add2 = new MenuItem("Ajout d'un module");
                add2.setOnAction((ActionEvent t) -> { afficheAjoutModule(); });
                gestion.getItems().addAll(add1,add2);

            Menu aide = new Menu("?");

        menubar.getMenus().addAll(menu, gestion, aide);
        menubar.setStyle("-fx-background-color: white; -fx-effect: dropshadow( one-pass-box , #585700 , 5,0.9,0,1 );");
      
        
        VBox box = new VBox(50);
        box.setStyle("-fx-padding: 0 0 0 0; -fx-background-color: #787500; ");
   
        File file = new File("src/images/logo.png");
        Image image = new Image(file.toURI().toString());
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setTranslateX(300);
        iv1.setTranslateY(28);
       
        box.getChildren().addAll(iv1,menubar);
        borderPane.setTop(box);
                      
        Scene scene = new Scene (borderPane);
        stage.setScene(scene);
        //stage.setMaxWidth(1024);
        stage.setMinWidth(1100);
        stage.setMinHeight(500);
        //stage.setMaxHeight(768);
        stage.setResizable(false); 
        stage.show();
        
    }  
    
    public void afficheLesFormations(){
        LesFormationsPresenter lesFP = new LesFormationsPresenter();
    }
    public void afficheAjoutModule() {
        AjoutModulePresenter AMC = new AjoutModulePresenter();
    }
    public void affichageLesModules() {
        LesModulesPresenter dmP = new LesModulesPresenter();
    }
    public void afficheAjoutFormation() {
        AjoutFormationPresenter aMC = new AjoutFormationPresenter();
    }
}
