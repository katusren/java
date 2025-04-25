package Chapter03.fortest;

public class ForTest_07 {

	public static void main(String[] args) {
		// 이중 for 문

		for (int i = 2; i < 10; i++) {
			// i = 2~9
			for (int j = 1; j < 10; j++) {
				// j = 1~9
				System.out.println(i + "X" + j + "=" + (i * j));
			} // in for

			System.out.println();

		} // out for

	}

}
