package chapter14.treeset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorEmployeeMain_04 {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Charlie", 35));
        employees.add(new Employee("Bob", 27));
        employees.add(new Employee("Alice", 30));

        Collections.sort(employees, new NameComparator());
        System.out.println("이름을 기준으로 오름차순 정렬");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Collections.sort(employees, new AgeComparator());
        System.out.println("나이를 기준으로 오름차순 정렬");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
