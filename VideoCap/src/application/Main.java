package application;
	
import org.opencv.core.Core;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
	
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Deneme.fxml"));
			BorderPane root = (BorderPane) loader.load();
			Scene scene=new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("JavaFX meets OpenCV");
			primaryStage.setScene(scene);
			primaryStage.show();
			VideoController controller = loader.getController();
			primaryStage.setOnCloseRequest((new EventHandler<WindowEvent>()
			{

				@Override
				public void handle(WindowEvent we) 
				{
					
					controller.setClosed();
					
				}
				
			}));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
		
	}
	
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		launch(args);
	}
}
