package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
	@FXML
	TextField nametxtfield;
	
	private Stage stage;
	private Scene scene;
	private	Parent root;
	
	public void login(ActionEvent event) throws IOException {
		
			String username = nametxtfield.getText();
			FXMLLoader loader=new FXMLLoader(getClass().getResource("Childform.fxml"));
			root=loader.load();
			
			ChildController childController= loader.getController();
			childController.displayName(username);		
			stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
			
							
	}
		
	}

