package chapter09;

// 단 하나라도 추상 메소드가 존재하면 추상 클래스 이다.
public abstract class Computer {

	// 추상 메소드 -> body 가 없음
	public abstract void display(); // 하위 클래스에서 구현하여 사용

	public abstract void typing();

	// 일반 메소드
	public void turnOn() {
		System.out.println("전원을 켭니다");
	}

	public void turnOff() {
		System.out.println("전원을 끕니다");
	}
}
