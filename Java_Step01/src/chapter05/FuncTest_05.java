package chapter05;

import java.util.Scanner;

public class FuncTest_05 {

	// void -> 반환X
	// static -> data
	public static void EduStep(int step) {
		if (step == 1) {
			System.out.println("해당하는 스터디 단계는 step1 입니다.");

		} else if (step == 2) {
			System.out.println("해당하는 스터디 단계는 step2 입니다.");

		} else if (step == 3) {
			System.out.println("해당하는 스터디 단계는 step3 입니다.");

		} else {
			System.out.println("해당하는 스터디 단계가 없습니다.");
		}

	}

	public static void main(String[] args) {
		// 입력 받아서 Number
		Scanner sc = new Scanner(System.in);
		System.out.print("스터디 단계를 입력하세요 : ");
		int number = sc.nextInt();

		EduStep(number);

	}

}
