package override;

public class MotorCycleCompanyManager extends CarCompanyManager {

		public String getInfoCar(String stantName) {
			if (carName != null && carModel != null && carEnergy != null && carCountry != null)
	            return "----------\n< " + stantName + " Stant Motosiklet Tanıtımı >\n----------\n-> Motosiklet Markası: " + super.carName + "\n-> Motosiklet Modeli: " +
	                    carModel + "\n-> Motosiklet Kullandığı Yakıt: " + super.carEnergy + "\n-> Motosiklet Üretildiği Ülke: " + super.carCountry +
	                    "\n-> Motosiklet Üretildiği Yıl: " + super.yearOfProduction + "\n-> Motosiklet Fiyatı: " + super.carMoney + " TL\n----------";
	        return "----------\n< Motosiklet Bulunamadı >\n----------\n-> Aradığınız Kriterlerde Stant Üzerinde Araç Bulunmamaktadır.\n----------";
		}
		public String getInfoCar(String stantName, String alert){
	        if (carName != null && carModel != null && carEnergy != null && carCountry != null)
	            return "----------\n< " + stantName + " Stant Motosiklet Tanıtımı >\n----------\n-> Motosiklet Markası: " + super.carName + "\n-> Motosiklet Modeli: " +
	                    carModel + "\n-> Motosiklet Kullandığı Yakıt: " + super.carEnergy + "\n-> Motosiklet Üretildiği Ülke: " + super.carCountry +
	                    "\n-> Motosiklet Üretildiği Yıl: " + super.yearOfProduction + "\n-> Motosiklet Fiyatı: " + super.carMoney + " TL\n----------"+"\n-> "+alert+
	                    "\n----------";
	        return "----------\n< Motosiklet Bulunamadı >\n----------\n-> Aradığınız Kriterlerde Stant Üzerinde Araç Bulunmamaktadır.\n----------";
	        
}
		public String getInfoCar(String stantName, int year){
	        if (carName != null && carModel != null && carEnergy != null && carCountry != null)
	            if(super.yearOfProduction>year)
	        return "----------\n< " + stantName + " Stant Motosiklet Tanıtımı >\n----------\n-> Motosiklet Markası: " + super.carName + "\n-> Motosiklet Modeli: " +
	            carModel + "\n-> Motosiklet Kullandığı Yakıt: " + super.carEnergy + "\n-> Motosiklet Üretildiği Ülke: " + super.carCountry +
	            "\n-> Motosiklet Üretildiği Yıl: " + super.yearOfProduction + "\n-> Motosiklet Fiyatı: " + super.carMoney + " TL\n----------"+"\n-> İndirim Uygulanmadı."
	            		+ "\n----------";
	            else {
	            	double discount,value;
	            	discount=super.carMoney*0.12;
	            	super.carMoney=discount;
	            	value=super.carMoney+discount;
	            	return "----------\n< " + stantName + " Stant Motosiklet Tanıtımı >\n----------\n-> Motosiklet Markası: " + super.carName + "\n-> Motosiklet Modeli: " +
                    carModel + "\n-> Motosiklet Kullandığı Yakıt: " + super.carEnergy + "\n-> Motosiklet Üretildiği Ülke: " + super.carCountry +
                    "\n-> Motosiklet Üretildiği Yıl: " + super.yearOfProduction + "\n-> Motosiklet Fiyatı: " + super.carMoney + " TL\n----------"+"\n-> Tebrikler, "+
                    discount +" Değerinde Bir İndirim Uygulandı.\n-> İndirimsiz Fiyatı: "+value+" TL\n----------";
	            }
	        return "----------\n< Motosiklet Bulunamadı >\n----------\n-> Aradığınız Kriterlerde Stant Üzerinde Araç Bulunmamaktadır.\n----------";
}
}