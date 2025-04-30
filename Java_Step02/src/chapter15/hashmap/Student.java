package chapter15.hashmap;

public class Student {

    public int sno;
    public String name;

    public Student(int sno, String name) {
        this.sno = sno;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return sno;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            if (this.sno == student.sno) {
                return true;
            }
        } else {
            return false;
        }

        return false;

    }

    @Override
    public String toString() {
        return "Student [sno=" + sno + ", name=" + name + "]";
    }

}
