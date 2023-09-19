package t7_hoiwon;

import java.util.ArrayList;
import java.util.Scanner;

// 추가 사항 : 회원가입시 연령제한은 20세 이상으로 한다
public class HoiwonRun_ {
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
					
					System.out.println("\t     ** 회원정보 **");
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
				  vo = new HoiwonVO();
				  while (true) {
					  System.out.print("회원 성명을 입력하세요 : ");
					  name = scanner.next();
	//				성명 중복 체느
					  vo = dao.getSearch(name);  // 성명 중복체크
						if(vo.getName() == null) {
							break;
						} else {
							System.out.println("동일 성명이 존재 합니다. 다시 입력하세요");
						}
				  }
				  
				  int age = 20;
				  while(true) {
					  System.out.print("가입하실 회원의 나이를 입력하세요 : ");
					  age = scanner.nextInt();
					  if (age < 20) {
					  	System.out.println("20세 이상만 가입할 수 있습니다.");
					  	break;
					  } else {
					  	vo.setName(name);
					  	vo.setAge(age);
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
					  }
				  }
				  break;
					
//			수정		
				case 4:
					System.out.print("정보를 수정할 회원명을 입력하세요 : ");
					name = scanner.next();
					System.out.println("-".repeat(40));
					
					boolean flag = true;
					while(flag) {
						vo = dao.getSearch(name);  // 개별 자료 검색  , 검색 후 있으면 삭제해야 하기 때문
						if(vo.getName() == null) {
							System.out.println(name + "님의 자료가 없습니다.");
							break;
						} else {
							System.out.println("-".repeat(40));
							System.out.println("성명 : " + vo.getName());
							System.out.println("나이 : " + vo.getAge());
							System.out.println("주소 : " + vo.getAddress());
							System.out.println("성별 : " + vo.getGender());
							System.out.println("-".repeat(40));
							System.out.println("수정할 항목의 번호를 입력하세요");
							System.out.print("=> 1.나이 2.주소 3.성별 4.수정 종료 > ");
							no = scanner.nextInt();
							
							age = vo.getAge();
							String address = vo.getAddress();
							String strGender = vo.getGender();
							
							switch(no) {
								case 1:
									while(true) {
									System.out.print("수정 할 나이를 입력하세요 : ");
									age = scanner.nextInt();
									if(age >= 20) {
										break;
									} else {
										System.out.println("20세 이상만 가능합니다.");
									}
									}
									break;
								case 2:
									System.out.print("수정 할 주소를 입력하세요 : ");
									address = scanner.next();
									break;
								case 3:
									System.out.print("수정 할 성별을 입력하세요 (1:남자 2:여자) : ");
									int gender = scanner.nextInt();
									if (gender == 1) {
										strGender = "남자";
									} else {
										strGender = "여자";
									}
									break;
								default:
									flag = false;
							}
							
							int res = dao.setHoiwonUpdate(name,age,address,strGender);
							if(res == 0) {
								System.out.println("수정이 실패되었습니다.");
							} else {
								System.out.println("수정이 완료 되었습니다.");
							}
						}
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
