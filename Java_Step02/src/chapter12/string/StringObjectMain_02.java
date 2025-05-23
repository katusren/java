package chapter12.string;

public class StringObjectMain_02 {

	public static void main(String[] args) {

		StringObject v1 = new StringObject();
		v1.setValue(v1);

		System.out.println(v1.getValue());

		// -----------------------------------
		StringObject v2 = new StringObject();

		v2.setValue(100); // 오토박싱 -> 객체(Object)
		System.out.println(v2.getValue());

		// 캐스팅
		// int i = v2.getValue();
		int i = (int) v2.getValue(); // 언박싱
		System.out.println(i + 2);

	}
}
