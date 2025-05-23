package chapter05;

public class Example_03 {

	// 최대값을 메소드로 구현
	public static int findMax(int[] num) {

		int max = 0;

		for (int i : num) {
			if (max < i)
				max = i;
		}

		return max;
	}

	public static void main(String[] args) {

		int[] numbers = { 7, 2, 9, 1, 5 };
		int maxnum = findMax(numbers);
		System.out.println("최대값: " + maxnum);

	}

}
