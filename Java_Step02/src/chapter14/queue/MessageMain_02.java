package chapter14.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MessageMain_02 {

    public static void main(String[] args) {
        Queue<Message> messageQueue = new LinkedList<>();

        Message Moon = new Message("sendMail", "문원주");
        messageQueue.offer(Moon);
        messageQueue.offer(new Message("sendSNS", "김영준"));
        messageQueue.offer(new Message("sendKakaotalk", "정동일"));

        while (!messageQueue.isEmpty()) {
            Message message = messageQueue.poll(); // poll() Queue의 출력(선입선출)

            switch (message.command) {
                case "sendMail": {
                    System.out.println(message.to + "님에게 메일을 보냈습니다.");
                    break;
                }
                case "sendSNS": {
                    System.out.println(message.to + "님에게 SNS를 보냈습니다.");
                    break;
                }
                case "sendKakaotalk": {
                    System.out.println(message.to + "님에게 카카오톡을 보냈습니다.");
                    break;
                }
            }
        }

    }
}
