package chapter17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStreamMain_04 {

    public static void main(String[] args) {
        // FileIOStream: 1byte -> 인코딩("UTF-8")
        // FileInputStream(바이트 단위로 읽기), FileOutputStream(바이트 단위로 쓰기)
        // 이미지, 오디오, 영상등의 파일을 바이너리 코드로 변환하여 입력 또는 출력

        String data = "Hello, this is a test of"
                + " FileInputStream and FileOutputStream.";
        String filePath = "IOStream.txt";

        // FileOutputStream을 사용하여 파일에 데이터 저장
        try (FileOutputStream fos = new FileOutputStream(filePath)) {

            fos.write(data.getBytes()); // 1byte 로 쓰므로 인코딩이 필요하다
            System.out.println("파일에 데이터가 성공적으로 저장되었습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // -----------------------------------

        // FileInputStream을 사용하여 파일에서 데이터 읽기
        try (FileInputStream fis = new FileInputStream(filePath)) {

            int content;
            System.out.println("---파일 데이터---");
            while ((content = fis.read()) != -1) {
                System.out.println((char) content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
