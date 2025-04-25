package Chapter04;

public class Example02 {

	public static void main(String[] args) {
		// 배열에서 최댓값을 찾아서 출력

		System.out.println("배열의 최댓값 찾기를 시작합니다.");
		int max = 0; // 최댓값 찾기는 최대한 작은 값을 넣고 시작한다.
		int array[] = { 1, 6, 9, 2, 35, 178, 234, 4, 5, 11 };

		for (int i = 0; i < array.length; i++) {

			if (array[i] > max) {
				max = array[i];
			} // if

		} // f
		System.out.println();
		System.out.println("배열의 최댓값은 : " + max);
		System.out.println();

		for (int num : array) {
			if (max < num) {
				max = num;
			} // if
		} // for
		System.out.println("배열의 최댓값은 : " + max);

	}// m

}// c
