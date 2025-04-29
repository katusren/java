package chapter14.treeset;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain_01 {

    public static void main(String[] args) {

        Set<String> treeSet = new TreeSet<>();

        // 요소 추가
        treeSet.add("Orange");
        treeSet.add("Banana");
        treeSet.add("Apple");

        // 중복이 허용되지 않음
        treeSet.add("Apple");

        System.out.println("treeSet: " + treeSet);

        if (treeSet.contains("Banana")) {
            System.out.println("Banana is in the treeSet");
        }

        // 요소 삭제
        treeSet.remove("Orange");
        System.out.println("After remove: " + treeSet);
    }
}
