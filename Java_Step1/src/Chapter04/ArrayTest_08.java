package Chapter04;

public class ArrayTest_08 {

	public static void main(String[] args) {

		int score[] = { 98, 90, 87 };
		int sum = 0;
		double avg;

		/*
		 * for이용 score점수 출력 => score[0]: 98 sum변수방에 점수 누적 avg변수방 선언후 평균 출력(단 실수타입)
		 */

		for (int i = 0; i < score.length; i++) {
			sum += score[i];
			// System.out.println(sum);
		} // f

		avg = sum / (double) (score.length);
		System.out.println("합계 : " + sum + "점, 평균 : " + avg + "점");
		// 반올림 Math.round()
		System.out.println("평균(반올림) : " + Math.round(avg) + "점");

	}

}
