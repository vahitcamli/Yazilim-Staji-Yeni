package polymorphizm;

public class Employee {

	    //Değişken Tanımlanması:
	    private String ayrac ="-------------------";
	    private String name,surname,job;
	    private int salary,annualPermit;
	    // Bir çalışan oluşturmak için birden fazla yöntemimiz olabilir onları constructor metotlar ile tanımlayalım.
	    Employee(){
	        this(null,null);
	    }
	    Employee(String name,String surname){
	        this.name=name;
	        this.surname = surname;
	        this.job="Çalışan";
	        this.salary=2500;
	        this.annualPermit=14;
	    }
	    Employee(String name, String surname,int salary){
	        this.name=name;
	        this.surname=surname;
	        this.salary=salary;
	        this.annualPermit=14;
	        if(salary>3000){
	            this.job="Kıdemli Çalışan";
	            annualPermit+=3; // Kıdemli çalışan 3 gün daha fazla yıllık izine sahip olur.
	        }
	        else if(salary>0 && salary <3000){
	            this.job="Çalışan";
	        }
	        else {
	            this.job="Stajyer";
	            annualPermit=0; // Stajyer'in yıllık izni olmaz.
	        }
	    }
	    // Total bir fiyat belirterek maaşına zam yapmak.
	    public int makeRaise(int howMuch){
	        salary += howMuch;
	        return salary;
	    }
	    // Mevcut maaşına % oranında bir zam gerçekleştirmek.
	    public int makeRaise (double howMuch){
	        double money = (double) salary*howMuch;
	        makeRaise((int)money);
	        return  salary;
	    }
	    // Alt sınıflarda verileri güncellemek isteyebiliriz:
		
		 // Çalışan Bilgilerini Yazdırma İşlemi:
	    public void infoBox(){
	        System.out.println("< "+getJob()+" Bilgileri>\n"+ayrac+"\n-> Çalışan İsmi: "+name+"\n-> Çalışan Soyismi: "+surname+
	                "\n-> Görevi: "+getJob()+"\n-> Maaşı: "+getSalary()+" TL\n-> İzin Günü: "+getAnnualPermit()+" İş Günü\n"+ayrac);
	    }
	    public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		public int getAnnualPermit() {
			return annualPermit;
		}
		public void setAnnualPermit(int annualPermit) {
			this.annualPermit = annualPermit;
		}
		public void raiseInfo(){
	        System.out.println("< "+getJob()+" Zam Uygulaması >\n-> Yeni Verilecek Maaş: "+getSalary()+"TL \n"+ayrac);
	    }
}
