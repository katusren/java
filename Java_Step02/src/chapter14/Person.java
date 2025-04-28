package chapter14;

public class Person {

    // 한 사람의 정보를 담당하는 클래스
    private String name;
    private int age;
    private String tel;

    // 생성자 생략

    // 메서드
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
