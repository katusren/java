package chapter08;

import java.util.Scanner;

public class ExampleMain {

	public static void main(String[] args) {

		// Example_01 obj1 = new CalPlus();
		// Example_01 obj2 = new CalMinus();

		// obj1.getResult(15, 15);
		// obj2.getResult(30, 15);

		Scanner scar = new Scanner(System.in);

		System.out.print("정수 A를 입력하세요: ");
		int a = scar.nextInt();
		System.out.print("정수 B를 입력하세요: ");
		int b = scar.nextInt();

		System.out.println("두 수의 합: " + calc(new CalPlus(), a, b));
		System.out.println("두 수의 차: " + calc(new CalMinus(), a, b));

	}

	public static int calc(Example_01 c1, int a, int b) {

		return c1.getResult(a, b);
	}

}
