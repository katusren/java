package chapter12.string;

public class StringEquals_03 {

	public static void main(String[] args) {

		String strVal1 = new String("홍길동");
		String strVal2 = "홍길동";

		if (strVal1.equals(strVal2))
			System.out.println("equal");
		else
			System.out.println("false");

	}

}
