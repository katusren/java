package Chapter02;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		//2자리의 양수(10-99)를 입력합니다.
		//그 값을 변수(no) 지정, 2자리 양수가 아니라면 반복
		//do while 문 사용
		
		System.out.println("숫자를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int no;
		
		do {

			// System.out.print(no); -> 잘못 입력한 값이 반복 출력됨
			
			System.out.print("입력 : ");
			no = sc.nextInt(); 
			
		}while(no<10 || no>99); //10이하 이거나 99 이상 이거나
		
		System.out.println("변수의 값은 : " + no + " 입니다.");
		
	}

}
