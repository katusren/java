package chapter19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userDAO {

    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // 드라이버 등록
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 데이터 베이스 연결 메서드
    public Connection getConnection() {

        try {

            String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 연결 코드
            String user = "member";
            String password = "12345";

            con = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    // 자원 반납
    public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (pstmt != null)
                pstmt.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 자원 반납
    public void select(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (pstmt != null)
                pstmt.close();
            if (con != null)
                con.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public userDTO select(String userid) {
        userDTO userDto = null;
        try {

            con = getConnection();

            String sql = "SELECT userid, name, password, age, email FROM  usertbl WHERE userid=?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userid);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                userDto = new userDTO();
                userDto.setUserid(rs.getString("userid"));
                userDto.setName(rs.getString("name"));
                userDto.setPassword(rs.getString("password"));
                userDto.setAge(rs.getInt("age"));
                userDto.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return userDto;
    }

    public int delete(String userid, String password) {

        int rows = 0;
        try {

            con = getConnection();

            String sql = "DELETE FROM userTBL WHERE userid = ? and password = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userid);
            pstmt.setString(2, password);

            rows = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return rows;
    }

    public int update(userDTO updateDto) {

        int rows = 0;
        try {

            con = getConnection();

            String sql = "UPDATE usertbl SET email = ? WHERE userid = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, updateDto.getEmail());
            pstmt.setString(2, updateDto.getUserid());

            rows = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return rows;
    }

    // 입력
    public int insert(userDTO updateDto) {

        int rows = 0;
        try {

            con = getConnection();

            String sql = "INSERT INTO usertbl(userid, name, password, age, email) ";
            sql += "VALUES (?,?,?,?,?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, updateDto.getUserid());
            pstmt.setString(2, updateDto.getName());
            pstmt.setString(3, updateDto.getPassword());
            pstmt.setInt(4, updateDto.getAge());
            pstmt.setString(5, updateDto.getEmail());

            rows = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return rows;
    }

}
