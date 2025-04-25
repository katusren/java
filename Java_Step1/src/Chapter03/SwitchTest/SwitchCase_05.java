package Chapter03.SwitchTest;

public class SwitchCase_05 {

	public static void main(String[] args) {

		// Math.random(): 아무숫자나 갖고옴, +1 하면 1부터 가져옴(index 0부터 시작하기 때문)
		// (int) -> 명시적 형변환 -> 캐스팅
		int num = (int) (Math.random() * 10) + 1;

		switch (num) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6: {
			System.out.println(num + "점 획득");
			break;
		}
		default:
			System.out.println(num + "은(는) 잘못된 숫자입니다.");

		}// switch

	}// main

}// class
