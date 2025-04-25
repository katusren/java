package Chapter03.WhileTest;

import javax.swing.JOptionPane;

public class WhileTest_10 {

	public static void main(String[] args) {

		int number;
		int sum = 0;

		do {
			number = Integer.parseInt(JOptionPane.showInputDialog("숫자를 입력하세요(0 입력시 종료) : "));
			sum += number;
		} while (number != 0);

		System.out.println("총합 : " + sum);
	}

}
