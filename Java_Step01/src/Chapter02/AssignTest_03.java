package Chapter02;

public class AssignTest_03 {

	public static void main(String[] args) {
		// 대입연산(assignment)
		int num1 = 10; //10 리터럴(Literal)
		int num2 = 20;
		
		System.out.println(num1);

		num1 = num1+num2;
		System.out.println(num1);
		
		//축약형 (중복코드보다 좋음)
		num1+=num2;
		System.out.println(num1);
		
		
	}

}
