package chapter14.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetMain_02 {

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        // 요소 추가
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");

        hashSet.add("Apple");

        System.out.println("HashSet: " + hashSet);

        if (hashSet.contains("Banana")) {
            System.out.println("Banana is in the HashSet");
        }

        // 요소 삭제
        hashSet.remove("Orange");
        System.out.println("After remove: " + hashSet);
    }
}
