package chapter05;

public class Example_04 {

	public double calculateAverage(int[] num) {

		int sum = 0;

		for (int i : num) {
			sum += i;
		}

		double avg = sum / (double) num.length;

		return avg;
	}

	public static void main(String[] args) {

		Example_04 calculator = new Example_04();

		int[] numbers = { 5, 10, 15, 20, 25 };
		double average = calculator.calculateAverage(numbers);
		System.out.println("배열의 평균: " + average);

	}

}
