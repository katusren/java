package chapter05;

public class FuncTest_07 {

	public static void swap(int x, int y) {

		// x,y 교체
		int temp = x;
		x = y;
		y = temp;

		System.out.println("swap() 결과값 x: " + x + " , y : " + y);

	}// method

	public static void main(String[] args) {

		int a = 10;
		int b = 20;

		System.out.println("swap() 호출전 a : " + a + ", b : " + b);
		System.out.println("----------------------");

		swap(a, b); // call by Reference
		System.out.println("----------------------");
		System.out.println("swap() 호출후 a : " + a + ", b : " + b);

	}

}
