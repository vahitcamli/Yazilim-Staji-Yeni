package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Ogrenci;
import model.Okul;
import model.Ders;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
import javafx.scene.Parent;

public class SampleController {

	String txt_adi, txt_okulu, txt_dersi,txt_yasi;
	String comboBoxDeger;
	int otomatikAtama = 1, i, selectedId;

	private ObservableList<Ogrenci> siteList = FXCollections.observableArrayList();
	private ObservableList<String> comboBoxList = FXCollections.observableArrayList("Genel Arama", "İsme göre",
			"Yaşa göre", "Okula göre", "Derse göre");
	private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
	private ObservableList<Ogrenci> filtre = FXCollections.observableArrayList();

	@FXML
	private TableView<Ogrenci> tablo, tablo2;

	@FXML
	private TableColumn<Ogrenci, String> okulAdi;

	@FXML
	private TableColumn<Ogrenci, String> ogrenciYas;

	@FXML
	private TableColumn<Ogrenci, String> dersAdi;

	@FXML
	private TableColumn<Ogrenci, String> ogrenciAd;

	@FXML
	private TextField txt_ad, txt_filtre, txt_okul, txt_ders, txt_yas;

	@FXML
	private ComboBox<String> comboBoxFiltre;

	@FXML
	private PieChart pieChart;

	@FXML
	public void comboBoxFiltre(ActionEvent event) {
		comboBoxDeger = comboBoxFiltre.getValue();
	}

	@FXML
	public void Initialize() {

		if (otomatikAtama == 1) {
			comboBoxFiltre.setItems(comboBoxList);
			filtre.add(new Ogrenci("ender", "19", "SAÜ", "fizik"));
			filtre.add(new Ogrenci("ahmet", "20", "İTÜ", "kimya"));
			filtre.add(new Ogrenci("tamer", "21", "ODTÜ", "biyoloji"));
			filtre.add(new Ogrenci("kerem", "23", "PAÜ", "matematik"));
			filtre.add(new Ogrenci("mahmut", "22", "SAÜ", "matematik"));
			filtre.add(new Ogrenci("hüseyin", "50", "İTÜ", "metalürji"));
			filtre.add(new Ogrenci("murat", "26", "PAÜ", "kimya"));
			siteList.addAll(filtre);
			pieChartData.add(new PieChart.Data("ender", 12));
			pieChartData.add(new PieChart.Data("ahmet", 13));
			pieChartData.add(new PieChart.Data("tamer", 14));
			pieChartData.add(new PieChart.Data("kerem", 14));
			pieChartData.add(new PieChart.Data("mahmut", 13));
			pieChartData.add(new PieChart.Data("hüseyin", 50));
			pieChartData.add(new PieChart.Data("murat", 14));
			comboBoxFiltre.getSelectionModel().selectFirst();
			comboBoxDeger = comboBoxFiltre.getValue();
			otomatikAtama = 0;
		}

		okulAdi.setCellValueFactory(new PropertyValueFactory<Ogrenci, String>("okulAdi"));
		dersAdi.setCellValueFactory(new PropertyValueFactory<Ogrenci, String>("dersAdi"));
		ogrenciAd.setCellValueFactory(new PropertyValueFactory<Ogrenci, String>("ogrenciAd"));
		ogrenciYas.setCellValueFactory(new PropertyValueFactory<Ogrenci, String>("ogrenciYas"));
		tablo2.setItems(filtre);
		txt_filtre.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				updateFilteredData();
				// TODO Auto-generated method stub

			}

		});

	}

	private void updateFilteredData() {
		filtre.clear();

		for (Ogrenci p : siteList) {
			if (matchesFilter(p)) {
				filtre.add(p);
			}
		}

		reapplyTableSortOrder();
	}

	private boolean matchesFilter(Ogrenci ogrenci) {
		String filterString = txt_filtre.getText();
		if (filterString == null || filterString.isEmpty()) {
			return true;
		}
		String lowerCaseFilterString = filterString.toLowerCase();
		if (comboBoxDeger == "Genel Arama") {
			if (ogrenci.getOkulAdi().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
				return true;
			} else if (ogrenci.getOgrenciAd().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
				return true;
			} else if (ogrenci.getDersAdi().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
				return true;
			} else if (ogrenci.getOgrenciYas().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
				return true;
			}
		}

		else if (comboBoxDeger == "Okula göre") {
			if (ogrenci.getOkulAdi().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
				return true;
			}
		} else if (comboBoxDeger == "İsme göre") {
			if (ogrenci.getOgrenciAd().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
				return true;
			}
		} else if (comboBoxDeger == "Yaşa göre") {
			if (ogrenci.getOgrenciYas().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
				return true;
			}
		} else if (comboBoxDeger == "Derse göre") {
			if (ogrenci.getDersAdi().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
				return true;
			}
		}
		return false;
	}

	private void reapplyTableSortOrder() {
		ArrayList<TableColumn<Ogrenci, ?>> sortOrder = new ArrayList<>(tablo2.getSortOrder());
		tablo2.getSortOrder().clear();
		tablo2.getSortOrder().addAll(sortOrder);

	}

	public void btnEkle(ActionEvent actionevent) {

		txt_adi = txt_ad.getText().toString();
		txt_okulu = txt_okul.getText().toString();
		txt_dersi = txt_ders.getText().toString();
		txt_yasi = txt_yas.getText().toString();

		try {
			filtre.add(new Ogrenci(txt_adi, txt_yasi, txt_okulu, txt_dersi));
			siteList.clear();
			siteList.addAll(filtre);
			pieChartData.add(new PieChart.Data(txt_adi, Integer.parseInt(txt_yasi)));

		} catch (Exception e) {
			// TODO: handle exception
		}

		okulAdi.setCellValueFactory(new PropertyValueFactory<>("okulAdi"));
		ogrenciAd.setCellValueFactory(new PropertyValueFactory<>("ogrenciAd"));
		dersAdi.setCellValueFactory(new PropertyValueFactory<>("dersAdi"));
		ogrenciYas.setCellValueFactory(new PropertyValueFactory<>("ogrenciYas"));
		tablo2.setItems(siteList);
		txt_ad.clear();
		txt_okul.clear();
		txt_ders.clear();
		txt_yas.clear();
		Initialize();

	}

	public void btnSil(ActionEvent actionevent) {

		Ogrenci person = tablo2.getSelectionModel().getSelectedItem();
		if (filtre.contains(person) == true) {
			filtre.remove(person);
		}
		if (siteList.contains(person) == true) {
			siteList.remove(person);

		}

	}

	public void btnSirala(ActionEvent actionevent) {

		try {
			okulAdi.setSortType(TableColumn.SortType.ASCENDING);
			tablo2.getSortOrder().add(okulAdi);
			tablo2.sort();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void btnAzalan(ActionEvent actionevent) {

		try {
			okulAdi.setSortType(TableColumn.SortType.DESCENDING);
			tablo2.getSortOrder().add(okulAdi);
			tablo2.sort();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void btnPieChart(ActionEvent actionevent) {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PieChart.fxml"));

			fxmlLoader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(new Group());
			final PieChart chart = new PieChart(pieChartData);
			chart.setTitle("yas dagilimi");
			((Group) scene.getRoot()).getChildren().add(chart);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
}

