package Chapter02;

import java.util.Scanner;

public class Example05 {

	public static void main(String[] args) {
		/*
		 * 1. 값을 입력받아서 양수인지 음수인지를 판별하는 프로그램
		 * 2. 삼항연산자를 사용하여 변수방에 저장된 수가 양수면 "양수입니다." 
		 * 	  그렇지 않으면 "음수 또는 0 입니다." 라고 출력이 되어야함
		 * 
		 */
		
		
		System.out.println("프로그램을 시작합니다.");
		Scanner sc = new Scanner(System.in); // ctrl+shift+o : 자바 스캐너 import 해줌
		int a = sc.nextInt();
		System.out.println("입력받은 숫자 값 : "+a);
		String b;
		
		b = a >= 1 ? "양수입니다.":"음수 또는 0 입니다.";
		System.out.println(b);
		
			/*
			 *양수인지 여부를 판별하는 변수방 isPositive
			 * boolean isPositive = number>0;
			 * String result = isPositive ? "양수입니다.":"음수 또는 0입니다.";
			 * System.out.println(result);
			 */
		

	}

}
