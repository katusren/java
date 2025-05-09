package chapter20;

public class DaemonThread_09 implements Runnable {

    static boolean autoSave = false;

    public static void main(String[] args) {

        DaemonThread_09 dm = new DaemonThread_09();
        Thread t = new Thread(dm); // run()을 start()로 변환
        // 데몬 스레드는 메인 스레드가 종료되면 자동 종료
        t.setDaemon(true); // 데몬 스레드로 변환
        t.start(); // 데몬 스레드 실행

        for (int i = 0; i < 15; i++) {
            // 메인스레드
            try {
                Thread.sleep(1000); // 1초
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(i);
            if (i == 3) {
                autoSave = true;
            }
        }

    }

    // -------------------------------------
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000); // 3초
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (autoSave) {
                System.out.println("자동저장 됩니다.");
            }
        }
    }
}
