package chapter06;

public class StdInfo {

	// 멤버변수 = 필드
	public String studentName;
	public int grade;
	public int money;

	// 생성자 오버로딩()
	public StdInfo(String stdentName, int money) {
		this.studentName = stdentName;
		this.money = money;
	}

	// 버스
	public void takeBus(Bus bus) {
		bus.take(1400); // 버스회사의 수입
		this.money -= 1400; // 학생지출
	}

	// 지하철
	public void takeSubway(Subway subway) {
		subway.take(1800); // 지하철회사의 수입
		this.money -= 1800; // 학생지출
	}

	// 잔액
	public void showinfo() {
		System.out.println(studentName + "님의 남은 잔액은 " + money + "원 입니다.");
	}

}
