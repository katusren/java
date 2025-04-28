package chapter13;

public class GenericContainer<T> {

    private T[] items; // int[] i
    private int count;

    // 기본생성자 생략

    public GenericContainer(int size) {
        items = (T[]) new Object[size];
        count = 0;
    }

    public void addItem(T item) {

        if (count < items.length) {
            // itmes[count] = item;
            // count++;
            items[count++] = item;
        } else {
            System.out.println("Container is full");
        }
    }

    public void printItems() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i] + " ");
        }
        System.out.println();
    }

    public <E extends Number> double sum(E[] numbers) {
        double total = 0;
        for (E number : numbers) {
            total += number.doubleValue();
        }

        return total;
    }
}
