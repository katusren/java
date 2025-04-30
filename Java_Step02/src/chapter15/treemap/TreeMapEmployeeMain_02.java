package chapter15.treemap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapEmployeeMain_02 {

    public static void main(String[] args) {
        TreeMap<Integer, Employee> employeeMap = new TreeMap<>();

        employeeMap.put(101, new Employee("Alice", 30));
        employeeMap.put(102, new Employee("Bob", 25));
        employeeMap.put(103, new Employee("Charile", 35));
        employeeMap.put(104, new Employee("David", 28));
        employeeMap.put(104, new Employee("Elie", 40));

        // 출력
        System.out.println("===근로자 성적 출력(이름순 정렬)===");
        for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + "| NAME: " + entry.getValue());
        }

        // 특정 직원 정보 조회
        int emplyoeeId = 103;
        System.out.println("\n" + emplyoeeId + "의 직원 정보: " + employeeMap.get(emplyoeeId));

    }
}
