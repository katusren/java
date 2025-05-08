package chapter17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Serializable: 직렬화(바이너리로 형변환)
class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "이름: " + name + ", 나이: " + age;
    }
}

public class ObjectOutputStream_10 {

    public static void main(String[] args) throws ClassNotFoundException {

        String filePath = "person.dat";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {

            Person person = new Person("솔데스크", 15);
            oos.writeObject(person); // 직렬화 필수
            System.out.println("객체가 성공적으로 저장되었습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // ObjectOutputStream을 사용하여 객체 읽기
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {

            Person person = (Person) ois.readObject();

            System.out.println("Person 객체 읽기: " + person);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
