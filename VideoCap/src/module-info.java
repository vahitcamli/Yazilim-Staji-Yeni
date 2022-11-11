module VideoCap {
	requires javafx.controls;
	requires javafx.fxml;
	requires opencv;
	requires javafx.base;
	requires java.xml.crypto;
	requires javafx.graphics;
	requires jdk.internal.vm.compiler;
	requires java.desktop;
	requires javafx.swing;
	
	opens application to javafx.graphics, javafx.fxml;
}
