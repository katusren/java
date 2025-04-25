package Chapter04;

import java.util.Scanner;

public class Example03 {

	public static void main(String[] args) {
		// 사용자에게 찾고 싶은 숫자를 1에서부터 10까지 입력 받아,
		// 해당 숫자의 인덱스를 찾아 출력하는 프로그램을 만드세요.
		// 단, 사용자가 입력한 값이 배열 인덱스로 나타낼 수 없는 경우 찾을 수 없다는 문구를 출력하세요.

		int[] numbers = { 10, 3, 2, 1, 4, 8, 7, 9, 5, 6 }; // 배열 선언
		int target; // 알고 싶은 숫자
		int index = -1; // 초기 인덱스를 -1로 설정

		Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 Scanner 선언

		System.out.print("찾고 싶은 숫자를 입력하세요 (1 ~ 10): ");
		target = sc.nextInt(); // 숫자 입력받기

		// 배열에서 숫자 찾기
		for (int i = 0; i < numbers.length; i++) { // 배열 길이만큼 반복
			if (numbers[i] == target) { // 숫자를 찾으면
				index = i; // 해당 인덱스(몇번째인지) 저장
				break; // 찾았으므로 반복문 종료
			}
		}

		// 결과 출력
		if (index != -1) { // 숫자를 찾은 경우
			System.out.println("숫자의 위치는 " + (index + 1) + "번째에 있습니다!~~~");
		} else { // 숫자를 찾지 못한 경우
			System.out.println("찾고자 하는 숫자는 배열에 없습니다.");
		}

		sc.close(); // Scanner 닫기
	}
}
