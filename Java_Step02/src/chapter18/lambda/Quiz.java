package chapter18.lambda;

@FunctionalInterface
interface Myfunction {
    public int square(int x);
}

public class Quiz {

    public static void main(String[] args) {
        Myfunction sqr = (x) -> x * x;
        System.out.println(sqr.square(5));
    }
}
