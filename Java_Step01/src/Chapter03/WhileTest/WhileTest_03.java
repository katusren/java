package Chapter03.WhileTest;

public class WhileTest_03 {

	public static void main(String[] args) {

		int num = 1;
		int sum = 0;

		while (num <= 100) {
			sum += num; // sum = sum + num
			num++;
		}
		System.out.println("1부터 100까지의 합 : " + sum);
	}

}
