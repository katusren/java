package chapter07;

public class StudentMain {

	public static void main(String[] args) {

		// studentLee에 이수정으로 설정후

		Student_04 studentLee = new Student_04();
		studentLee.setStudentName("이수정");

		System.out.println("serialNum: " + Student_04.serialNum);
		System.out.println("StudentName: " + studentLee.StudentName);
		System.out.println(studentLee.studentID);

		Student_04 studentKim = new Student_04();
		studentKim.setStudentName("김우성");
		System.out.println("serialNum: " + Student_04.serialNum);
		System.out.println("StudentName: " + studentKim.StudentName);
		System.out.println(studentKim.studentID);

	}

}
