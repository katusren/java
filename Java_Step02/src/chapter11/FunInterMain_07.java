package chapter11;

public class FunInterMain_07 {

	public void test() {

		// 익명의 클래스 호출
		new FunInter() { // FunInter obj = new FunInter();

			@Override
			public void printData() {
				System.out.println("목요일!!");
			}
		}.printData(); // 객체 생성후 호출

	}

	public static void main(String[] args) {
		FunInterMain_07 funinter = new FunInterMain_07();

		funinter.test();
	}

}
