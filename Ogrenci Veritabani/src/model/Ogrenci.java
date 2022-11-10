package model;

public class Ogrenci extends Ders{
	
	public Ogrenci(String ogrenciAd,String ogrenciYas, String okulAdi, String dersAdi) {
		super(okulAdi, dersAdi);	
		this.ogrenciAd=ogrenciAd;
		this.ogrenciYas=ogrenciYas;
		// TODO Auto-generated constructor stub
	}

	private String ogrenciAd;
	private String ogrenciYas;


	public String getOgrenciYas() {
		return ogrenciYas;
	}

	public void setOgrenciYas(String ogrenciYas) {
		this.ogrenciYas = ogrenciYas;
	}

	public String getOgrenciAd() {
		return ogrenciAd;
	}

	public void setOgrenciAdi(String ogrenciAd) {
		this.ogrenciAd = ogrenciAd;
	}
}
