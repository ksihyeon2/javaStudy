package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class DAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	MemberVO membervo = null;
	BookVO bookvo = null;
	ArrayList<BookVO> vos = new ArrayList<>();

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

//	회원 조회(중복 배제)
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

//	로그인
//	public int memberLogin(String id, String pw) {
//		int res = 0;
//		try {
//			sql = "select * from member where id=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				membervo.setId(id);
//			}
//		} catch (SQLException e) {
//			System.out.println("DB 연동 오류 : " + e.getMessage());
//		} finally {
//			rsClose();
//		}
//		return res;
//	}

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
	
//	책 그림 등록 안 되어 있는 책 찾기
	public ArrayList<BookVO> bookcoverList() {
		vos = new ArrayList<>();
		try {
			sql = "select bookname, cover from book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bookvo = new BookVO();
				bookvo.setBookname(rs.getString("bookname"));
				bookvo.setCover(rs.getString("cover"));
				
				vos.add(bookvo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류  : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}
	
	
//책 개별 검색
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

// 책 등록 신청 중복확인
	public BookUpdateVO BookUpdateSearch(String bookname) {
		BookUpdateVO vo = new BookUpdateVO();
		try {
			sql = "select bookname from bookUpdate bookname=?";
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
			sql = "insert into bookUpdate values (default,?,?,?)";
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
	
//	책 그림 등록하기

//	public BookVO bookCover(Object value) {
//		bookvo = new BookVO();
//		try {
//			sql = "update book set cover=? where bookname=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, );
//		} catch (SQLException e) {
//			System.out.println("SQL 오류  : " + e.getMessage());
//		} finally {
//			pstmtClose();
//		}
//		return null;
//	}

	// 책 리스트 가져오기
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getBookList() {
		Vector vData = new Vector<>();
		try {
			sql = "select category,bookname,writer,grade from book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
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
}
