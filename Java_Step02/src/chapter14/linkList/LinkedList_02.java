package chapter14.linkList;

import java.util.LinkedList;
import java.util.List;

public class LinkedList_02 {

    public static void main(String[] args) {

        LinkedList<String> myList = new LinkedList<>();

        myList.add("A");
        myList.add("B");
        myList.add("C");

        System.out.println(myList);
        myList.add(1, "D");
        System.out.println(myList);

        myList.addFirst("O");
        System.out.println(myList);
        System.out.println(myList.removeLast());
        System.out.println(myList);

    }
}
