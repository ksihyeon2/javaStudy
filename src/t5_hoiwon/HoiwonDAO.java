package t5_hoiwon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HoiwonDAO {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String sql = "";
	HoiwonVO vo = null;//	기본적으로 전역변수 5개 생성해놓음
	
	public HoiwonDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
//			String url = "jdbc:mysql://192.168.50.20:3306/javaProject"; 
//			String url = "jdbc:mysql://127.0.0.1:3306/javaProject";
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다." + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 연동 실패" + e.getMessage());
		}
	}
	
//	conn 객체 close
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}
	
//	stmt 객체 close
//	delete, update 등은 rs를 사용하지 않기 때문에 stmt 객체 따로 만들어 줘야 함
	public void stmtClose() {
		try {
		  if(stmt != null)	stmt.close();
//		  작업에 오류가 catch 됐어도 그 다음 finally 동작은 진행되기 때문에 stmt가 닫혀버림 그럼 사용하지 않아도 계속해서 동작하기 때문에 메모리에 손실이 올 수 있음
//		  stmt의 초기값은 null이고 사용하지 않으면 null 이기 때문에 null 이 아닐때만 닫아야 함
		} catch (SQLException e) {}
	}
	
//	rs 객체 close
	public void rsClose() {
		try {
			if (rs != null) {
				rs.close();
				stmtClose();
			}
		} catch (Exception e) {}
	}

//	** 전체 회원 조회
	public ArrayList<HoiwonVO> getList() {
		ArrayList<HoiwonVO> vos = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			sql = "select * from hoiwon order by idx desc";  // 나중에 등록한 회원 우선 보기
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) { 
				HoiwonVO vo = new HoiwonVO();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getNString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddress(rs.getString("address"));
				vo.setGender(rs.getString("gender"));
			
				vos.add(vo);
			}
			
		} catch (SQLException e) {
//			System.out.println("SQL 문장 오류 : " + e.getMessage());
			e.printStackTrace(); // line 번호 출력
		} finally {
			rsClose();
		}
		return vos;
	}

//	개별 회원 조회
	public HoiwonVO getSearch(String name) {
		HoiwonVO vo = new HoiwonVO();
		
		try {
			
			stmt = conn.createStatement();
			sql = "select * from hoiwon where name = '"+name+"'";
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddress(rs.getString("address"));
				vo.setGender(rs.getString("gender"));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vo;
	}

//	회원 자료 삭제하기
	public void setDelete(String name) {
		
		try {
			stmt = conn.createStatement();
			sql = "delete from hoiwon where name ='"+name+"'";
			stmt.executeUpdate(sql); 
//			삭제 delete이기 때문에 그냥 삭제만 하면 돼서 따로 rs에 값을 안 받아도 됨
			
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		}	finally {
			stmtClose();
		}	
	}

//	회원가입 처리 (sql문 : insert)
//	public void setHoiwonInput(String name, int age, String address, int gender) {
	public int setHoiwonInput(HoiwonVO vo) {
		int res = 0;
		try {
//			sql = "insert into hoiwon (무조건 필요한 필드) values (테이블 설계 내용)";
//			테이블 설계 내용은 순서가 중요
			sql = "insert into hoiwon values (default,'"+vo.getName()+"',"+vo.getAge()+",'"+vo.getAddress()+"','"+vo.getGender()+"')";
			stmt = conn.createStatement();
			
			res = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		}	finally {
			stmtClose();
		} 
		return res;
	}

//	자료 수정 (sql문 : update)
	public int setHoiwonUpdate(String name, int age, String address, String strGender) {
		int res = 0;
		try {
			sql = "update hoiwon set age="+age+", address='"+address+"', gender='"+strGender+"' where name='"+name+"'";
			stmt = conn.createStatement();
			
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		}	finally {
			stmtClose();
		} 
		return res;
	}
	
}
