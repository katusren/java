package chapter07;

public class Company_06 {

	// 객체를 단 하나만 생성하는 클래스
	private static Company_06 instance = new Company_06();

	// 일반적인 객체 생성
	public Company_06() {

	}

	public static Company_06 getInstance() {

		// 예외처리 -> 생성된 객체가 없으면 객체 생성
		if (instance == null) {
			instance = new Company_06();
		}
		return instance;
	}
}
