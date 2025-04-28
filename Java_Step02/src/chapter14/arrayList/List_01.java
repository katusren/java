package chapter14.arrayList;

import java.util.ArrayList;
import java.util.List;

public class List_01 {

    public static void main(String[] args) {
        // ArrayList<String> student = new ArrayList<String>();
        List<String> students = new ArrayList<String>();

        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");
        students.add("Diana");

        // 학생출력
        System.out.println("===Student in the list===");
        for (String student : students) {
            System.out.println(student);
        }

        // 특정 학생을 제거
        students.remove("Bob");

        // 학생출력
        System.out.println("\n===After removing list===");
        for (String student : students) {
            System.out.println(student);
        }

    }
}
