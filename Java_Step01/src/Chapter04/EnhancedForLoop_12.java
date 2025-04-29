package Chapter04;

public class EnhancedForLoop_12 {

	public static void main(String[] args) {

		int number[] = { 10, 20, 30, 40, 50 };

		// EnhancedFor
		for (int lang : number) {
			System.out.print(lang + " ");
		}

		int num[] = { 10, 5, 20, 15, 25 };
		int sum = 0;

		// EnhancedFor 누적값
		for (int lang : num) {
			sum += lang;
		}

		System.out.println("누적 값 : " + sum);
	}

}
