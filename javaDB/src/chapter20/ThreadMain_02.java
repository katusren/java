package chapter20;

public class ThreadMain_02 {

    public static void main(String[] args) {

        Thread_02 t1 = new Thread_02(); // 0~9까지의 요소가 저장된 temp배열이 생성됨

        t1.start(); // Thread1: 소요시간이 10초

        // 스레드가 여러개일때는 시간차이를 두고 구현
        // Thread2
        try {
            Thread.sleep(6100); // 11초
            System.out.println("프로그램이 종료됩니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
