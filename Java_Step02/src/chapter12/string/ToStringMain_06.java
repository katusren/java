package chapter12.string;

import java.util.Date;

public class ToStringMain_06 {
    public static void main(String[] args) {
        
        Object obj1 = new Object();
        Date obj2 = new Date();

        System.out.println("Object: "+obj1.toString()); // 재정의가 안되어 있음
        System.out.println(obj2);
    }
}
