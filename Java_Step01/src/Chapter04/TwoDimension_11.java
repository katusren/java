package Chapter04;

public class TwoDimension_11 {

	public static void main(String[] args) {

		String strArray[] = { "Java", "Oracle", "HTMLS", "CSS", "JSP", "Spring", "Python" };

		for (int i = 0; i < strArray.length; i++) {
			System.out.print(strArray[i] + " ");
		}
		System.out.println();

		// 확장 for문 (=향상된 for문)
		for (String lang : strArray) {// 7번 회전(요소)
			System.out.print(lang + " ");
		}

	}

}
