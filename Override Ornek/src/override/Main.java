package override;

public class Main {

	public static void main(String[] args) {

		CarCompanyManager carCompanyManager=new CarCompanyManager();
		carCompanyManager.addNewCar("ford", "transit", "benzin", "abd",2022, 234800);
		System.out.println(carCompanyManager.getInfoCar("Çağlayan"));
		
		MotorCycleCompanyManager motorCycleCompanyManager=new MotorCycleCompanyManager();
		motorCycleCompanyManager.addNewCar("Harley-Davidson","Fat Boy","Benzin","ABD",2021,369567);
		System.out.println(motorCycleCompanyManager.getInfoCar("SOA", "kdv dahil değildir"));
	}

}
