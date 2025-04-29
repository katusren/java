package Chapter03.WhileTest;

import java.util.Scanner;

public class WhileTest_07 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num, sum = 0, cnt = 0;
		double avg;

		while (true) {
			System.out.print("숫자를 입력하세요(0 입력시 프로그램 종료) : ");
			num = sc.nextInt();

			if (num == 0) {
				break;
			}

			cnt++; // 0은 세지 않음 (cnt는 갯수)
			sum += num; // sum=sum+num

		} // w

		avg = (double) sum / cnt;

		System.out.println("입력된 수의 합계 : " + sum);
		System.out.println("입력된 수의 갯수 : " + cnt);
		System.out.printf("입력된 수의 평균 : %.3f", avg);

	}// m

}// c
