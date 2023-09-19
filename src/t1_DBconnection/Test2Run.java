package t1_DBconnection;

public class Test2Run {
	public static void main(String[] args) {
		Test2DAO dao = new Test2DAO();
		
		System.out.println("데이터베이스 연결 작업 중입니다.");
		
		Test2Service service = new Test2Service();
		service.getTestMeothod();
		
//		DB 연결 종료 메소드 호출 (DB는 무조건 DAO에서 만들기)
		dao.connClose();
		System.out.println("데이터베이스 연결 종료");
	}
}
