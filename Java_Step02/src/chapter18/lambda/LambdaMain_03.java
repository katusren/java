package chapter18.lambda;

@FunctionalInterface
interface MyFunctionInterface {
    void showMsg(String message);
}

public class LambdaMain_03 {

    public static void main(String[] args) {

        // 람다식 생성
        MyFunctionInterface f = s -> System.out.println(s);
        f.showMsg("람다식 생성");

        // 매개변수 람다식
        showMyMsg(f);
    }

    // ---------------------------
    public static void showMyMsg(MyFunctionInterface f) {
        f.showMsg("매개 변수로 사용되는 람다식");
    }
}
