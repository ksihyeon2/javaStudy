package t8_sungjuk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SungjukDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	SungjukVO vo = null;
	
	public SungjukDAO() {
		
		String url = "jdbc:mysql://localhost:3306/javaProject";
		String user = "atom";
		String password = "1234";
		
		try {
//			1. 드라이버 검색
			Class.forName("com.mysql.jdbc.Driver");
			
//			2.DB 검색(연결/연동)
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 검색 실패 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 연동 실패 : " + e.getMessage());
		}
	}
	
//	conn 객체 close
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

//	성적 자료 등록처리
	public int setInput(SungjukVO vo) {
		int res = 0;
		
		try {
			sql = "insert into sungjuk values (default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return res;
	}

	public ArrayList<SungjukVO> getList() {
		ArrayList<SungjukVO> vos = new ArrayList<SungjukVO>();
		
		try {
			sql = "select * from sungjuk order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new SungjukVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

//	개별 조회 처리
	public SungjukVO getSearch(String name) {
		vo = new SungjukVO();	
		try {
			sql = "select * from sungjuk where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
			} 			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	
//	수정
	public void setUpdate(String name, int kor, int eng, int mat) {
		try {
			sql = "update Sungjuk set kor=?, eng=?, mat=? where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, kor);
			pstmt.setInt(2, eng);
			pstmt.setInt(3, mat);
			pstmt.setString(4, name);
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
	}
	
	public void setDelete(String name) {
		try {
			sql = "delete from Sungjuk where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
	}	
}
