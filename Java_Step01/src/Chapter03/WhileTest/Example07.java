package Chapter03.WhileTest;

import java.util.Scanner;

public class Example07 {

	public static void main(String[] args) {
		// 숫자 암호 (3자) 해제
		/*
		 * 1. 컴퓨터가 100-999 사이의 무작위 암호를 설정 2. 사용자가 맞출 때까지 입력 3. 틀릴 경우 "틀렸습니다. 다시 입력하세요."
		 * 출력 4. 맞춘 경우 "성공! 암호 해제 완료!" 5. 몇번만에 맞췄는지 count 출력
		 */

		Scanner sc = new Scanner(System.in);

		boolean run = true;
		// PC
		int password = (int) (Math.random() * 900) + 100; // 100부터 시작해서 900개
		int userinput;
		int count = 0;

		System.out.println("숫자 암호 해제를 시작합니다.(3자리 숫자)");
		System.out.println("100~999 사이의 숫자를 입력하여 암호 해제에 성공하십시오!");

		while (run) {

			System.out.print("숫자 입력 > ");
			userinput = sc.nextInt(); // 내가 입력하는 값
			count++;

			if (userinput > password) {// 내 입력값이 암호보다 클 경우
				System.out.println("틀렸습니다. 다시 입력하십시오.");
				System.out.println("DOWN : 더 작은 숫자를 입력해주세요!");
			} else if (userinput < password) {// 내 입력값이 암호보다 작을 경우
				System.out.println("틀렸습니다. 다시 입력하십시오.");
				System.out.println("UP : 더 큰 숫자를 입력해주세요!");
			} else if (userinput == password) {// 내 입력값이 암호와 일치할 경우
				run = false;
			} // if

		} // w
		System.out.println("성공! 암호 해제 완료! {시도 횟수 : " + count + "번}");

	}// m

}// c

/*
 * do while 문 do{
 * 
 * System.out.print("암호 입력 : "); userinput = sc.nextInt(); count ++ ;
 * 
 * if(userinput != password){ System.out.print("틀렸습니다. 다시 입력하세요"); }
 * 
 * }while(password!=userinput); //암호를 맞추지 못한 경우 반복
 * 
 * 
 */
