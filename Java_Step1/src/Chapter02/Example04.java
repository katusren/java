package Chapter02;

import java.util.Scanner;

public class Example04 {

	public static void main(String[] args) {
		// 원의 넓이를 구하세요.(반지름*반지름*3.14)
		// 반지름 :10, 3.14는 double로 정의하여 구하시오
		// 반지름 변수방 num1 / 3.14 변수방 pi / 넓이 변수방 result

		Scanner sc = new Scanner(System.in);
		System.out.print("반지름의 길이를 입력하세요 : ");
		int num1 = sc.nextInt();
		double pi = 3.14;
		double result;
		
		result = num1*num1*pi;
		System.out.println("원의 넓이는 : "+result);
		
		sc.close();
		
		/*
		 * int num1 = 10; //long으로 선언시 int로 묵시적 형 변환
		 * double pi=3.14;
		 * 
		 * double result = num1*num1*pi;
		 * System.out.println("원의 넓이는 : "+result);
		 * 
		 * 
		 */
	}

}
