package chapter12.string;

public class Student {

    int studentId;
    String studentName;

    public Student() {

    }

    public Student(int studendId, String studentName) {
        this.studentId = studendId;
        this.studentName = studentName;
    }

    // 객체의 값(value)을 반환
    @Override
    public String toString() {
        return studentId + ", " + studentName;
    }

    @Override
    public int hashCode() {
        return studentId;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Student) {
            Student std = (Student) obj;
            if (studentId == std.studentId)
                return true;
            else
                return false;
        } else
            return false;

    }

}
