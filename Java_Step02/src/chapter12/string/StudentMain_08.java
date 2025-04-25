package chapter12.string;

public class StudentMain_08 {

    public static void main(String[] args) {
        Student studentLee = new Student(100, "이상우");
        Student studentLee2 = new Student(100, "이진우");

        System.out.println("------동일한 주소의 두 인스턴스 비교-------");

        if (studentLee == studentLee2) // 물리적인 주소
            System.out.println("true");
        else
            System.out.println("false");

        if (studentLee.equals(studentLee2)) // 논리적인 주소
            System.out.println("true");
        else
            System.out.println("false");

        System.out.println("=============데이터 값 출력==============");
        System.out.println("studentLee의 hashCode: " + studentLee);
        System.out.println("studentLee2의 hashCode: " + studentLee2);
        System.out.println();

        System.out.println("=============hash코드값 출력==============");
        System.out.println("studentLee의 실제 주소값: " + System.identityHashCode(studentLee));
        System.out.println("studentLee2의 실제 주소값: " + System.identityHashCode(studentLee2));
        System.out.println();

        System.out.println("----------------------");
        String str1 = new String("test");
        String str2 = new String("test");

        System.out.println("str1의 hashCode: " + str1.hashCode());
        System.out.println("str2의 hashCode: " + str2.hashCode());

    }
}
