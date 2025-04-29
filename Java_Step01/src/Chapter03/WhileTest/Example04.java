package Chapter03.WhileTest;

import java.util.Scanner;

public class Example04 {

	public static void main(String[] args) {
		// if문
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

			if (a == 1) {
				System.out.println("예금을 선택하셨습니다.");
				System.out.println("잔액 : " + balance);
				System.out.println("예금액 > ");
				int money = sc.nextInt();
				if (money <= 0) {
					System.out.println("잘못된 접근입니다.");
				} else {
					balance += money;
				}
			} else if (a == 2) {
				System.out.println("출금을 선택하셨습니다.");
				System.out.println("출금액 > ");
				int money2 = sc.nextInt();
				if (money2 > balance) {// 잔액보다 출금액이 크면
					System.out.println("잘못된 접근입니다.");
				} else {
					balance -= money2;
				}
			} else if (a == 3) {
				System.out.println("잔액> " + balance + "원");
			} else if (a == 4) {
				run = false; // while 문 종료를 위해 true -> false
				break;
			} else {
				System.out.println("잘못된 서비스를 선택하셨습니다!");
			} // if

			System.out.println();
		} // w

		System.out.println("프로그램 종료!");
	}// m

}// c
