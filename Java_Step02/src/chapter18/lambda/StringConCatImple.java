package chapter18.lambda;

public class StringConCatImple implements StringConcat {

    @Override
    public void makeString(String s1, String s2) {
        System.err.println(s1 + ", " + s2);
    }

}
