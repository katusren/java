package chapter06;

public class CarMain {

	public static void main(String[] args) {

		Car_04 car = new Car_04();

		String company = car.company;
		String model = car.model;
		String color = car.color;
		int MaxSpeed = car.maxSpeed;
		int speed = car.speed;

		System.out.println("제작회사: " + company);
		System.out.println("모델명: " + model);
		System.out.println("색깔: " + color);
		System.out.println("최고속도: " + MaxSpeed);
		System.out.println("현재속도: " + speed);

		car.speed = 60;

		System.out.println("변경된 현재속도: " + car.speed);

	}

}
