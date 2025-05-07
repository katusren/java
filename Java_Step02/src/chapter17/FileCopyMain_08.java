package chapter17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyMain_08 {

    public static void main(String[] args) {
        // 복사할 원본 파일
        String sourceFilePath = "source01.txt";
        // 버퍼 없이 복사할 파일
        String destFilePathWithoutBuffer = "dest_without_buffer.txt";
        // 버퍼를 사용하여 복사할 파일
        String destFilePathWithBuffer = "dest_with_buffer.txt";

        // 원본 파일 생성 코드(10MB의 데이터 생성)
        createTestFile(sourceFilePath, 1024 * 1024 * 10); // 10MB

        // 버퍼를 사용하지 않고 파일 복사
        long startTime = System.nanoTime(); // 복사 시작
        copyWithoutBuffer(sourceFilePath, destFilePathWithoutBuffer);
        long endTime = System.nanoTime(); // 복사 끝

        long durationWithOutBuffer = endTime - startTime;
        System.out.println("버퍼 사용하지 않고 복사시 소요 시간: " + durationWithOutBuffer / 1000000 + "ms");

        // 버퍼를 사용하여 않고 파일 복사
        startTime = System.nanoTime(); // 복사 시작
        copyWithoutBuffer(sourceFilePath, destFilePathWithBuffer);
        endTime = System.nanoTime(); // 복사 끝

        long durationWithBuffer = endTime - startTime;
        System.out.println("버퍼 사용하여 복사시 소요 시간: " + durationWithBuffer / 1000000 + "ms");
    }

    // 원본 파일 생성
    public static void createTestFile(String filePath, int sizeInBytes) {

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {

            byte[] data = new byte[sizeInBytes];
            bos.write(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 버퍼 없이 복사
    public static void copyWithoutBuffer(String source, String dest) {

        try (FileInputStream bis = new FileInputStream(source);
                FileOutputStream bos = new FileOutputStream(dest)) {

            // BufferedInputStream 사용시 용량지정 가능
            byte[] buffer = new byte[1024]; // 1KB 버퍼
            int bytesData;
            // 원본 파일에서 데이터를 읽어 복사 파일에 쓰기
            while ((bytesData = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesData);
            }
            System.out.println("파일이 성공적으로 복사되었습니다.");
        } catch (Exception e) {
            System.err.println("파일 복사 중 오류 발생");
        }
    }

    // 버퍼를 사용하여 복사
    public static void copyWithBuffer(String source, String dest) {

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            // BufferedInputStream 사용시 용량지정 가능
            byte[] buffer = new byte[1024]; // 1KB 버퍼
            int bytesData;
            // 원본 파일에서 데이터를 읽어 복사 파일에 쓰기
            while ((bytesData = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesData);
            }
            System.out.println("파일이 성공적으로 복사되었습니다.");
        } catch (Exception e) {
            System.err.println("파일 복사 중 오류 발생");
        }
    }
}
