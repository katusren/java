package chapter08;

public class TV extends Appliance {

	public TV(String brand) {
		super(brand);
	}

	@Override
	void turnOff() {
		super.turnOff();
		System.out.println("TV가 종료됩니다.");
	}

	@Override
	void turnOn() {
		super.turnOn(); // 부모 동작 유지
		System.out.println("TV를 킵니다.");
	}

}
