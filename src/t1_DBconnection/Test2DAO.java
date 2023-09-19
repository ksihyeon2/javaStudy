package t1_DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Test2DAO {
	Connection conn = null;
	
	public Test2DAO() {
		try {
//		1. 드라이버 검색
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 검색 성공");
			
//		2. 데이터 베이스 연결
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공");
			
//			드라이버 에러 잡기
		} catch (ClassNotFoundException e) {     // class 찾기 에러라 ClassNotFound로 바꿔줌
			System.out.println("드라이버 검색 실패 : " + e.getMessage());
			
//			데이터 베이스 연결 에러 잡기
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패 : " + e.getMessage());
		}
	}

//	try catch 밖에 생성해야 함
//	conn객체 close (예외처리 필수)
	public void connClose() {
		try {
			conn.close();
			System.out.println("conn객체가 닫혔습니다.");
		} catch (SQLException e) {}
	}
}
