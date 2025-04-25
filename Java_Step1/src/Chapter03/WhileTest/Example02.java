package Chapter03.WhileTest;

import javax.swing.JOptionPane;

public class Example02 {

	public static void main(String[] args) {
		// 팩토리얼 알고리즘

		/*
		 * 5! -> 5X4X3X2X1 => n! -> n*(n-1)*(n-2)*(n-3)*()n-4
		 */

		int number = Integer.parseInt(JOptionPane.showInputDialog("숫자를 입력해주세요"));
		int factorial = 1; // 곱셈에 대한 누적변수 이므로 1로 초기화

		// number = 1 이면 멈춤
		while (number > 0) {
			factorial *= number;// factorial = factorial*number;
			number--;
		} // w

		System.out.println("팩토리얼 결과 : " + factorial);

	}// m

}// c
