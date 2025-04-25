package Chapter03.WhileTest;

import java.util.Random;
import java.util.Scanner;

public class Example06 {

	public static void main(String[] args) {

		/*
		 * 숫자 맞추기 게임 1부터 100까지 무작위 숫자를 선택하고, 숫자를 맞추는 게임 만약 입력한 숫자가 컴퓨터가 선택한 숫자보다 크면
		 * "더 작은 숫자를 추측하세요" 출력 만약 입력한 숫자가 컴퓨터가 선택한 숫자보다 작으면 "더 큰 숫자를 추측하세요" 출력 선택한 숫자를
		 * 정확히 맞출 때까지 과정을 반복 맞출때까지 걸린 시도 횟수를 출력하여 축하의 메시지를 출력
		 */

		Scanner sc = new Scanner(System.in);

		Random random = new Random();

		int a = random.nextInt(100) + 1; // 1~100 무작위 랜덤 숫자

		System.out.println("UP/DOWN 숫자게임을 시작합니다!");

		boolean run = true;
		int count = 0; // 도전한 횟수
		int num;// 나

		// ---------------------------------------------------
		// 구현

		do {
			System.out.println("추측한 숫자를 입력하세요. : ");
			num = sc.nextInt();
			count++;
			if (num > a) {
				System.out.println("DOWN : 더 작은 숫자를 입력하세요.");
			} else if (num < a) {
				System.out.println("UP : 더 큰 숫자를 입력하세요.");
			} // if

		} while (a != num);

		// 결과 인쇄
		System.out.println("정답입니다!");
		System.out.println("PC가 선택한 숫자 : " + a);
		System.out.println("내가 선택한 숫자 : " + num);
		System.out.println(count + "번째에 정답을 맞추셨습니다");
		System.out.println("게임을 종료합니다.");

	} // m

}// c
