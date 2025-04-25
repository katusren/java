package Chapter03.SwitchTest;

public class SwitchCase_01 {

	public static void main(String[] args) {
		// ctrl + shift + f = 줄 자동정렬

		int ranking = 1;
		char medalColor;

		// if문 보다 switch문의 속도가 더 빠르다
		// Jump Table 분기
		switch (ranking) {
		case 1: {
			medalColor = 'G';
			break;
		}
		case 2: {
			medalColor = 'S';
			break;
		}
		case 3: {
			medalColor = 'B';
			break;
		}
		default: {
			medalColor = 'A';
		}
		}// switch

		System.out.println(ranking + "등 메달은 " + medalColor + "입니다.");

		System.out.println("----------------------------------");

		// if
		if (ranking == 1) {
			medalColor = 'G';
		} else if (ranking == 2) {
			medalColor = 'S';
		} else if (ranking == 3) {
			medalColor = 'B';
		} else {
			medalColor = 'A';
		}
		System.out.println(ranking + "등 메달은 " + medalColor + "입니다.");

	}// main

}// class
