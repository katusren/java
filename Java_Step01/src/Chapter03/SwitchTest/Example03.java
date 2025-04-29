package Chapter03.SwitchTest;

import javax.swing.JOptionPane;

public class Example03 {

	public static void main(String[] args) {

		String input = JOptionPane.showInputDialog("등급을 입력하세요 (A~F) : ");

		// 객체 null (아무것도 입력안된 상황, 메모리 안씀) -> String str = null;, String str;
		// isEmpty (문자 길이가 0인 것) -> string str = "";

		// if문으로 input == null 이거나 input.isempty()면 메세지 박스를 이용하여 출력
		// 입력값이 없습니다.

		if (input == null || input.isEmpty()) {
			JOptionPane.showMessageDialog(null, "입력 값이 없습니다.");
		}

		// 'A' 'B' 'C' 'D' 'F' 입력받기
		// toUpperCase : 모두 대문자로 변환
		char grade = Character.toUpperCase(input.charAt(0));
		String message;

		// switch 사용
		switch (grade) {
		case 'A':
			message = "당신의 점수는 5 입니다.";
			break;
		case 'B':
			message = "당신의 점수는 4 입니다.";
			break;
		case 'C':
			message = "당신의 점수는 3 입니다.";
			break;
		case 'D':
			message = "당신의 점수는 2 입니다.";
			break;
		case 'F':
			message = "당신의 점수는 1 입니다.";
			break;
		default:
			message = "잘못 입력하셨습니다.";
		}

		// MessageDialog 사용
		// \n : 줄 나누기
		JOptionPane.showMessageDialog(null, "입력한 등급 : " + grade + "\n" + message);

	}

}
