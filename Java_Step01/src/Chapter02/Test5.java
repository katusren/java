package Chapter02;

import java.util.Scanner;

//import javax.swing.JOptionPane;

public class Test5 {

	public static void main(String[] args) {
		//1,2, ... n의 합을 구하기(음수)
		//do while 문 사용하기
		
		Scanner sc = new Scanner(System.in);
		System.out.println("0부터 n까지 음수의 합을 구합니다.");
		int n;
		
		do {
			n = sc.nextInt(); //입력값 불러오기
			System.out.println("n의 값 : "+n);
		}while(n>=0); //n이 음수일 경우
		
		int sum = 0;
		
		for(int i=0;i>n;) {
			i--;
			sum-=i;
			System.out.println(i);
		}
		
		System.out.println("1부터 "+n+"까지의 합은 "+-sum+"입니다");		

	}
	
	/*
	 * 	// total = 0~n 까지의 합
		int total = 0; 
		int n; // 선언
		
		do {
			// n = 입력받은 수의 값
			n = Integer.parseInt(JOptionPane.showInputDialog("음수의 값을 입력하세요"));
			System.out.println("입력 : "+n);
		}while(n>=0); // 1보다 크거나 같으면 멈춤
		
		for(int i = 0; i>=n; i--) {
			total-=i;
			System.out.println(i);
		}
		
		System.out.println("0부터 "+n+"까지의 합은 "+-total+"입니다.");
	 */
	
	
	/*Scanner sc = new Scanner(System.in);
	System.out.println("1부터 n까지의 합을 구합니다."); //양수버전
	
	int n;
	
	do{
		n = sc.nextInt();
		System.out.println("n의 값 : "+n);
	}while(n<=1);
	
	int sum=0;
	
	for(int i=1; i<=n;i++) {
		sum+=i;
	}
	System.out.println("1부터 "+ n+"까지의 합은 "+sum+"입니다.");
	*/


}
