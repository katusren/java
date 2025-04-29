package Chapter03.WhileTest;

import java.util.Scanner;

public class Example08 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int num;

		while (run) {
			System.out.println("------------------------------------------");
			System.out.println("1. 빵 개수만 선택 | 2.빵 개수와 종류 선택 | 3.종료");
			System.out.println("------------------------------------------");
			System.out.print("선택>> ");

			// 번호입력 받기
			num = Integer.parseInt(sc.nextLine());
			int a;
			String b;

			switch (num) {
			case 1: // 빵의 개수 입력받기
				System.out.print("빵의 개수 입력 > ");
				a = Integer.parseInt(sc.nextLine());

				for (int i = 0; i < a; i++) {
					System.out.println("빵 " + (i + 1) + "개");
				}
				System.out.println("요청하신 " + a + "개의 " + "빵이 완성되었습니다!");
				break;

			case 2: // 빵의 개수 입력받기, 빵의 종류 받기
				System.out.print("빵의 개수 입력 > ");
				a = Integer.parseInt(sc.nextLine());
				System.out.println("빵의 종류 입력 >");
				b = sc.nextLine();

				for (int i = 0; i < a; i++) {
					System.out.println(b + "빵" + (i + 1) + " 개");
				}
				System.out.println("요청하신 " + a + "개의 " + b + "빵이 완성되었습니다!");

				break;

			case 3:
				System.out.println("프로그램 종료");
				run = false;
				break;

			default:
				System.out.println("잘못된 접근입니다. 프로그램을 재시작 해주세요.");
			}// switch

			// System.out.println("누적 빵의 갯수는 " + "개 이고, " + "\n빵의 종류는 " + "가 있습니다!");

		} // while

	}// m

}// c
