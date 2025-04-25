package Chapter02;

import java.util.*;

public class Testsstetess {

	public static void main(String[] args) {
		//1~100까지 더한 값
		
		int sum = 0;
		int a = 0;
		
		for(a=1;a<=10;a++){
			sum = sum+a;
		}
			
		System.out.println(sum);
		System.out.println("------------------");
		
		//if 문 1~100까지 짝수만 더한 값
		
		int sum1 = 0;
		int b = 0;
		
		for(b=1;b<=100;b++) {
			if(b%2==0) {
				sum1 = sum1+b;
			}
		}
		System.out.println(sum1);
		System.out.println("------------------");
		
		Scanner sc = new Scanner(System.in);
		
		String a1 = sc.nextLine();
		int num = sc.nextInt();
		
		System.out.println("입력 : " + a1);
		System.out.printf("num = %d", num);
		
		sc.close();
		
	}

}
