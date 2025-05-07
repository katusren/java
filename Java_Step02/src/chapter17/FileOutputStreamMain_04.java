package chapter17;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamMain_04 {

    public static void main(String[] args) {
        // 파일 경로 설정
        String filePath = "outputstream.txt";
        String data = "Hello, this is a test of FileOutputStream.";

        // FileOutputStream: 데이터 쓰기
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            // 문자열 데이터를 바이트 배열로 변환하여 파일에 저장
            fos.write(data.getBytes());
            System.out.println("파일에 데이터가 성공적으로 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일 쓰는 도중 오류 발생");
        }
    }
}
