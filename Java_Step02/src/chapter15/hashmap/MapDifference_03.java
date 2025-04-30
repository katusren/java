package chapter15.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapDifference_03 {

    public static void main(String[] args) {

        // HaspMap 객체 생성 및 데이터 추가
        Map<String, String> haspMap = new HashMap<>();

        haspMap.put("apple", "red");
        haspMap.put("banana", "yello");
        haspMap.put("grape", "purple");
        haspMap.put("orange", "orange");

        //
        System.out.println("=====HaspMap 출력(순서 보장되지 않음)=====");
        for (Map.Entry<String, String> entry : haspMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // LinkedHashMap 객체 생성 및 데이터 추가
        Map<String, String> linkedHaspMap = new LinkedHashMap<>();

        linkedHaspMap.put("apple", "red");
        linkedHaspMap.put("banana", "yello");
        linkedHaspMap.put("grape", "purple");
        linkedHaspMap.put("orange", "orange");

        //
        System.out.println("=====linkedHaspMap 출력(입력된 순서에 따라 순서가 보장됨)=====");
        for (Map.Entry<String, String> entry : linkedHaspMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
