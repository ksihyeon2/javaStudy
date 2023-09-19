package t1_DBconnection;

import java.sql.DriverManager;
import java.sql.SQLException;

// DB 연결 및 DB의 각종 처리를 담당
public class Test1DAO {
	public Test1DAO() {    // 기본 생성자 ctrl + enter , DB서버에 접속해야함
		try {
//			1. 내 컴퓨터에 있는 드라이버 검색 
			Class.forName("com.mysql.jdbc.Driver");   // class 확인하는 명령어 , 예외처리 필수
			System.out.println("드라이버 검색 성공");
			
//			2. DB 서버에 연결하기 (만들어 놓은 데이터베이스에 연결하기)
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			
			DriverManager.getConnection(url, user, password);  // DB , 예외처리 필수
			System.out.println("데이터 연결 성공");
//			연결 성공시 database에 들어있는 table 사용 가능
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터 베이스 연결 실패" +  e.getMessage());
		} finally {
			System.out.println("작업 끝");
		}
	}
}
