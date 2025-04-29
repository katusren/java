package Chapter02;

import java.util.*;

public class Test4 {

	public static void main(String[] args) {
		// 1부터 n 까지의 정수 합 구하기
		// for 문 사용
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1부터 n까지의 합을 구합니다.");
		
		int n = sc.nextInt();
		System.out.println("n의 값 : " + n);
		
		int sum = 0;
		
		for(int i=1; i<=n ;i++) {
			
			sum = sum+i;
			
		}
		System.out.println("1부터 " + n + "까지의 합은 "+ sum+ "입니다.");
		sc.close();
	}

}
