package chapter15.hashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class HashMapMain_04 {

    public static void main(String[] args) {

        // Hashtable 객체 생성을 이용한 동기화 작업
        Hashtable<String, Integer> inventory = new Hashtable<>();

        // HashMap 객체 생성을 이용한 동기화 작업
        Map<String, Integer> unsafeMap = new HashMap<>();

        // 상품명과 재고 수량을 키와 값으로 Hashtable에 추가
        inventory.put("Apple", 50);
        inventory.put("Banana", 30);
        inventory.put("Orange", 20);
        inventory.put("Mango", 10);

        // 동기화 Map으로 변형
        Map<String, Integer> safeMap = Collections.synchronizedMap(unsafeMap);

        // 동기화
        synchronized (safeMap) {
            for (Map.Entry<String, Integer> table : inventory.entrySet()) {
                System.out.println(table.getKey() + ": " + table.getValue() + "개");
            }
        }

        // 상품 재고 출력
        System.out.println("=== 상품 재고 목록 ===");
        for (Map.Entry<String, Integer> table : inventory.entrySet()) {
            System.out.println(table.getKey() + ": " + table.getValue() + "개");
        }

        // 특정 상품의 재고 확인
        Scanner scar = new Scanner(System.in);
        System.out.print("\n재고를 확인할 상품명을 입력하세요: ");
        String product = scar.nextLine();

        if (inventory.containsKey(product)) {
            System.out.println(product + "의 재고는 " + inventory.get(product) + "개 입니다.");
        } else {
            System.out.println(product + "라는 상품은 존재하지 않습니다");
        }

        // 상품의 재고 업데이트
        System.out.print("\n재고를 업데이트할 상품명을 입력하세요: ");
        String updateProduct = scar.nextLine();

        if (inventory.containsKey(updateProduct)) {
            System.out.print("추가할 수량을 입력하세요: ");
            int addQuantity = scar.nextInt();
            inventory.put(updateProduct, inventory.get(updateProduct) + addQuantity);
            System.out.println(updateProduct + "의 재고는 현재 " + inventory.get(updateProduct) + "개 입니다.");
        } else {
            System.out.println(updateProduct + "라는 상품은 존재하지 않습니다");
        }
    }

}
