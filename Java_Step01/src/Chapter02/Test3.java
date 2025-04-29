package Chapter02;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		//1부터 n 까지 정수 합 구하기
		//while 문 사용
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1부터 n까지 정수의 합을 구합니다.");
		
		int n = sc.nextInt();
		System.out.println("n의 값 : " + n);
		
		int i = 1;
		int sum = 0; // 더한값을 저장하는 변수는 0으로 초기화 시키기
		
		while(i<=n) {
			sum+=i;
			i++; 
		}
		System.out.println("1부터 "+ n + "까지의 합은 " + sum+ "입니다.");
		sc.close();
	}

}
