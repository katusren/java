package chapter08;

public class CalMinus extends Example_01 {

	@Override
	public int getResult(int n1, int n2) {
		int minus = n1 - n2;
		System.out.println("CalMinus : " + minus);
		return minus;
	}

}
