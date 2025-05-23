package chapter06;

public class AccessTest_02 {

	// 멤버변수 = 필드

	private int aa; // 접근지정자로 현재 클래스에서만 사용 가능
	public int bb; // 접근지정자 공용(다른 클래스or패키지에서 사용 가능)
	int cc; // public 생략

	public void setAa(int aa) {
		this.aa = aa;
	}

	public void setBb(int bb) {
		this.bb = bb;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public void Disp() {
		System.out.println("aa값: " + aa);
		System.out.println("bb값: " + bb);
		System.out.println("cc값: " + cc);
	}

	public static void main(String[] args) {
		AccessTest_02 obj = new AccessTest_02();

		obj.aa = 10;

		obj.setAa(20);
		System.out.println("setAa(20) -> " + obj.aa);
		obj.setBb(30);
		System.out.println("setBb(30) -> " + obj.bb);
		obj.setCc(40);
		System.out.println("setCc(40) -> " + obj.cc);

		obj.Disp();
	}

}
