package chapter07;

public class Student_04 {

	public static int serialNum = 10000;
	int studentID;
	String StudentName;
	int grade;
	String address;

	public Student_04() {
		serialNum++;
		this.studentID = serialNum;

	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public static int getSerialNum() {
		return serialNum;
	}

}
