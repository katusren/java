package chapter05;

import java.util.Scanner;

public class Pastry_09 {

	// 멤버변수

	// 생성자(생략가능)

	// 메서드 Overload 1
	public void makeBread() {
		System.out.println("빵을 만듭니다.");
	}

	// 메서드 Overload 2
	public void makeBread(int cnt) {

		for (int i = 0; i < cnt; i++) {
			System.out.println((i + 1) + "번째 빵을 만듭니다!");
		}
		System.out.println("요청하신 " + cnt + "개의 빵이 모두 완료되었습니다.");

	}

	// 메서드 Overload 3
	public void makeBread(int cnt, String name) {

		for (int i = 0; i < cnt; i++) {
			System.out.println((i + 1) + "번째 빵을 만듭니다!");
		}
		System.out.println("요청하신 " + cnt + "개의 " + name + "이 모두 완료되었습니다.");

	}

	// -----------------------
	// public 생략 가능
	void order() {
		boolean run = true;

		Scanner sc = new Scanner(System.in);
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

	}

}
