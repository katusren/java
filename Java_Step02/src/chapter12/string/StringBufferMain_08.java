package chapter12.string;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StringBufferMain_08 {

    public static void main(String[] args) throws ClassNotFoundException {
        StringBuffer buf = new StringBuffer("Nice Day Nice Day Nice Day Nice Day Nice Day");
        System.out.println(buf.toString());
        System.out.println(buf.length()); // 8글자
        System.out.println(buf.capacity()); // 기본용량 16 + 8

        buf.insert(0, "Hi ");
        System.out.println(buf.toString());

        buf.insert(11, " Everybody! ");
        System.out.println(buf.toString());

        buf.delete(0, 5);
        System.out.println(buf.toString());

        StringBuilder sb = new StringBuilder();
        sb.ensureCapacity(50); // 50만큼 용량 할당

        Student student = new Student();
        System.out.println(student);

        // 클래스 정보를 가져오는 객체로 변환
        Class sClass = Class.forName("chapter12.string.Student");
        System.out.println(sClass);

        Constructor[] cons1 = sClass.getConstructors();
        for (Constructor c : cons1) {
            System.out.println(c);
        }

        Field[] field = sClass.getFields();
        for (Field f : field)
            System.out.println(field);

        Method[] method1 = sClass.getMethods();
        for (Method m : method1) {
            System.out.println(m);
        }
    }

}
