package chapter14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PersonManager {

    public void personMgr() {

        int select;
        Person p; // 미리선언

        // Person 객체들만 저정할 ArrayList 생성
        ArrayList<Person> personarr = new ArrayList<Person>();

        while (true) {
            System.out.print("(1)회원가입, (2)정보삭제, (3)정보검색, (4)종료: ");

            Scanner scar = new Scanner(System.in);
            select = scar.nextInt();

            switch (select) {
                case 1: { // 회원가입
                          // personarr 객체에 Person 클래스의 객체를 추가
                    p = new Person();

                    System.out.println("---정보를 추가합니다---");
                    System.out.print("이름: ");
                    p.setName(scar.next());
                    System.out.print("나이: ");
                    p.setAge(scar.nextInt());
                    System.out.print("전화번호: ");
                    p.setTel(scar.next());

                    personarr.add(p);
                    System.out.println("회원 가입 완료");
                    break;
                }
                case 2: { // 정보삭제
                    System.out.println("---정보를 삭제합니다---");
                    System.out.print("탈퇴회원 이름: ");
                    String name = scar.next();

                    for (int i = 0; i < personarr.size(); i++) {
                        if (personarr.get(i).getName().equals(name)) {
                            personarr.remove(i);
                            System.out.println(name + "님의 정보가 삭제되었습니다.");
                            break;
                        } else {
                            if (i + 1 == personarr.size()) {
                                System.out.println(name + "님의 정보가 존재하지않습니다.");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 3: { // 정보검색
                    System.out.println("---정보를 출력합니다---");
                    System.out.println("등록인원은 " + personarr.size() + "명 입니다.");

                    Iterator<Person> it = personarr.iterator();
                    while (it.hasNext()) {
                        p = it.next();

                        System.out.print("이름: " + p.getName());
                        System.out.print("\t나이: " + p.getAge());
                        System.out.print("\t전화번호: " + p.getTel() + "\n");
                        System.out.println("-----------------------");
                    }
                    break;
                }
                default:
                    System.out.println("프로그램 종료");
                    return;
            }

        } // while

    }// 메서드

}// class
