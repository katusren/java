package DBTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/sys"; // DB 주소
        String user = "root"; // MariaDB 사용자명
        String password = "12345"; // MariaDB 비밀번호

        try {
            // JDBC 드라이버 로드
            Class.forName("org.mariadb.jdbc.Driver");

            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("MariaDB 연결 성공!");

            // 연결 종료
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 실패!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("MariaDB 연결 실패!");
            e.printStackTrace();
        }
    }
}
