package chapter15.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapMain_02 {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        // id:key | 비번:value
        map.put("Spring", "123");
        map.put("Summer", "1234");
        map.put("Fall", "12345");
        map.put("Winter", "123456");

        Scanner scar = new Scanner(System.in);

        while (true) {
            System.out.println("아이디와 비밀번호를 입력하세요!");
            System.err.print("아이디: ");
            String id = scar.next();

            // 입력한 아이디 존재여부
            if (map.containsKey(id)) {
                // 비번 받기
                System.out.print("비밀번호: ");
                String pw = scar.next();

                // 비번 일치여부
                if (map.get(id).equals(pw)) {
                    System.out.println("로그인 성공!");
                    break;
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다.");
                    System.out.println();
                }
            } else {
                System.out.println("입력하신 아이디는 존재하지 않습니다.\n");
            }
        }
    }
}
