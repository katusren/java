package chapter14.vector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorCapacity_01 {

    public static void main(String[] args) {
        // Vector 방식: 동기화 즉 멀티스레드에서 사용
        // 최근에는 ArrayList를 기본으로 사용하고 synchronizedList를 추가하여 사용

        // 구버전: Vector 생성(기본용량 10)
        Vector<String> vector = new Vector<>();
        // ArrayList를 synchronizedList로 추가
        // List<String> syscList = Collections.synchronizedList(new ArrayList<>());

        System.out.println("-------------기본 크기----------------");
        System.out.println("초기 크기: " + vector.size());
        System.out.println("초기 용량: " + vector.capacity());

        // 데이터 추가
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");

        System.out.println("-------------데이터 3개 증가 후 크기----------------");
        System.out.println("초기 크기: " + vector.size());
        System.out.println("초기 용량: " + vector.capacity());
        System.out.println(vector);

        for (int i = 0; i < 8; i++) {
            vector.add("Fruit" + (i + 1));
        }

        // 용량 초과 시 기존 크기 2배 증가
        System.out.println("-------------데이터 11개 증가 후 크기----------------");
        System.out.println("초기 크기: " + vector.size());
        System.out.println("초기 용량: " + vector.capacity());
        System.out.println(vector);
    }
}
