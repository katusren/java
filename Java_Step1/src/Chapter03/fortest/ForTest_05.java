package Chapter03.fortest;

import java.util.Scanner;

public class ForTest_05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int i;
		System.out.print("0보다 크면서 11보다 작은 숫자를 입력하세요 : ");
		int a = sc.nextInt();

		if (a > 0 && a < 11) {
			for (i = 1; i < a; i++) {
				System.out.println("SolDesk Java");
			} // for

		} else {
			System.out.println("입력 값이 잘못되었습니다. 다시 실행해주세요.");
		}
		System.out.println("프로그램 종료!");

	}// main

}// class
