package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.mysql.jdbc.Field;

public class DAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	MemberVO membervo = null;
	BookVO bookvo = null;
	BookUpdateVO bookUpdatevo = null;
	ArrayList<BookVO> vos = new ArrayList<>();
	Vector vData = null;

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
// 회원 관리 ---------------------------------------------------------------------------------------------------------
//	회원 등록 
	public int memberInput(MemberVO vo) {
		int res = 0;
		try {
			sql = "insert into member values (default,?,?,?,?,?,?,?,?,default,default,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getGender());
			pstmt.setInt(5, vo.getAge());
			pstmt.setString(6, vo.getEmail());
			pstmt.setString(7, vo.getPhonenum());
			pstmt.setString(8, vo.getAddress());

			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

//	회원 개별 조회(중복 배제)
	public MemberVO memberSearch(String id) {
		membervo = new MemberVO();
		try {
			sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				membervo.setId(id);
				membervo.setPw(rs.getString("pw"));;
				membervo.setName(rs.getString("name"));
				membervo.setGender(rs.getString("gender"));
				membervo.setAge(rs.getInt("age"));
				membervo.setEmail(rs.getString("email"));
				membervo.setPhonenum(rs.getString("phonenum"));
				membervo.setAddress(rs.getString("address"));
				membervo.setEntry(rs.getString("entry"));
				membervo.setRating(rs.getString("rating"));
				membervo.setPoint(rs.getInt("point"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return membervo;
	}

//	ID / PW 찾기
	public MemberVO memberSearchIDPW(String name, String email) {
		membervo = new MemberVO();
		try {
			sql = "select * from member where name=? and email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				membervo.setName(rs.getString("name"));
				membervo.setEmail(rs.getString("email"));
				membervo.setId(rs.getString("id"));
				membervo.setPw(rs.getString("pw")); 
			}
				
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return membervo;
	}
	
//	전체 회원 정보 테이블 입력
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getMemberList() {
		vData = new Vector<>(); 
		try {
			sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("id"));
				vo.add(rs.getString("pw"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("email"));
				vo.add(rs.getString("phonenum"));
				vo.add(rs.getString("address"));
				vo.add(rs.getString("entry"));
				vo.add(rs.getString("rating"));
				vo.add(rs.getInt("point"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	
//	회원 조건 조회 테이블 입력
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getMemberSearch(String field, String member) {
		vData = new Vector<>(); 
		try {
			sql = "select * from member where "+field+"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("id"));
				vo.add(rs.getString("pw"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("email"));
				vo.add(rs.getString("phonenum"));
				vo.add(rs.getString("address"));
				vo.add(rs.getString("entry"));
				vo.add(rs.getString("rating"));
				vo.add(rs.getInt("point"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

//	정보 수정
	public int memberUpdate(MemberVO vo) {
		int res = 0;
		try {
			sql = "update member set pw=?, name=?, gender=?, age=?, email=?, phonenum=?, address=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getGender());
			pstmt.setInt(4, vo.getAge());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getPhonenum());
			pstmt.setString(7, vo.getAddress());
			pstmt.setString(8, vo.getId());
			res = pstmt.executeUpdate();		
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
//	책 주문시 포인트 추가
	public int setmemberPoint(String filed, String id) {
		int res = 0;
		try {
			sql = "update member set point=point+"+filed+" where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
//  포인트 사용시 차감
	public int ChangePoint(int totpoint, String id) {
		int res = 0;
		try {
			sql = "update member set point=point-"+totpoint+" where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

//	회원 탈퇴
	public int memberDelete(String id) {
		int res = 0;
		try {
			sql = "delete from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	

//	회원 탈퇴 시 해당 ID 구매 목록 지우기
	public int shoppingDelete(String id) {
		int res = 0;
		try {
			sql = "delete from shopping where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
//	회원 탈퇴시 등록 요청 목록 삭제

	public int requlstDelete(String id) {
		int res = 0;
		try {
			sql = "delete from bookUpdate where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

//  구매 목록
	public int buyList(String id, Object value, int item) {
		int res = 0;
		try {
			sql = "insert into shopping values(default,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, (String) value);
			pstmt.setInt(3, item);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	
	
//	책 관리 ---------------------------------------------------------------------------------------------------------
//	책 그림,줄거리 등록 안 되어 있는 책 찾기
	public ArrayList<BookVO> bookcoverList() {
		vos = new ArrayList<>();
		try {
			sql = "select * from book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bookvo = new BookVO();
				bookvo.setBookname(rs.getString("bookname"));
				bookvo.setCover(rs.getString("cover"));
				bookvo.setReview(rs.getString("review"));
				vos.add(bookvo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}
	
//  책 개별 검색
	public BookVO BookSearch(String bookname) {
		bookvo = new BookVO();
		try {
			sql = "select * from book where bookname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bookvo.setCategory(rs.getNString("category"));
				bookvo.setBookname(bookname);
				bookvo.setCompany(rs.getString("company"));	
				bookvo.setWriter(rs.getString("writer"));
				bookvo.setPublication(rs.getString("publication"));
				bookvo.setPrice(rs.getInt("price"));
				bookvo.setGrade(rs.getString("grade"));
				bookvo.setReview(rs.getString("review"));
				bookvo.setCover(rs.getString("cover"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return bookvo;
	}
	
//	책 조건 검색
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getBookSearch(String field, String bookSearch) {
		vData = new Vector<>();
		try {
			sql = "select * from book where "+field+"= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookSearch);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getString("category"));
				vo.add(rs.getString("bookname"));
				vo.add(rs.getString("writer"));
				vo.add(rs.getString("grade"));
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

//  책 전체 리스트 가져오기
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getBookList() {
		vData = new Vector<>();
		try {
			sql = "select * from book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getString("category"));
				vo.add(rs.getString("bookname"));
				vo.add(rs.getString("writer"));
				vo.add(rs.getString("grade"));
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	
//	개인이 구매한 책 리스트 확인
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getBuyList(String id) {
		vData = new Vector<>();
		try {
			sql = "select * from shopping where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getString("bookname"));
				vo.add(rs.getInt("item"));
				vo.add(rs.getString("buydate"));
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	
//	개인 등록 요청 리스트
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getUpdateList(String id) {
		vData = new Vector<>();
		try {
			sql = "select * from bookUpdate where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getString("bookname"));
				vo.add(rs.getString("situation"));
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	
//  책 등록 신청 중복 확인
	public BookUpdateVO BookUpdateSearch(String bookname) {
		BookUpdateVO vo = new BookUpdateVO();
		try {
			sql = "select bookname from bookUpdate where bookname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setBookname(bookname);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

//	책 등록 신청
	public int BookUpdate(BookUpdateVO vo) {
		int res = 0;
		try {
			sql = "insert into bookUpdate values (default,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getBookname());
			res = pstmt.executeUpdate();			
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

//	관리자 -----------------------------------------------------------
//	책 요청 전체 리스트
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getrequest() {
		vData = new Vector<>();
		try {
			sql = "select * from bookUpdate where situation='대기중'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getString("id"));
				vo.add(rs.getString("bookname"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}


//	요청한 책 등록하면 상태 등록완료로 변경
	public int bookSituation(Object value) {
		int res = 0;
		try {
			sql = "update bookUpdate set situation='등록완료' where bookname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value.toString());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

//	요청한 책 등록하기
	public int bookNewUpdate(BookVO bvo) {
		int res = 0;
		try {
			sql = "insert into book values(default,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getCategory());
			pstmt.setString(2, bvo.getBookname());
			pstmt.setString(3, bvo.getCompany());
			pstmt.setString(4, bvo.getWriter());
			pstmt.setString(5, bvo.getPublication());
			pstmt.setInt(6, bvo.getPrice());
			pstmt.setString(7, bvo.getGrade());
			pstmt.setString(8, bvo.getReview());
			pstmt.setString(9, bvo.getCover());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

//	책 정보 수정
	public int bookModify(BookVO bvo) {
		int res = 0;
		try {
			sql = "update book set category=?, company=?, writer=?, publication=?, price=?, grade=?, review=?, cover=? where bookname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getCategory());
			pstmt.setString(2, bvo.getCompany());
			pstmt.setString(3, bvo.getWriter());
			pstmt.setString(4, bvo.getPublication());
			pstmt.setInt(5, bvo.getPrice());
			pstmt.setString(6, bvo.getGrade());
			pstmt.setString(7, bvo.getReview());
			pstmt.setString(8, bvo.getCover());
			pstmt.setString(9, bvo.getBookname());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

//	책 삭제
	public int bookDelete(Object value) {
		int res = 0;
		try {
			sql = "delete from book where bookname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value.toString());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

//	책 등록 요청 테이블에서 삭제
	public int bookUpdateDelete(String bookname) {
		int res = 0;
		try {
			sql = "delete from bookUpdate where bookname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookname);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}


}