package chapter08;

public class StudentMain {

	public static void main(String[] args) {

		Student std = new Student("홍길동", "1245", 10000);

		System.out.println("이름: " + std.name);
		System.out.println("번호: " + std.ssn);
		System.out.println("학번: " + std.studentNum);

	}

}
