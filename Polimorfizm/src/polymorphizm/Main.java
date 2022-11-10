package polymorphizm;

public class Main {

	public static void main(String[] args) {

		Employee vahit=new Employee("vahit","camlı");
		Employee mert=new Employee("mert", "camlı", 5000);
		Engineer yusuf=new Engineer("yusuf","emre",12000);
		Engineer engin=new Engineer("engin","demir",2000);
		System.out.println("----------");
		vahit.infoBox();
		mert.infoBox();
		yusuf.infoBox();
		engin.infoBox();
	}

}
