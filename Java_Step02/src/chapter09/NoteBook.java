package chapter09;

public abstract class NoteBook extends Computer {

	// 상속받은 두개의 추상 메서드 중 하나만 정의할 경우 NoteBook은 추상 클래스가 된다
	@Override
	public void display() {
		System.out.println("NoteBook Display()");
	}

}
