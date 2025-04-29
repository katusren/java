package Chapter03.IfTest;

import java.util.Scanner;

public class IfTest_01 {

	public static void main(String[] args) {
		//#1.삼항연산자
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		String str = age>=8? "학교에 다닙니다.": "학교에 다니지 않습니다.";
		System.out.println(str);
		*/
		
		//#2.단일 if문
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		
		int age = sc.nextInt();
		
		if(age>=8) {
			System.out.println("학교에 다닙니다.");
		}
		//System.out.println("학교에 다니지 않습니다.");
		
		//#3. is ~ else
		
		int age2 = 10;
		
		if(age2>=8) {
			System.out.println("학교에 다닙니다.");
		}else {
			System.out.println("학교에 다니지 않습니다.");
		}
		
		sc.close();
		
	}

}
