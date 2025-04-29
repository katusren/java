package Chapter02;

import java.util.Scanner;

public class Example08 {

	public static void main(String[] args) {
		// 두 개의 숫자를 입력 받아서 첫 번째(num1) 숫자가 
		// 두 번째(num2) 숫자보다 큰지 여부를 출력하는 프로그램을 작성하세요.
		
		System.out.print("첫 번째 숫자 : ");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt(); //첫번째 숫자 입력
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt(); //두번째 숫자 입력
		
		//삼항 연산자
		String b = num1 > num2 ? "첫 번째 숫자가 더 큽니다." : "첫 번째 숫자가 더 작습니다.";
		System.out.println(b);
		
		/*
		 *  관계 연산자
		 *  boolean b = num1 > num2 ;
		 *  System.out.print("첫번째 숫자가 두번째 숫자보다 큰가요?" + b);
		 */
		
	}

}
