package chapter05;

import javax.swing.JOptionPane;

public class FuncTest_01 {

	// 메서드
	// 매개변수 : num1,num2
	// static 이 있으면 바로 사용 가능
	public static void sum(int num1, int num2) {
		int sum = num1 + num2; // 위에서 매개변수 선언
		System.out.println("두 수의 핪 : " + sum);

	}

	public static void main(String[] args) {

		int a, b;

		a = Integer.parseInt(JOptionPane.showInputDialog("값1"));
		b = Integer.parseInt(JOptionPane.showInputDialog("값2"));

		/*
		 * int sum = a + b; System.out.println("두 수의 핪 : " + sum);
		 */

		// 호출시 사용되는
		// 매개변수 a와 b는 실 값이 정의 되어있으므로
		// 실매개변수 라고 한다.
		sum(a, b);

	}

}
