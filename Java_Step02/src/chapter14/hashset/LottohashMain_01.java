package chapter14.hashset;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class LottohashMain_01 {

    public static void main(String[] args) {

        // HashSet<Integer> lotto = new HashSet<>();
        TreeSet<Integer> lotto = new TreeSet<>();

        while (true) {

            int v = new Random().nextInt(45) + 1;

            lotto.add(v);

            if (lotto.size() >= 6) {
                break;
            }
        }

        System.out.println(lotto);
    }
}
