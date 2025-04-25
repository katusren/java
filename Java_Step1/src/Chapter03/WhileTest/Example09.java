package Chapter03.WhileTest;

import java.util.Scanner;

public class Example09 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 컴퓨터가 선택한 서로 다른 3자리 수
		int n1, n2, n3;

		do {
			n1 = (int) (Math.random() * 9) + 1;
			n2 = (int) (Math.random() * 9) + 1;
			n3 = (int) (Math.random() * 9) + 1;

		} while (n1 == n2 || n2 == n3 || n1 == n3);
		// n1,n2,n3 가 서로 다 다르면 do while문을 빠져나와라

		int tryCount = 0;

		System.out.println("숫자 야구 게임 시작!(1~9 사이의 서로 다른 숫자 3개)");

		while (true) {
			tryCount++; // while문의 반복 수

			System.out.print("입력 (공백으로 구분)");

			int a1 = sc.nextInt(); // a1= 사용자1
			int a2 = sc.nextInt(); // a2= 사용자2
			int a3 = sc.nextInt(); // a3= 사용자3

			int strike = 0;
			int ball = 0;

			// n1 == user1 -> strike
			// n1 == user2 -> ball

			if (n1 == a1) {
				strike++;
			} else if (n1 == a2 || n1 == a3) {
				ball++;
			}
			// ball
			if (n2 == a2) {
				strike++;
			} else if (n2 == a1 || n2 == a3) {
				ball++;
			}

			if (n3 == a3) {
				strike++;
			} else if (n3 == a1 || n3 == a2) {
				ball++;
			}

			System.out.println("strike " + strike + "개, ball " + ball + "개 입니다.");

			if (n1 == a1 && n2 == a2 && n3 == a3) {
				System.out.println("\n-------------------");
				System.out.println("♬ 정답입니다! ♬");
				System.out.println("☞ 숫자 야구의 정답은 : " + n1 + " " + n2 + " " + n3 + " 입니다!");
				System.out.println("☞ 도전 횟수 : " + tryCount + "번");
				System.out.println("프로그램을 종료합니다.");
				break;
			} // 정답 if

		} // while

	}// m

}// c
