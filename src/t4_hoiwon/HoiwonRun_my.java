package t4_hoiwon;

import java.util.ArrayList;
import java.util.Scanner;

public class HoiwonRun_my {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HoiwonDAO dao = new HoiwonDAO();
		
		boolean run = true;
		String name = "";
		HoiwonVO vo = null;
		
		while(run) {		
			System.out.print("1:전체 조회 2:개별 조회 3:수정 4:삭제 5:종료 => ");
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
						System.out.print(v.getAddress() + "\t");
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
					break;
					}  

//			수정
				case 3:

//			삭제
				case 4:
					System.out.print("삭제할 회원명을 입력하세요(종료 999) : ");
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
