package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
//import model.DataSource;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException{
		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
			BorderPane root = loader.load();
			SampleController controller = loader.getController();
			controller.Initialize();
			primaryStage.setTitle("ogrenci database");
			Scene scene = new Scene(root, 900, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		

	}

	public static void main(String[] args) {

		launch(args);
	}
}

/*
 * @Override public void init() throws Exception { // TODO Auto-generated method
 * stub super.init(); if(!DataSource.getInstance().veritabaniAc()){
 * System.out.println("veri taban� a��lmad�"); Platform.exit(); } else
 * System.out.println("veri taban� a��ld�"); }
 * 
 * @Override public void stop() throws Exception { // TODO Auto-generated method
 * stub super.stop(); DataSource.getInstance().veritabaniKapa(); }
 */
/*
 * public static void main(String[] args) { DataSource datasource= new
 * DataSource(); datasource.veritabaniAc();
 * 
 * ArrayList<Ogrenci> tumOgrenciler= datasource.ogrencileriGetir(); if
 * (tumOgrenciler==null) { System.out.println("ogrenci yok"); return; }
 * for(Ogrenci s : tumOgrenciler) { System.out.println("adi "+
 * s.getOgrenciAd()+" id "+s.getOgrenciID()); }
 * 
 * launch(args);
 * 
 * //datasource.veritabaniKapa(); } }
 */
