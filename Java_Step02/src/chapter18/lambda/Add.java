package chapter18.lambda;

// 추상메서드가 하나만 존재하는 인터페이스
@FunctionalInterface
public interface Add {

    public int add(int x, int y);
}
