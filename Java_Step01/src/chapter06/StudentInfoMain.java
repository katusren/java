package chapter06;

public class StudentInfoMain {

	public static void main(String[] args) {

		StudentInfo_06 info = new StudentInfo_06(1004, "최백설", 1, "일산");

		System.out.println(info.studentID);
		System.out.println(info.address);
		System.out.println(info.grade);

		// getters / setters 이용한 초기화 또는 출력
		System.out.println(info.getStudentName());

		// 기본 생성자를 이용해서 객체 생성(studentkim);
		StudentInfo_06 studentkim = new StudentInfo_06();

		// 주소를 직관적으로 초기화 하고 출력

		studentkim.address = "종로구";

		System.out.println(studentkim.address);

		// 기본 생성자를 이용해서 객체 생성(studentlee)
		StudentInfo_06 studentlee = new StudentInfo_06();
		// getter / setter를 사용해서 초기화 하거나 출력

		studentlee.setStudentName("나세종");
		System.out.println(studentlee.getStudentName());

	}

}
