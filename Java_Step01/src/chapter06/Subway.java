package chapter06;

public class Subway {

	// 멤버변수

	int lineNumber;
	int passengerCount;
	int money;

	// 생성자 오버로딩()
	public Subway(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public Subway() {
		// TODO Auto-generated constructor stub
	}

	// 메서드
	public void take(int money) { // 승객이 낸돈
		this.money = money; // 버스 수입
		passengerCount++;
	}

	public void showinfo() {
		System.out.println(
				lineNumber + "번 지하철의 승객은 " + passengerCount + "명이고, 수입은 " + (money * passengerCount) + "원 입니다.");
	}
}
