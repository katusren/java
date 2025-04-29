package Chapter03.SwitchTest;

import javax.swing.JOptionPane;

//import java.util.Scanner;

public class Example02 {

	public static void main(String[] args) {
		/*
		 * 사용자로부터 요일을 입력받아(1~7) 해당 요일에 어떤 음식을 먹을지 출력하는 프로그램을 작성하세요.
		 * (월요일:떡볶이,화요일:스파게티,------,일요일:초밥)-->여러분이 먹고싶은거 아무거나
		 */

		// Scanner sc = new Scanner(System.in);
		System.out.println("먹고 싶은 음식이 고민되시나요!");
		// System.out.print("요일을 입력해주시면 알려드릴게요! (1~7) : ");

		String a = JOptionPane.showInputDialog("요일을 입력하세요.");
		String cooking;
		// String a = sc.nextLine();

		switch (a) {

		case "월요일":
			cooking = "엽기 떡볶이에 중국당면 추가";
			break;
		case "화요일":
			cooking = "초밥";
			break;
		case "수요일":
			cooking = "마라탕&꿔바로우";
			break;
		case "목요일":
			cooking = "솥뚜껑 삼겹살";
			break;
		case "금요일":
			cooking = "치킨";
			break;
		case "토요일":
			cooking = "월남쌈";
			break;
		case "일요일":
			cooking = "민트초코 아이스크림";
			break;
		default:
			cooking = "잘못된 입력 방식 입니다.";

		}// switch
			// sc.close();

		// JOptionPane.showMessageDialog(null, a) -> null(중앙), a(띄우고 싶은 메세지)
		JOptionPane.showMessageDialog(null, cooking + "이 준비 되었습니다.");

	}

}
