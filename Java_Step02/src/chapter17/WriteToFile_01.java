package chapter17;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class WriteToFile_01 {

    public static void main(String[] args) {

        Scanner scar = new Scanner(System.in);

        System.out.print("파일에 저장할 내용을 입력하세요: ");
        String content = scar.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write(content);
            System.out.println("내용이 파일에 저장되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("파일을 쓰는 중 오류가 발생되었습니다.");
        } finally {
            scar.close();
        }
    }
}
