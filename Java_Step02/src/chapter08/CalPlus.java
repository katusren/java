package chapter08;

public class CalPlus extends Example_01 {

	@Override
	public int getResult(int n1, int n2) {
		int plus = n1 + n2;
		System.out.println("CalPlus : " + plus);
		return plus;
	}

}
