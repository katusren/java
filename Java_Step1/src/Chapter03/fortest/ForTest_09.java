package Chapter03.fortest;

public class ForTest_09 {

	public static void main(String[] args) {
		// ㅁ + 한자키 -> 특수문자
		System.out.println("▶ 역삼각형 별 출력");

		for (int i = 5; i >= 1; i--) { // 줄 수
			for (int j = 1; j <= i; j++) {// 별의 수
				System.out.print('★');
			} // for in
			System.out.println();// 줄바꿈
		} // for out

	}// m

}// c
