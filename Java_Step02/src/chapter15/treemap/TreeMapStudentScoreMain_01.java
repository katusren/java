package chapter15.treemap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapStudentScoreMain_01 {

    public static void main(String[] args) {
        TreeMap<String, Integer> studentScore = new TreeMap<>();

        // 입력
        studentScore.put("David", 95);
        studentScore.put("Bob", 92);
        studentScore.put("Alice", 85);
        studentScore.put("Charile", 78);
        System.out.println("===학생 성적 출력(이름순 정렬)===");
        for (Map.Entry<String, Integer> entry : studentScore.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 특정 학생의 이름으로 조회
        String studentName = "Bob";
        System.out.println("\n" + studentName + "의 성적: " + studentScore.get(studentName));

    }

}
