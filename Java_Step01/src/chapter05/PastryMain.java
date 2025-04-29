package Chapter05;

public class PastryMain {

	public static void main(String[] args) {

		// 생성자를 통해서 객체 생성
		Pastry_09 bread = new Pastry_09();

		// stack 영역
		/*
		 * bread.makeBread(); System.out.println("-----------------------");
		 * bread.makeBread(2); System.out.println("-----------------------");
		 * bread.makeBread(3, "크림빵");
		 */
		bread.order();
	}

}
