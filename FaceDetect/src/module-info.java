module FaceDetect {
	requires javafx.controls;
	requires javafx.fxml;
	requires opencv;
	requires javafx.base;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.swing;
	
	opens application to javafx.graphics, javafx.fxml;
}
