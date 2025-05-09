package chapter19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserAdd_02 {

    public static void main(String[] args) {

        Connection con = null;

        try {
            // 1. JDBC 드라이버 로드
            Class.forName("oracle.jdbc.OracleDriver");

            // 2. Connection 읽기
            String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 연결 코드
            String user = "member";
            String password = "12345";

            con = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스 연동 성공");

            // 3. usertbl 입력
            String sql = "insert into usertbl(userid,name,password,age,email)";
            sql += "values(?,?,?,?,?)";

            // 4. PreparedSatatement로 String -> sql
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "spring");
            pstmt.setString(2, "봄");
            pstmt.setString(3, "12345");
            pstmt.setInt(4, 27);
            pstmt.setString(5, "spring@spring.com");

            // 5. 실행
            int rows = pstmt.executeUpdate(); // insert into 문 실행
            System.out.println("입력된 회원 수: " + rows);

            pstmt.close();

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
