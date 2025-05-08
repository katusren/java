package chapter18.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationMain_05 {

    public static void main(String[] args) {

        Student[] stuArr = { new Student(1, "홍길동", 85), new Student(2, "이범석", 77), new Student(3, "김홍석", 84),
                new Student(4, "최민호", 56), new Student(5, "김수정", 66), new Student(6, "최혜진", 79) };

        // Stream<Student> stream = Stream.of(stuArr).flatMap(Arrays::stream);

        // 학생 이름만 추출 후 리스트에 저장
        List<String> names = Stream.of(stuArr) // 스트림으로 변환
                .map(Student::getName) // 이름만 추출
                .collect(Collectors.toList()); // 최종 리스트로 반환

        System.out.println(names);

        // 영어점수 추출 후 리스트에 저장
        List<Integer> engs = Stream.of(stuArr) // 스트림으로 변환
                .map(Student::getEng) // 점수만 추출
                .collect(Collectors.toList()); // 최종 리스트로 반환

        System.out.println(engs);

        // 영어점수 추출 후 리스트에 저장
        List<String> engs70 = Stream.of(stuArr)
                .filter(s -> s.getEng() >= 70)
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println(engs70);
    }
}
