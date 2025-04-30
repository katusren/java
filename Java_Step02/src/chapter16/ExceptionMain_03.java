package chapter16;

public class ExceptionMain_03 {

    public static void main(String[] args) {

        String[] sarr = { "soldesk", "developer", "course" };

        for (int i = 0; i <= sarr.length; i++) {
            try {
                System.out.println(sarr[i]);
            } catch (Exception e) {
                System.out.println("예외 발생");
                System.out.println(e.getMessage());
            } finally {
                // 에러 상황과 상관없이 무조건 실행
                System.out.println("무조건 실행");
            }
        }
        System.out.println("program end");
    }
}
