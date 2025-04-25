package Chapter05;

import javax.swing.JOptionPane;

public class FuncTest_03 {

	// Display1, Display2(static)
	public static void Display1(String[] A) {
		String res = "";
		// 배열 A의 요소들을 모두 res에 저장하는 메서드
		for (int i = 0; i < A.length; i++) {
			res += A[i] + " ";
		} // f
		System.out.println(res);
		JOptionPane.showMessageDialog(null, "배열의 요소\n" + res);
	}// D1 method

	public void Display2(String[] A) {
		String res = "";
		// 배열 A의 요소들을 모두 res에 저장하는 메서드
		for (int i = 0; i < A.length; i++) {
			res += A[i] + " ";
		} // f
		System.out.println(res);
		JOptionPane.showMessageDialog(null, "배열의 요소\n" + res);
	}// D1 method

	public static void main(String[] args) {

		String str[] = { "Java", "Oracle", "JSP", "HTMLS", "CSS", "SpringBoot" };

		// DATA 영역에서 호출( static 메서드 호출 )
		Display1(str);

		System.out.println();
		// stack 에서 호출되는 메서드
		FuncTest_03 obj = new FuncTest_03();
		obj.Display2(str);

	}

}

// DATA 영역(Static Area) -> 프로그램이 실행될때 미리 할당되는 메모리
// Heap 영역(동적 메모리)->new 등을 통해서 생성된 객체
// Stack 영역(메서드 호출/종료) -> 지역변수(블록 내에서 사용하는 변수), 매개변수
// 