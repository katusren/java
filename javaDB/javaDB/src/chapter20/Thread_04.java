package chapter20;

class Counter {

    private int count = 0;

    synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

}

public class Thread_04 {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread();
        Thread thread2 = new Thread();

        thread1.start();
        thread2.start();

        System.out.println(counter.getCount());
    }
}
