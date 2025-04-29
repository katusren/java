package Chapter03.fortest;

public class ForTest_10 {

	public static void main(String[] args) {
		System.out.println("▶ 3행 4열 숫자 그리드 만들기");

		int num = 1;

		for (int row = 1; row <= 3; row++) {

			for (int col = 1; col <= 4; col++) {
				System.out.print(num + "\t");
				num++; // 후위연산(증가시키고 뒤로 보냄)
			} // for in
			System.out.println();
		} // for out
	}// m

}// c
