package chapter07;

public class ComplayMain {

	public static void main(String[] args) {

		Company_06 company1 = new Company_06();
		Company_06 company2 = new Company_06();

		System.out.println(company1);
		System.out.println(company2);

		System.out.println("----------singleton-----------");

		// Data영역에 객체 생성
		Company_06 mycompany1 = Company_06.getInstance();
		Company_06 mycompany2 = Company_06.getInstance();

		System.out.println(mycompany1);
		System.out.println(mycompany2);
	}

}
