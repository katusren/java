package Chapter04;

public class ArrayTest_07 {

	public static void main(String[] args) {

		char[] alpa = new char[26];
		char ch = 'A'; // 65

		/*
		 * for 문 이용하여 초기화 하기 for (int i = 0; i < alpa.length; i++) { alpa[i] = ch; ch++;
		 * System.out.println(alpa[i] + " "); }//f
		 */

		for (int i = 0; i < alpa.length; i++, ch++) {
			alpa[i] = ch;
			System.out.println(alpa[i] + " ");
		} // f

	}// m

}// c
