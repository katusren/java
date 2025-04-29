package Chapter04;

import java.util.Random;

import javax.swing.JOptionPane;

public class MyLotto_11 {

	public static void main(String[] args) {
		// 로또 추첨기 프로그램

		int number; // 구매 횟수 -> 입력
		int cnt = 0;
		int[] lotto = new int[6]; // 배열 -> 6 자리 생성

		System.out.println("========이번주 로또 예상번호=========");
		number = Integer.parseInt(JOptionPane.showInputDialog("원하는 로또 구매횟수를 입력하세요.")); // 구매 횟수 입력

		while (number > cnt) {
			System.out.print("[" + (cnt + 1) + "회] : "); // 몇번 반복인지 나타냄

			outer: for (int i = 0; i < lotto.length;) {// i -> 6개 받기 (lotto 배열의 요소의 길이)

				lotto[i] = new Random().nextInt(45) + 1; // 1-45 숫자 랜덤으로 i(배열의 요소) 에 넣음

				// 중복성 제거
				for (int j = 0; j < i; j++) {
					if (lotto[i] == lotto[j]) {// lotto 배열의 요소가 중복된다면
						// 분기점으로 이동
						continue outer; // ->outer 다시 밖 for 문으로 가서 갖고와(탈출)
					} // if

				} // for in

				System.out.print(lotto[i] + " ");
				i++; // 배열의 요소를 다 채울때까지 가져오거라!

			} // for out

			cnt++;
			System.out.println();
		} // w

	}// m

}// c
