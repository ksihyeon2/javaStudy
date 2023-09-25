package xDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class InsaDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql ="";
	InsaVO vo = null;
	
	public InsaDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "root";
			String pw = "1234";
			
			conn = DriverManager.getConnection(url, user, pw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 검색 실패 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 연동 실패 : " + e.getMessage());
			}
	}
	
	private void connClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}
	
	private void pstmtClose() {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
		} catch (Exception e) {}
	}
	
	private void rsClose() {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {}
		pstmtClose();
	}

//	회원명 검색(회원 중복처리)
	public InsaVO getNameSearch(String name) {
		vo = new InsaVO();
		try {
			sql = "select * from insa where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setIpsail(rs.getString("ipsail"));
			} 
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

//	회원 가입처리
	public int setInsaInput(InsaVO vo) {
		int res = 0;
		try {
			sql = "insert into insa values (default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getIpsail());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public int setInsaUpdate(InsaVO vo) {
		int res = 0;
		try {
			sql = "update insa set age=?,gender=?,ipsail=? where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAge());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getIpsail());
			pstmt.setString(4, vo.getName());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public int setInsaDelete(String name) {
		int res = 0;
		try {
			sql = "delete from insa where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getInsaList() {
		Vector vData = new Vector<>();
		try {
			sql = "select * from insa order by age";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail").substring(0,10));
				vData.add(vo);
			} 
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

//	조건별 정렬처리하기
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getNameAscList(String str, String flag) {
		Vector vData = new Vector<>();
		try {
			if(str.equals("name")) {
				if(flag.equals("a")) {
					sql = "select * from insa order by name";
				} else {
					sql = "select * from insa order by name desc";
				}
			} else if (str.equals("ipsail")) {
				if(flag.equals("a")) {
					sql = "select * from insa order by ipsail";
				} else {
					sql = "select * from insa order by ipsail desc";
				}
			}
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				vData.add(vo);
			} 
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public Vector getGenderSearch(String str, String value) {
//		Vector vData = new Vector<>();
//		try {
////			if(str.equals("gender")) {
//				if(str.equals("남자")) {
//					sql = "select * from insa where gender='남자' order by name";
//				} else {
//					sql = "select * from insa where gender='여자' order by name";
//				}
//				pstmt = conn.prepareStatement(sql);
//			} else if (str.equals("age")) {
//				if(str.equals("age")) {
//					sql = "select * from insa where age='age' order by ipsail";
//					pstmt = conn.prepareStatement(sql);
//					pstmt.setInt(1, Integer.parseInt(value));
//				}
//			}
//			
//			if(value.equals("남자")) {
//				sql = "select * from insa where gender='남자' order by name";
//			} else {
//				sql = "select * from insa where gender='여자' order by name";
//			}
//			
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				Vector vo = new Vector<>();
//				vo.add(rs.getInt("idx"));
//				vo.add(rs.getString("name"));
//				vo.add(rs.getInt("age"));
//				vo.add(rs.getString("gender"));
//				vo.add(rs.getString("ipsail"));
//				vData.add(vo);
//			} 
//		} catch (SQLException e) {
//			System.out.println("SQL 오류 :" + e.getMessage());
//		} finally {
//			rsClose();
//		}
		
//		남자,여자 아리오 버튼 클릭
			@SuppressWarnings("unchecked")
		public Vector getGender(String gender) {
				Vector vData = new Vector<>();
				try {
						sql = "select * from insa where gender=? order by name";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, gender);
						rs = pstmt.executeQuery();
				
				while(rs.next()) {
					@SuppressWarnings("rawtypes")
					Vector vo = new Vector<>();
					vo.add(rs.getInt("idx"));
					vo.add(rs.getString("name"));
					vo.add(rs.getInt("age"));
					vo.add(rs.getString("gender"));
					vo.add(rs.getString("ipsail"));
					vData.add(vo);
				} 
			} catch (SQLException e) {
				System.out.println("SQL 오류 :" + e.getMessage());
			} finally {
				rsClose();
				}
		return vData;
		}

//			다양한 조건을 선택 후 검색 문자열을 입력하고 검색 버튼을 누를 경우 수행 처리
		@SuppressWarnings("unchecked")
		public Vector getConditionSearch(String field, String value) {
				Vector vData = new Vector<>();
				try {
						sql = "select * from insa where "+field+" like ? order by name";
						pstmt = conn.prepareStatement(sql);
						
						if(field.equals("age")) {
							pstmt.setInt(1,Integer.parseInt(value));
						} else {					
							pstmt.setString(1, "%"+value+"%");
						}
						rs = pstmt.executeQuery();
				
				while(rs.next()) {
					@SuppressWarnings("rawtypes")
					Vector vo = new Vector<>();
					vo.add(rs.getInt("idx"));
					vo.add(rs.getString("name"));
					vo.add(rs.getInt("age"));
					vo.add(rs.getString("gender"));
					vo.add(rs.getString("ipsail"));
					vData.add(vo);
				} 
			} catch (SQLException e) {
				System.out.println("SQL 오류 :" + e.getMessage());
			} finally {
				rsClose();
				}
		return vData;
		}

/*
//			성명 조건 검색(포함된 글자 모두 다 검색)
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Vector getConditionNameSearch(String txtCondi) {
				Vector vData = new Vector<>();
				try {
						sql = "select * from insa where name like ? order by name";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, "%"+txtCondi+"%");
						rs = pstmt.executeQuery();
				
				while(rs.next()) {
					@SuppressWarnings("rawtypes")
					Vector vo = new Vector<>();
					vo.add(rs.getInt("idx"));
					vo.add(rs.getString("name"));
					vo.add(rs.getInt("age"));
					vo.add(rs.getString("gender"));
					vo.add(rs.getString("ipsail"));
					vData.add(vo);
				} 
			} catch (SQLException e) {
				System.out.println("SQL 오류 :" + e.getMessage());
			} finally {
				rsClose();
				}
		return vData;
		}
		*/
}
