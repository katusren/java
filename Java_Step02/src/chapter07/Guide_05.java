package chapter07;

import java.util.Scanner;

public class Guide_05 {

	// 멤버변수
	static String point;
	Guest[] guest;
	Scanner scar;

	// 생성자
	public Guide_05(int n) {
		// 목적지
		point = "발리";
		// 관광객 수 만큼 메모리 확보
		guest = new Guest[n];

		for (int i = 0; i < n; i++) {
			guest[i] = new Guest();
		}
	}

	// 메서드
	public static String getPoint() {
		return point;
	}
}
