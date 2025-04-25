package chapter07;

public class Bank_03 {

	private String point; // 지점명
	private String tel; // 전화번호
	static float interest; // 이자율

	public Bank_03(String point, String tel) {
		this.point = point;
		this.tel = tel;
	}

	// 결과 출력 메서드
	public void getBank() {
		System.out.println("지점: " + point);
		System.out.println("전화번호: " + tel);
		System.out.println("이자율: " + interest);
	}
}
