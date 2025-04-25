package Chapter03.WhileTest;

import javax.swing.JOptionPane;

public class WhileTest_09 {

	public static void main(String[] args) {

		int num1;
		int num2;

		do {

			num1 = Integer.parseInt(JOptionPane.showInputDialog("OTP DB"));
			num2 = Integer.parseInt(JOptionPane.showInputDialog("OTP USER"));

			if (num1 == num2) {
				System.out.println("인증이 성공했습니다!");
			} else {
				System.out.println("인증이 실패했습니다. 다시 입력해주세요");
			}

		} while (num1 != num2);

	}// m

}// c