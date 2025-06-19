package kr.project;

import org.json.JSONArray;
import org.json.JSONObject;

public class Project01B {

    public static void main(String[] args) {

        // JSON -> JAVA(org.json)
        JSONArray students = new JSONArray();

        JSONObject student = new JSONObject();
        student.put("name", "솔자바");
        student.put("phone", "02-1234-5678");
        student.put("address", "종로구 관철동");
        System.out.println(student);
        students.put(student);

        student.put("name", "박수");
        student.put("phone", "02-1234-9874");
        student.put("address", "강남구 한남동");
        System.out.println(student);
        students.put(student);

        System.out.println(students);
        System.out.println(students.toString(2));

        JSONObject object = new JSONObject();
        object.put("stinfo", student);
        System.out.println(object);
        System.out.println(object.toString(2));
    }
}
