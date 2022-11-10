package polymorphizm;

public class Engineer extends Employee {
	 // Birden fazla mühendis oluşturma yöntemimiz olabilir.
    Engineer(){
        super();
        setSalary(5000); // Bir Mühendisin maaşını minimum 7000 TL Olarak Tanımlayalım.
    }
    Engineer(String name,String surname){
        super(name,surname);
        setJob("Mühendis");
        setAnnualPermit(20);
        setSalary(5000);
    }
    Engineer(String name,String surname,int salary){
        super(name,surname);
        setSalary(salary);
        if(salary>7000){
            setJob("Kıdemli Mühendis");
            setAnnualPermit(25);
        }
        else if(salary>10000){
            setJob("Uzman Mühendis");
            setAnnualPermit(35);
        }
        else if(salary>=0){
            setJob("Stajyer Mühendis");
            setAnnualPermit(0);
        }
    }
    @Override
    public int makeRaise(double howMuch) {
        double money = (double) (getSalary()*howMuch)+250; // Mühendislere her yüzdesel zam uygulanmasında +250 TL'de ekstra zam uygulanmasını istiyoruz.
        makeRaise((int)money);
        return getSalary();
    }
}