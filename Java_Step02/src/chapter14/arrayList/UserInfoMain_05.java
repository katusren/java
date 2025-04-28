package chapter14.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInfoMain_05 {

    public static void main(String[] args) {

        // UserInfo타입의 ArrayList -> arr
        ArrayList<UserInfo> arr = new ArrayList<UserInfo>();

        outer: while (true) {
            Scanner scar = new Scanner(System.in);
            System.out.print("아이디 생성(exit 입력시 종료): ");

            String id = scar.next();

            UserInfo ui = new UserInfo();
            ui.setId(id);

            // exit 입력시
            if (ui.getId().equals("exit")) {
                System.out.println("시스템이 종료됩니다.");
                break;
            }

            // 아이디 중복 입력시 메시지 출력후 무시후(continue outer) 다시 입력 시도
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId().equals(id)) { // ui.getId().equals()
                    System.out.println("동일한 아이디가 존재합니다.");
                    continue outer;
                }
            }

            System.out.print("패스워드 입력: ");
            ui.setPwd(scar.nextInt());

            arr.add(ui);

            for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i).getId());
                System.out.println(arr.get(i).getPwd());
                System.out.println();
            }
            System.out.println("---------------");

        } // while

    }// main

}// class
