package Chapter03.fortest;

public class Example02 {

	public static void main(String[] args) {
		// 홀수 구구단 만들기

		for (int i = 1; i < 10; i++) { // i+=2 로 바꿔도 됨

			// 홀수 단
			if (i % 2 == 1) {
				System.out.print("[ " + i + "단 ]" + "\t");
			}

		} // for
		System.out.println();

		// ==================구구단==================
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j % 2 == 1) {
					System.out.print(j + "X" + i + "=" + (j * i) + "\t");
				} // if
			} // for in
			System.out.println();
		} // for out

	}// m

}// c