package override;

public class CarCompanyManager {
	    String carName,carModel,carEnergy,carCountry;
	    int yearOfProduction;
	    double carMoney;
	    public void addNewCar(String carName,String carModel, String carEnergy, String carCountry,int yearOfProduction, double carMoney){
	        this.carName = carName;
	        this.carModel = carModel;
	        this.carEnergy = carEnergy;
	        this.carCountry = carCountry;
	        this.yearOfProduction = yearOfProduction;
	        this.carMoney = carMoney;
	    }
	    public String getInfoCar(String stantName){
	        if(carName != null && carModel != null && carEnergy != null && carCountry != null)
	            return "----------\n< "+stantName+" Stant Araç Tanıtımı >\n----------\n-> Aracın Markası: "+carName+"\n-> Aracın Modeli: "+
	                    carModel+"\n-> Aracın Kullandığı Yakıt: "+carEnergy+"\n-> Aracın Üretildiği Ülke: "+carCountry +
	                    "\n-> Aracın Üretildiği Yıl: "+ yearOfProduction +"\n-> Aracın Fiyatı: "+carMoney+" TL\n----------";
	        return "----------\n< Araç Bulunamadı >\n----------\n-> Aradığınız Kriterlerde Stant Üzerinde Araç Bulunmamaktadır.\n----------";
	    }
}
