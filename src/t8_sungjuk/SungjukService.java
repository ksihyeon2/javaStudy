package t8_sungjuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungjukService {
	SungjukDAO dao = new SungjukDAO();
	SungjukVO vo = null;
	Scanner scanner = new Scanner(System.in);  // 필드라서 동작이 일어나는 곳에서 닫아야 함
	
	String ans = "N";
	String name = "";
	int res = 0;
	
// 	성적 입력
	public void setInput() {
		vo = new SungjukVO();
		
		while(true) {
				System.out.println("\n ** 성적 입력처리 **");
				System.out.print("성명을 입력하세요 : ");
				name = scanner.next();
				vo = dao.getSearch(name);
				if(vo.getName() != null) {
					System.out.println("동일한 이름이 존재합니다. 다시 입력해주세요");
				} else {
					vo.setName(name);
					System.out.print("국어 점수 : ");
					vo.setKor(scanner.nextInt());
					System.out.print("영어 점수 : ");
					vo.setEng(scanner.nextInt());
					System.out.print("수학 점수 : ");
					vo.setMat(scanner.nextInt());
					res = dao.setInput(vo);
					if(res == 0) {
						System.out.println("> 성적 등록 실패");
					} else {
						System.out.println("> 성적 등록 성공");
					}
					System.out.println("-".repeat(50));
					System.out.print("성적을 계속 입력 하시겠습니까?(y/n) => ");
					ans = scanner.next();
					if(ans.toUpperCase().equals("N")) {
						break;
					}
				}
		}
	}

//	전체 리스트 
	public void getList() {
		ArrayList<SungjukVO> vos = dao.getList();
		
		System.out.println("\n\t\t** 성적 리스트 ***");
		System.out.println("=".repeat(60));
		System.out.println("번호\t성명\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("-".repeat(60));
		for(int i=0; i<vos.size(); i++) {
			vo = vos.get(i);
			caluclator(vo);
			System.out.print(vo.getIdx() + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.print(vo.getMat() + "\t");
			System.out.print(vo.getTot() + "\t");
			System.out.printf("%.1f",vo.getAvg());
			System.out.print("\t" + vo.getGrade() + "\n");
		}
		System.out.println("-".repeat(60));
		System.out.println("\t총 인원 : " + vos.size() + "명");
		System.out.println("=".repeat(60));
	}
// 계산처리
	private void caluclator(SungjukVO vo) {
		vo.setTot(vo.getKor() + vo.getEng() + vo.getMat());
		vo.setAvg(vo.getTot() / 3.0);
		if(vo.getAvg() >= 90) {
			vo.setGrade('A');
		} else if (vo.getAvg() >= 80) {
			vo.setGrade('B');
		} else if (vo.getAvg() >= 70) {
			vo.setGrade('C');
		} else if (vo.getAvg() >= 60) {
			vo.setGrade('D');
		} else {
			vo.setGrade('F');
		}
	}

// 개별 조회
	public void getSearch() {
		while(true) {
			System.out.print("\n조회할 성명을 입력하세요 : ");
			name = scanner.next();
			
			vo = dao.getSearch(name);
			if(vo.getName() != null) {
				caluclator(vo);
				System.out.println("\n번호 : " + vo.getIdx());
				System.out.println("성명 : " + vo.getName());
				System.out.println("국어 : " + vo.getKor());
				System.out.println("영어 : " + vo.getEng());
				System.out.println("수학 : " + vo.getMat());
				System.out.println("총점 : " + vo.getTot());
				System.out.printf("평균 : %.1f",vo.getAvg());
				System.out.println("\n학점 : " + vo.getGrade() + "\n");
			} else {
				System.out.println("검색하신 " +name+ "님의 성적 리스트가 없습니다.");
			}
			System.out.print("계속 검색 하시겠습니까? (y/n) =>");
			ans = scanner.next();
			if(ans.toUpperCase().equals("N") ) {
				break;
			}
		}
	}

	public void setUpdate() {
		System.out.print("\n수정하실 사람의 성명을 입력하세요 : ");
		name = scanner.next();
		vo = dao.getSearch(name);

		boolean run = true;
		
		if(vo == null) {
			System.out.println(name + "님의 성적 리스트가 없습니다.");
		} else {	
			System.out.println(name + "님의 수정 목록을 선택하세요");
			while(run) {
				System.out.println("-".repeat(60));
				System.out.println("(1) 국어 성적 (2) 영어 성적 (3) 수학 성적 (0) 종료");
				System.out.println("-".repeat(60));
				int no = scanner.nextInt();
				switch(no) {
					case 1:
						System.out.println("현재 국어 점수 : " + vo.getKor());
						System.out.print("변경하실 국어 점수를 입력하세요 : ");
						vo.setKor(scanner.nextInt());
						break;
					case 2:
						System.out.println("현재 영어 점수 : " + vo.getEng());
						System.out.print("변경하실 영어 점수를 입력하세요 : ");
						vo.setEng(scanner.nextInt());
						break;
					case 3:
						System.out.println("현재 수학 점수 : " + dao.vo.getMat());
						System.out.print("변경하실 수학 점수를 입력하세요 : ");
						vo.setMat(scanner.nextInt());
						break;
						
					default:
						System.out.println("수정 완료");
						run = false;
						break;
				} 
			}
			dao.setUpdate(name,vo.getKor(),vo.getEng(),vo.getMat());
		} 
	}
	public void setDelete() {
		System.out.print("\n삭제하실 사람의 성명을 입력하세요 : ");
		name = scanner.next();
		vo = dao.getSearch(name);
		if(vo != null) {
			dao.setDelete(name);
			System.out.println(name + "님의 성적이 삭제 완료되었습니다.");
		}
	}
}
