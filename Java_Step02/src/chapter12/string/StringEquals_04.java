package chapter12.string;

import java.util.Scanner;

public class StringEquals_04 {

	public static void main(String[] args) {

		String str1 = new String("test");
		String str2 = new String("test");

		System.out.println(str1 == str2); // heap 메모리가 같은지 반환
		System.out.println(str1.equals(str2));

		// 상수풀(JVM에서 특별관리하는 메모리영역 -> Constant Pool)
		String str = "abc";
		String str3 = "abc";

		System.out.println(str == str3); // true

		System.out.println(System.identityHashCode(str));
		System.out.println(System.identityHashCode(str3));

		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);

		System.out.println(i1 == i2); // false
		System.out.println(i1.equals(i2)); // true

		Scanner scar = new Scanner(System.in);
		String str4 = scar.nextLine();

		System.out.println(str == str4);
		System.out.println(str.equals(str4));
	}

}
