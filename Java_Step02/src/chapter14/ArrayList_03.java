package chapter14;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList_03 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();

        list.add("신인철");
        list.add("김관호");
        list.add("문원주");
        list.add("임해균");
        list.add("유연우");

        for (String name : list) {
            System.out.println(name);
        }

        System.out.println("아이들팀 전체: " + list);
        System.out.println("==================");

        // 반복자
        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            String v = it.next();
            System.out.print(v + " ");
        }
    }
}
