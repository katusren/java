package chapter10.Interface;

public class MyClassMain_04 {

	public static void main(String[] args) {

		MyClass mClass = new MyClass();

		X xClass = mClass; // X 클래스 타입
		xClass.x();
		System.out.println();

		Y yClass = mClass; // y 클래스 타입
		yClass.y();
		System.out.println();

		MyInterface iClass = mClass; // MyInterface 클래스 타입
		iClass.myMethod();
		iClass.x();
		iClass.y();
	}

}
