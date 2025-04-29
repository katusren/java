package chapter14.linkList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedList_01 {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

        long startTime1;
        long endTime1;

        startTime1 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list1.add(0, String.valueOf(i));
        }

        endTime1 = System.nanoTime();

        System.out.println("ArrayList 작업시간: " + (endTime1 - startTime1) + "ns");
        // -------------------------------------

        long startTime2;
        long endTime2;

        startTime2 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list2.add(0, String.valueOf(i));
        }

        endTime2 = System.nanoTime();

        System.out.println("LinkList 작업시간: " + (endTime2 - startTime2) + "ns");
    }
}
