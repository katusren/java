package chapter06;

public class Bus {

	// 멤버변수

	int busNumber;
	int passengerCount;
	int money;

	// 생성자 오버로딩()
	public Bus(int busNumber) {
		this.busNumber = busNumber;
	}

	public Bus() {
		// TODO Auto-generated constructor stub
	}

	// 메서드
	public void take(int money) { // 승객이 낸돈
		this.money = money; // 버스 수입
		passengerCount++;
	}

	public void showinfo() {
		System.out
				.println(busNumber + "번 버스의 승객은 " + passengerCount + "명이고, 수입은 " + (money * passengerCount) + "원 입니다.");
	}

}
