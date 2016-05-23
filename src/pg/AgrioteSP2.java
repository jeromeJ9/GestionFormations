package pg;

import viewControleur.ControleurViews;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;


public class AgrioteSP2 extends Application {
    
    /**
     *
     * @param primaryStage
     * @throws SQLException
     */
    @Override
    public void start(Stage primaryStage) throws SQLException{
        
      ControleurViews control = new ControleurViews(primaryStage);
      control.initialisation();
    }  
   
   
   
    public static void main(String[] args) {
            launch(args);
        }


   
}
