package Chapter02;

import java.util.Scanner; // Scanner 클래스 호출

class Test1 {

	public static void main(String[] args) {
		//3개의 정숫값을 입력하고 최댓값을 구하기
		Scanner sc = new Scanner(System.in); // Scanner 객체 생성
		
		System.out.println("세 정수의 최댓값을 구합니다.");
		
		int a = sc.nextInt(); // 입력받은 정수를 a에 저장
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.println("a의 값 : " + a);
		System.out.println("b의 값 : " + b);
		System.out.println("c의 값 : " + c);
		
		int z = a; // z가 최댓값
		if(b > z) z = b;
		if(c > z) z = c;
		
		System.out.println("최댓값은 "+ z + " 입니다.");
		
		//sc.close();
		
	}

}
