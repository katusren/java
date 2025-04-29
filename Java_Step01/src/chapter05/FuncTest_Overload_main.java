package chapter05;

public class FuncTest_Overload_main {

	public static void main(String[] args) {

		FuncTest_Overload_08 obj = new FuncTest_Overload_08();

		obj.getResult(0305);
		obj.getResult('용');
		obj.getResult("금요일은 언제 오나");
		obj.getResult(2025, "5/26은 자격증 시험 날!");

		obj.getResult("레드");
		obj.getResult("화이트");

	}

}
