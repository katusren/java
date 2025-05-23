package chapter07;

import java.util.Scanner;

import chapter08.A;

public class Tour {

	public static void main(String[] args) {

		A a = new A();

		boolean run = true;

		Scanner scar = new Scanner(System.in);
		System.out.print("관광객 수: ");
		int n = scar.nextInt();

		// 초기화를 통해서 메모리 확보 및 고객생성
		Guide_05 guide = new Guide_05(n);

		System.out.println();
		System.out.println("관광객 등록");
		// 관광객 등록
		for (int i = 0; i < n; i++) {
			System.out.print((i + 1) + ". 이름: ");
			String name = scar.next();
			guide.guest[i].setName(name);

			System.out.print((i + 1) + ". 성별: ");
			String gender = scar.next();
			guide.guest[i].setGender(gender);
		}

		// while 문 입력
		while (run) {
			System.out.println("==========================");
			System.out.println("1.관광객 정보");
			System.out.println("2.목적지 변경");
			System.out.println("3.종료");

			int choice = scar.nextInt();

			switch (choice) {
			case 1: {
				for (int j = 0; j < n; j++) {
					System.out.println((j + 1) + "번째 손님은");
					System.out.println(
							"성함이 " + guide.guest[j].getName() + "이시고 성별은 " + guide.guest[j].getGender() + "이십니다.");
				}
				break;
			}
			case 2: {
				System.out.println("목적지를 변경하겠습니다. 현재 목적지는 " + Guide_05.point + "입니다.");
				System.out.print("변경하실 목적지를 입력해주시길 바랍니다: ");

				Guide_05.point = scar.next();

				System.out.println("변경된 목적지는 " + Guide_05.point + "입니다.");
				break;
			}
			case 3: {
				System.out.println("시스템을 종료하겠습니다.");
				run = false;
			}
			default: {
				System.out.println("잘못입력하셨습니다. 다시 입력해주시길 바랍니다.");
				break;
			}
			}

		}

		System.out.println("시스템 종료");
	}

}
