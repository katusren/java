package Chapter03.IfTest;

import javax.swing.JOptionPane;

public class IfTest_06 {

	public static void main(String[] args) {
		// 두 수를 입력받아 어떤 수가 큰지 판단하는 프로그램
		// num1, num2 의 수가 num1이 큽니다. 또는 num2가 큽니다. 또는 같습니다의 결과가 나오도록 구현
		// 그외 값은 다시 입력하세요 로 출력
		
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("첫 번째 수를 입력하세요."));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("두 번째 수를 입력하세요."));
		
		if(num1>num2) {
			System.out.println(num1+"의 값이 더 큽니다.");
		}else if(num1==num2) {
			System.out.println("두 수의 값이 같습니다.");
		}else if(num1<num2) {
			System.out.println(num2+"의 값이 더 큽니다.");
		}
		/*else {
		System.out.println("다시 입력하세요."); 
		}
		 */
	}

}
