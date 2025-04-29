package Chapter02;

import java.util.Scanner;

public class Example07 {

	public static void main(String[] args) {
		// 한 자릿수 숫자를 입력받아 (scan)
		// 숫자가 짝수인지 홀수인지 출력하는 프로그램(삼항 연산자 사용)
		
		System.out.print("한 자릿수 숫자를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		String b = a%2 == 0 ? "짝수입니다." : "홀수입니다.";
		System.out.println(b);

	}

}
