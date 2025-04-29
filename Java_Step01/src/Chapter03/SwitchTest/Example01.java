package Chapter03.SwitchTest;

import java.util.Scanner;

public class Example01 {

	public static void main(String[] args) {
		/*
		 * 사용자로부터 월을 입력받아, 해당 월의 계절을 출력하는 프로그램을 작성하세요. 봄:3-5월, 여름:6-8월, 가을:9-11월,
		 * 겨울:12-2월
		 */

		Scanner sc = new Scanner(System.in);
		System.out.print("계절 계산기 : ");

		int weather = sc.nextInt();

		switch (weather) {
		case 1:
		case 2:
		case 12: {
			System.out.print(weather + "월은 겨울입니다.");
			break;
		}
		case 3:
		case 4:
		case 5: {
			System.out.print(weather + "월은 봄입니다.");
			break;
		}
		case 6:
		case 7:
		case 8: {
			System.out.print(weather + "월은 여름입니다.");
			break;
		}
		case 9:
		case 10:
		case 11: {
			System.out.print(weather + "월은 가을입니다.");
			break;
		}
		default: {
			System.out.println("월을 잘 못 입력 하셨습니다.");
		} // default

		}// switch
		sc.close();
	}// main

}// class
