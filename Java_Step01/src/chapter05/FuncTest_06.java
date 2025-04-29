package chapter05;

import java.util.Scanner;

public class FuncTest_06 {

	// void -> 반환X
	// static -> data

	public static String EduStep(int edu) {

		String step = "";

		switch (edu) {
			case 1:
				System.out.print("해당하는 스터디의 단계는 step 1 입니다.");
				step = "초급";
				break;
			case 2:
				System.out.print("해당하는 스터디의 단계는 step 2 입니다.");
				step = "중급";
				break;
			case 3:
				System.out.print("해당하는 스터디의 단계는 step 3 입니다.");
				step = "상급";
				break;
			default:
				System.out.println("잘못된 입력 입니다!");
				step = "0 단계";
				break;

		}// switch
		return step;

	}// method

	public static void main(String[] args) {
		// 입력 받아서 Number
		Scanner sc = new Scanner(System.in);
		System.out.print("스터디 단계를 입력하세요 : ");
		int number = sc.nextInt();

		// 1: 초급 2: 중급 3: 상급
		String step = EduStep(number);
		System.out.println("현재 수업 단계는 " + step + " 단계입니다.");

	}

}
