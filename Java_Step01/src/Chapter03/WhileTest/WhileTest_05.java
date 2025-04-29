package Chapter03.WhileTest;

import java.util.Scanner;

public class WhileTest_05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.print("Java 교과목 점수를 입력해주세요 : ");
			int scr = sc.nextInt();

			// if -> 60점 이상이면 합격 그밖에 불합격
			// 0미만 또는 100초과시 "0~100까지의 점수만 입력 가능합니다."
			// OR -> ||

			if (scr < 0 || scr > 100) {
				System.out.println("0~100 까지의 점수만 입력 가능합니다.");
				break;
			} else {
				if (scr >= 60) {
					System.out.println("합격입니다.");
					break;
				} else {
					System.out.println("불합격입니다.");
					break;
				}
			}

		} // while

		System.out.println("프로그램 종료");

	}// m
}// c
