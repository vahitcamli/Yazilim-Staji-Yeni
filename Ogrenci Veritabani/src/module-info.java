module OrnekProje {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.base;
	opens model to javafx.base ,javafx.graphics, javafx.fxml;
    
    
	opens application to javafx.graphics, javafx.fxml;
}
