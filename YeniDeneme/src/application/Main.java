package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	Stage window;

	
	@Override
	public void start(Stage Stage) {
		
		 try {

			 Parent root=FXMLLoader.load(getClass().getResource("AnaFX.fxml"));
			Scene scene=new Scene(root);
			Stage.setScene(scene);
			Stage.show();

       } catch(Exception e) {

             e.printStackTrace();
       }
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
