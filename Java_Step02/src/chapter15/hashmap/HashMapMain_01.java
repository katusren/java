package chapter15.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapMain_01 {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("김우진", 85);
        map.put("이수정", 90);
        map.put("박진영", 98);
        map.put("정하나", 75);
        System.out.println("총 Entry 수: " + map.size());

        // 객체 찾기
        System.out.println("\n이수정: " + map.get("이수정"));
        System.out.println();

        // 객체 키 모두 받기
        Set<String> ketSet = map.keySet();
        // iterator 라는 반복구조로 형변환
        Iterator<String> keyIterator = ketSet.iterator();

        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            Integer value = map.get(key);
            System.out.println(key + ": " + value);
        }

        map.clear();
        System.out.println("총 Entry 수: " + map.size());
    }
}
