package chapter07;

import javax.swing.JOptionPane;

public class FinalTest_01 {

	// 멤버변수
	private static final int MAX = 3;

	public static void main(String[] args) {
		// 지역변수
		int num = 0;
		num = 1;

		for (int i = 0; i < MAX; i++) {
			num = Integer.parseInt(JOptionPane.showInputDialog("값 입력"));
			if (num > MAX) {
				System.out.println("3보다 큽니다.");
			} else {
				System.out.println("3보다 작습니다.");
			}
		}
	}
}
