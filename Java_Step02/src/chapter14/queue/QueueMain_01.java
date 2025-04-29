package chapter14.queue;

import java.util.ArrayList;

class MyQueue {

    ArrayList<String> arrayQueue = new ArrayList<>();

    public void enQueue(String data) {
        arrayQueue.add(data);
    }

    public String deQueue() {
        int len = arrayQueue.size();

        if (len == 0) {
            System.out.println("큐가 비어있습니다.");
            return null;
        }
        return arrayQueue.remove(0);
    }

    @Override
    public String toString() {
        return arrayQueue.toString();
    }

}

public class QueueMain_01 {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.enQueue("A");
        queue.enQueue("B");
        queue.enQueue("C");

        System.out.println(queue.toString());

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.toString());

    }
}
