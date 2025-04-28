package chapter13;

public class GenericContainerMain {

    public static void main(String[] args) {
        // 문자열 아이템을 저장하는 객체
        GenericContainer<String> stringContainer = new GenericContainer<String>(5);

        stringContainer.addItem("Apple");
        stringContainer.addItem("Banana");
        stringContainer.addItem("Cherry");
        stringContainer.addItem("DIYTool");
        stringContainer.addItem("Elf");
        stringContainer.printItems();

        // 타입제한으로 사용 불가능
        // String[] StringaArray = { "1", "2", "3", "4", "5" };
        // stringContainer.sum(StringaArray);

        // 정수형 아이템을 저장하는 객체
        GenericContainer<Integer> intContainer = new GenericContainer<Integer>(5);

        intContainer.addItem(45);
        intContainer.addItem(67);
        intContainer.addItem(88);
        intContainer.addItem(100);
        intContainer.addItem(999);
        intContainer.printItems();

        Integer[] IntegeraArray = { 1, 2, 3, 4, 5 };
        intContainer.sum(IntegeraArray);
        System.out.println("Sum of int array: " + intContainer.sum(IntegeraArray));

        // 실수형 아이템을 저장하는 객체
        GenericContainer<Double> doublGenericContainer = new GenericContainer<Double>(5);

        doublGenericContainer.addItem(45.1);
        doublGenericContainer.addItem(6.19);
        doublGenericContainer.addItem(5.18);
        doublGenericContainer.addItem(12.3);
        doublGenericContainer.addItem(6.15);
        doublGenericContainer.printItems();

        Double[] DoubleaArray = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        doublGenericContainer.sum(DoubleaArray);
        System.out.println("Sum of double array: " + doublGenericContainer.sum(DoubleaArray));

    }
}
