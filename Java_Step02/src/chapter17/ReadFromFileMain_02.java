package chapter17;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFromFileMain_02 {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            System.out.println("파일내용");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
