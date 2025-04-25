package chapter06;

public class StudentMain {

	public static void main(String[] args) {

		// 기본생성자를 이용한 student1 객체 생성

		Student_07 student1 = new Student_07();

		student1.studentName = "이름";
		student1.address = "주소";

		student1.showStudentInfo();

		System.out.println();

		// 생성자를 이용한 초기화
		Student_07 student2 = new Student_07("이름2", "주소2");
		student2.showStudentInfo();

		System.out.println();

		// getter / setter
		Student_07 student3 = new Student_07();
		student3.setStudentName("솔데스크");
		student3.setAddress("강서구");
		student3.showStudentInfo();

	}

}
