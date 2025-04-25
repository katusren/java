package Chapter04;

public class ArgsTest_01 {

	public static void main(String[] args) {
		// Array 배열

		// int numbers[] = new int[5];
		int[] numbers = new int[5];

		numbers[0] = 10;
		numbers[1] = 20;
		numbers[2] = 30;
		numbers[3] = 40;
		numbers[4] = 50;

		int len = numbers.length;
		System.out.println("numbers의 갯수 : " + len);
		System.out.println();

		for (int i = 0; i < numbers.length; i++) {
			System.out.println(i + "번 첨자의 요소 : " + numbers[i]);
		}

	}

}
