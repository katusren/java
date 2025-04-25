package chapter09;

public class Phone {

	public String owner;

	// 상속시 부모의 생성자를 사용
	public Phone(String owner) {
		this.owner = owner;
	}

	public void turnOn() {
		System.out.println("폰 전원을 켭니다");
	}

	public void turnOff() {
		System.out.println("폰 전원을 끕니다");
	}
}
