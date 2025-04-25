package Chapter03.fortest;

import java.util.Scanner;

public class Example01 {

	public static void main(String[] args) {
		// 몇명의 성적을 입력 받을 것인지 정수로 인원수(cnt)를 입력 받고,
		// 총점(sum)과 평균(avg)을 구하시오.(단, 평균은 실수로 출력할 것)

		Scanner sc = new Scanner(System.in);
		System.out.print("몇 명의 성적을 입력받으시겠습니까? : ");

		int cnt = sc.nextInt(); // 몇 명
		double sum = 0, avg;

		// 1 ~ cnt(입력받는 수)까지 i 는 반복
		for (int i = 1; i <= cnt; i++) {

			System.out.print(i + "번째 성적 입력 : ");
			int a = sc.nextInt();
			sum += a; // sum -> 총점, a-> 1인당 점수
		}

		// 캐스팅
		avg = (double) sum / cnt;
		System.out.println(cnt + "명의 점수 총점은 " + sum + "점, " + "평균은 " + avg + "점 입니다.");
	}

}
