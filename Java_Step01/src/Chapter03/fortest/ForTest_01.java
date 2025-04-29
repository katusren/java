package Chapter03.fortest;

public class ForTest_01 {

	public static void main(String[] args) {
		// 1~10 까지의 합

		int sum = 0;

		// 누적 변수방(항상 초기화가 되어있어야함)
		sum = sum + 1;
		sum = sum + 2;
		sum = sum + 3;
		sum = sum + 4;
		sum = sum + 5;
		sum = sum + 6;
		sum = sum + 7;
		sum = sum + 8;
		sum = sum + 9;
		sum = sum + 10;

		System.out.println(sum);

		int i; // index 변수방
		System.out.println("1부터 10까지의 수 출력");
		for (i = 0; i < 10; i++) {
			System.out.print((i + 1) + " ");
		}

		System.out.println();
		System.out.println("-------------------------");

		int k; // index 변수방
		System.out.println("1부터 10까지의 수 출력");
		for (k = 0; k < 10; ++k) {
			System.out.print((k + 1) + " ");
		}

	}

}
