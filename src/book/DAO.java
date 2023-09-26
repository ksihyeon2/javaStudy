package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	memberVO membervo = null;

	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/javaProject2";
			String user = "root";
			String pw = "1234";
			
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 검색 오류 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 연동 오류 : " + e.getMessage());
		}
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}
	
	public void pstmtClose() {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
		} catch (Exception e) {}
	}
	
	public void rsClose() {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {}
		pstmtClose();
	}

//	회원 등록 
	public int memberInput(memberVO vo) {
		int res = 0;
		try {
			sql = "insert into member values (default,?,?,?,?,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getAge());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getPhonenum());
			pstmt.setString(7, vo.getAddress());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DB 연동 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

//	회원 조회(중복 배제)
	public memberVO memberSearch(String id) {
		membervo = new memberVO();
		try {
			sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				membervo.setId(id);
				membervo.setPw(rs.getString("pw"));;
				System.out.println(rs.getString("pw"));
//				membervo.setName(rs.getString("name"));
//				membervo.setAge(rs.getInt("age"));
//				membervo.setEmail(rs.getString("email"));
//				membervo.setPhonenum(rs.getString("phonenum"));
//				membervo.setAddress(rs.getString("address"));
//				membervo.setEntry(rs.getString("entry"));
			}
		} catch (SQLException e) {
			System.out.println("DB 연동 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return membervo;
	}

//	로그인
	public int memberLogin(String id, String pw) {
		int res = 0;
		try {
			sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				membervo.setId(id);
			}
		} catch (SQLException e) {
			System.out.println("DB 연동 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return res;
	}


}
