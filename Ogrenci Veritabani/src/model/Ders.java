package model;

public class Ders extends Okul {

	private String dersAdi;

	public Ders(String okulAdi, String dersAdi) {
		super(okulAdi);
		this.dersAdi = dersAdi;
	}

	public String getDersAdi() {
		return dersAdi;
	}

	public void setDersAdi(String dersAdi) {
		this.dersAdi = dersAdi;
	}
}
