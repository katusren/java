package chapter19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_01 {

    public static void main(String[] args) {

        Connection con = null;

        try {
            // 1. JDBC 드라이버 로드
            Class.forName("oracle.jdbc.OracleDriver");

            // 2. Connection 읽기
            String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 연결 코드
            String user = "system";
            String password = "12345";

            con = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스 연동 성공");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
