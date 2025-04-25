package Chapter01;

public class CharacterType_08 {

	public static void main(String[] args) {
		// Character Type
		// Java, C# -> 2byte(16 bit) -> UTF-16
		// C, C++ -> 1byte(8bit) -> UTF-8
		
		char ch1 = '한'; //직접 한글 입력
		char ch2 = '\uD55C'; //유니코드 표현한 '한'
		
		System.out.println("ch1 : " + ch1);
		System.out.println("ch2 : " + ch2);
		
		char str1 = 'A'; //단일 문자
		System.out.println("str1 : " + str1);

		String str2 = "Hello Java"; //문자열
		System.out.println("str2 : " + str2);
		
		String str3 = "W"; //1글자만 String
		System.out.println("str3 : " + str3);

	}

}
