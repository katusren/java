package Chapter03.WhileTest;

import java.util.Scanner;

public class Example03 {

	public static void main(String[] args) {
		//

		boolean run = true;
		int balance = 0; // 예금(+), 출금(-)

		Scanner sc = new Scanner(System.in);
		System.out.println();

		// 1.예금 2.출금 3.잔고 4.종료
		while (run) {

			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택 > ");

			int a = sc.nextInt();

			// 선택한 값으로 은행업무 수행
			switch (a) {

			case 1:
				System.out.println("예금액 > ");
				int money = sc.nextInt();
				balance += money;
				System.out.println("잔액은 " + balance + "원 입니다.");
				break;

			case 2:
				System.out.println("출금액 > ");
				int money2 = sc.nextInt();
				balance -= money2;
				System.out.println("잔액은 " + balance + "원 입니다.");
				break;

			case 3:
				System.out.println("잔액> " + balance + "원");
				break;

			// run = true 였기 때문에 다시 대입
			case 4:
				run = false;
				break;
			}// s

			System.out.println();
		} // w

		System.out.println("프로그램 종료!");
	}// m

}// c

/*
 * 나이 int age = sc.nextInt(); 성별 String gen = sc.nextLine();
 * 
 * 나이> 29 성별> enter
 * 
 * System.out.print("나이 : "); int age = sc.nextInt(); sc.nextLine(); -> 필수입력
 * enter 을 날려버려야함***
 * 
 * System.out.print("이름: ") String name = scan.nextLine();
 */