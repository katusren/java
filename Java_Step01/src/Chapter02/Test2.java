package Chapter02;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		//입력한 정숫값이 양수인지 음수인지 0인지 판단한다. 
		// if else 문 사용
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int a = sc.nextInt();
		
		if(a>0) {
			System.out.println("이 수는 양수입니다.");
		}
		else if(a<0) {
			System.out.println("이 수는 음수입니다.");
		}
		else {
			System.out.println("이 수는 0 입니다.");
		}
		
		//sc.close();
	}

}
