package Chapter05;

import javax.swing.JOptionPane;

public class FuncTest_02 {

	// 메서드
	// 매개변수 : num1,num2
	public void sum(int num1, int num2) {
		int sum = num1 + num2; // 위에서 매개변수 선언
		System.out.println("두 수의 핪 : " + sum);

	}// method

	public static void main(String[] args) {

		int a, b;

		a = Integer.parseInt(JOptionPane.showInputDialog("값1"));
		b = Integer.parseInt(JOptionPane.showInputDialog("값2"));

		/*
		 * int sum = a + b; System.out.println("두 수의 핪 : " + sum);
		 */

		// FuncTest_02의 객체 생성
		FuncTest_02 obj = new FuncTest_02();
		obj.sum(a, b);

	}

}
