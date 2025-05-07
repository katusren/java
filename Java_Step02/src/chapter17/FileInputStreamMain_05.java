package chapter17;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamMain_05 {

    public static void main(String[] args) {
        // 파일 경로 설정
        String filePath = "outputstream.txt";

        // FileOutputStream: 데이터 쓰기
        try (FileInputStream fis = new FileInputStream(filePath)) {

            int byteData;
            System.out.println("파일 내용");

            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일 읽는 도중 오류 발생");
        }
    }
}
