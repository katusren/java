package chapter13;

public class GeneralNoGenericMain {

    public static void main(String[] args) {
        // general
        General general = new General();

        // 정수형 배열
        Integer[] iArr = { 10, 20, 30, 40, 50 };
        general.printArr(iArr);

        Double[] dArr = { 10.1, 20.2, 30.3, 40.4, 50.5 };
        general.printArr(dArr);

        Character[] cArr = { 'A', 'B', 'C', 'D', 'E' };
        general.printArr(cArr);
    }
}
