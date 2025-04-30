package chapter17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedReaderWriterMain_3 {

    public static void main(String[] args) {

        String filePath = "buffered_output.txt";

        String[] data = { "Hello, world!", "This is a test.", "Java I/O is interesting!" };

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

            for (String line : data) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("파일에 데이터가 성공적으로 저장되었습니다.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("파일을 쓰는 중 오류가 발생되었습니다.");
        }

        // BufferedReader로 파일 읽기
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("파일내용");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
