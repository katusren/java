package Chapter02;

import java.util.Scanner;

public class Example03 {

	public static void main(String[] args) {
		
		// #1
		// 삼항연산자를 이용하여 score1이 60 보다 크거나 같으면 합격
		// 그렇지 않으면 불합격으로 반환 하시오.
		// 조건?합격:불합격
		System.out.print("score1 점수를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int score1 = sc.nextInt();
		System.out.println("score1 : "+ score1);
		String a;
		a = score1 >=60 ? "합격":"불합격";
		System.err.println("결과 : "+a);
		System.out.println("---------------------------");
		
		
		// #2
		// 삼항연산자를 이용하여 score2가 90보다 크면 'A'이고
		// score2가 80보다 크면 'B' 그 이하는 모두 'C'로 간주한다.
		System.out.print("score2 점수를 입력하세요 : ");
		int score2 = sc.nextInt();
		//boolean d;
		System.out.println("score2 : "+ score2);
		String b,c,d;
		b = score2 > 90 ? "A":"B"; 
		c = b =="B" && score2 > 80 ? "B":"C";
		d = score2 > 90 ? b:c;
		System.err.println("등급 : "+d);
		/* 
		 * char grade = score2 > 90 ? 'A' : ((score2>80) ? 'B' : 'C');
		 */
		
		
		
	}

}
