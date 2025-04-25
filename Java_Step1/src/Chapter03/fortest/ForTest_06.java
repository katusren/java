package Chapter03.fortest;

public class ForTest_06 {

	public static void main(String[] args) {
		// 1에서부터 100까지의 수 중에서 3의 배수를 찾아 합을 계산하세요.

		int sum = 0; // sum -> 3의 배수의 합

		for (int i = 0; i <= 100; i++) {

			if (i % 3 == 0) {
				System.out.print(i + " ");
				sum += i;
			} // if

		} // for

		System.out.println();
		System.out.println("1~100까지의 수중 3의 배수의 합 : " + sum);

	}// m

}// c
