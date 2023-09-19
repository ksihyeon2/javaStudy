package t2_hoiwon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class HoiwonDAO {
	Connection conn = null;
//	Connection : database 담는 명령어
	
	public HoiwonDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password); 
					
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패 " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 연결 실패" + e.getMessage());
		}
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}

//	전체 회원 조회하기
	public void getList() {
//	statement 객체 > sql 명령 실행
		try {
			Statement stmt = conn.createStatement();
//			conn에 담아있는 DB를 statement로 읽어서 stmt에 담음
			String qul = "select * from hoiwon";
			
			ResultSet rs = stmt.executeQuery(qul);   // record 조회
//			resultset(= recodeset) : 모든 record를 반환받는 명령어
//			rs 는 BOF에서 시작 
			
			rs.next(); // BOF부터 그 다음 순으로 넘어가면서 데이터 찾음
			System.out.println("번호 : " + rs.getInt("idx"));
			System.out.println("성명 : " + rs.getString("name"));
			System.out.println("나이 : " + rs.getInt("age"));
			System.out.println("주소 : " + rs.getString("address"));
			System.out.println("성별 : " + rs.getString("gender"));  // DB에서 char타입은 문자열을 의미 == java 에서 String으로 쓰면 됨
			System.out.println();
			
			rs.next(); // BOF부터 그 다음 순으로 넘어가면서 데이터 찾음
			System.out.println("번호 : " + rs.getInt("idx"));
			System.out.println("성명 : " + rs.getString("name"));
			System.out.println("나이 : " + rs.getInt("age"));
			System.out.println("주소 : " + rs.getString("address"));
			System.out.println("성별 : " + rs.getString("gender"));
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}
	}
}
