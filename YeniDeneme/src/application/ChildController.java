package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ChildController {

	@FXML
	Label namelabel;
	
	public void displayName(String username) {
		namelabel.setText("Hello "+username);
	}
}
