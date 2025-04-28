package chapter13;

public class GeneralNoGeneric {

    // 멤버 변수

    // 생성자

    // 메서드

    // 정수 배열 출력 메서드
    public void printIntArr(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(" " + arr[i]);
        }
        System.out.println();
    }

    // 실수 배열 출력 메서드
    public void printDoubleArr(Double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(" " + arr[i]);
        }
        System.out.println();
    }

    // 문자 배열 출력 메서드
    public void printCharArr(Character[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(" " + arr[i]);
        }
        System.out.println();
    }
}
