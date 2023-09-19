package t5_hoiwon;

import java.util.ArrayList;
import java.util.Scanner;

public class HoiwonRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HoiwonDAO dao = new HoiwonDAO();
		
		boolean run = true;
		String name = "";
		HoiwonVO vo = null;
		
		while(run) {		
			System.out.print("1.전체 조회 2.개별 조회 3.회원가입 4.수정 5.삭제 6:종료 => ");
			int no = scanner.nextInt();
			System.out.println("-".repeat(40));					
			
			switch(no) {
//			전체 조회
				case 1:
					ArrayList<HoiwonVO> vos = dao.getList();   // 전체 검색 호출
					
					System.out.println("\t     ** 주 소 록 **");
					System.out.println("=".repeat(40));
					System.out.println("번호\t성명\t나이\t주소\t성별");
					System.out.println("-".repeat(40));
					for(HoiwonVO v : vos) {						
						System.out.print(v.getIdx() + "\t");
						System.out.print(v.getName() + "\t");
						System.out.print(v.getAge() + "\t");
						System.out.print(v.getAddress() + "\t");
						System.out.print(v.getGender());
						System.out.println();
					}
					System.out.println("=".repeat(40));
					System.out.println("총 회원 수 : " +vos.size()+ " 명" );
					
					break;
					
//			개별 조회		
				case 2:
					System.out.print("검색할 회원명을 입력하세요(종료 999) : ");
					name = scanner.next();
					System.out.println("-".repeat(40));					
					vo = dao.getSearch(name);  // 개별 검색 호출
					
//				if(vo() != null) {  // vo값은 null값이 되지 않기에 이런식으로 비교하지 않는다.
//				 vo로 비교하면 값이 없어도 껍데기가 있어 회원 정보가 없다고 나오지 않음.
					if(vo.getName() != null) {
//			System.out.println(vo);
						System.out.println("번호 : " + vo.getIdx());
						System.out.println("성명 : " + vo.getName());
						System.out.println("나이 : " + vo.getAge());
						System.out.println("주소 : " + vo.getAddress());
						System.out.println("성별 : " + vo.getGender());
					} else {
						System.out.println(name + "님의 회원 정보가 없습니다.");
					}  
					break;

//			회원가입
				case 3:
//					System.out.print("가입하실 회원의 성명을 입력하세요 : ");
//				  name = scanner.next();
//				  System.out.print("가입하실 회원의 나이를 입력하세요 : ");
//				  int age = scanner.nextInt();
//				  System.out.print("가입하실 회원의 주소를 입력하세요 : ");
//				  String address = scanner.next();
//				  System.out.print("가입하실 회원의 성별을 입력하세요(1:남자, 2:여자) : ");
//				  int gender = scanner.nextInt();
//					dao.setHoiwonInput(name,age,address,gender);   // 회원가입 메소드 호출
					
				  vo = new HoiwonVO();
					
				  System.out.print("가입하실 회원의 성명을 입력하세요 : ");
				  vo.setName(scanner.next());
				  System.out.print("가입하실 회원의 나이를 입력하세요 : ");
				  vo.setAge(scanner.nextInt());
				  System.out.print("가입하실 회원의 주소를 입력하세요 : ");
				  vo.setAddress(scanner.next());
				  System.out.print("가입하실 회원의 성별을 입력하세요(1:남자, 2:여자) : ");
				  int gender = scanner.nextInt();
				  if (gender == 1) {
				  	vo.setGender("남자");
				  } else {
				  	vo.setGender("여자");
				  }
				  
				  int res = dao.setHoiwonInput(vo);   // 회원가입 메소드 호출
				  if(res == 0) {
				  	System.out.println("회원가입에 실패 하셨습니다");
				  } else {
				  	System.out.println("회원가입이 성공 되었습니다.");
				  }
				  
				  break;
					
//			수정		
				case 4:
					System.out.print("정보를 수정할 회원명을 입력하세요 : ");
					name = scanner.next();
					System.out.println("-".repeat(40));
					
					vo = dao.getSearch(name);  // 개별 자료 검색  , 검색 후 있으면 삭제해야 하기 때문
					if(vo.getName() == null) {
						System.out.println(name + "님의 자료가 없습니다.");
					} else {
						System.out.println("-".repeat(40));
						System.out.println("수정할 항목의 번호를 입력하세요");
						System.out.print("=> 1.나이 2.주소 3.성별 4.뒤로가기 >");
						no = scanner.nextInt();
						
						int age = vo.getAge();
						String address = vo.getAddress();
						String strGender = vo.getGender();
						
						switch(no) {
							case 1:
								System.out.print("수정 할 나이를 입력하세요 (등록되어 있는 나이 : "+age+"): ");
								age = scanner.nextInt();
								break;
							case 2:
								System.out.print("수정 할 주소를 입력하세요 (등록되어 있는 주소 : "+address+"): ");
								address = scanner.next();
								break;
							case 3:
								System.out.print("수정 할 성별을 입력하세요(등록되어 있는 주소 : "+strGender+") (1:남자 2:여자) : ");
								gender = scanner.nextInt();
								if (gender == 1) {
									strGender = "남자";
								} else {
									strGender = "여자";
								}
								break;
							default:
								System.out.println("수정이 취소되었습니다.");
								break;
						}
						
						res = dao.setHoiwonUpdate(name,age,address,strGender);
						if(res == 0) {
							System.out.println("수정이 실패되었습니다.");
						} else {
							System.out.println("수정이 완료 되었습니다.");
						}
//			웹에서는 화면에 고칠 목록을 뷰로 보여주지면 java에서는 뷰가 없기 때문에 console에 다 넣어야 함 
						System.out.println(name + "님의 자료가 수정되었습니다.");
					}
					
					break;
//			삭제
				case 5:
					System.out.print("삭제할 회원명을 입력하세요 : ");
					name = scanner.next();
					System.out.println("-".repeat(40));
					
					vo = dao.getSearch(name);  // 개별 자료 검색  , 검색 후 있으면 삭제해야 하기 때문
					if(vo.getName() == null) {
						System.out.println(name + "님의 자료가 없습니다.");
					} else {
						dao.setDelete(name);
						System.out.println(name + "님의 자료가 삭제되었습니다.");
					}
					
					break;
					
//			종료
				default:
					run = false;
			}
			
			System.out.println("=".repeat(40));
		}
		System.out.println("작업 끝");
//		DB conn 객체 close
		dao.connClose();
		
		scanner.close();
	}
}
