package Chapter03.fortest;

import java.util.Scanner;

public class ForTest_03 {

	public static void main(String[] args) {

		// 합계가 입력받은 수를 초과하면 반복문을 멈춤

		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt(); // 40
		int i, sum = 0;

		for (i = 1;; i++) {
			if (sum > num) {
				break;
			} // if
			sum += i;
			System.out.print(i + " ");
		} // for

		System.out.println();
		// 후위연산이기때문에 i - 1 로 계산해야함
		System.out.println("1 ~ " + (i - 1) + " 까지의 총합 : " + sum);
		sc.close();

	}// main

}// class
