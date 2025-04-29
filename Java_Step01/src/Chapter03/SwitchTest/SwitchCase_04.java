package Chapter03.SwitchTest;

import java.util.Scanner;

public class SwitchCase_04 {

	public static void main(String[] args) {
		// A, a -> 최우수고객
		// B, b -> 우수고객
		// 나머지 -> 일반고객

		Scanner sc = new Scanner(System.in);

		System.out.print("고객 등급을 입력해주세요 (A,a,B,b) : ");
		// nextLine().charAt(0) : String -> char 한글자만
		char grade = sc.nextLine().charAt(0);

		switch (grade) {
		case 'A':
		case 'a': {
			System.out.println("최우수고객");
			break;
		}
		case 'B':
		case 'b': {
			System.out.println("우수고객");
			break;
		}
		default:
			System.out.println("일반고객");
		}
		sc.close();

	}// main

}// class
