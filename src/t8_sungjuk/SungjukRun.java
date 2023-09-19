package t8_sungjuk;

import java.util.Scanner;

public class SungjukRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SungjukService service = new SungjukService();
		
		boolean run = true;
//		while, switch 같이 쓸때는 변수로 true 값 설정
		
		while(run) {
			System.out.println("\n\t\t\t** 성 적 표 **");
			System.out.println("=".repeat(60));
			System.out.print("(1) 입력 (2) 전체 조회 (3) 개별 조회 (4) 수정 (5) 삭제 (0) 종료 \n=>");
			int no = scanner.nextInt();
			System.out.println("-".repeat(60));
			
			switch (no) {
//				성적 입력 처리 (중복 처리)
				case 1:
					service.setInput();
					break;
//				전체 조회
				case 2:
					service.getList();
					break;
//				개별 조회
				case 3:
					service.getSearch();
					break;
//				수정
				case 4:
					service.setUpdate();
					break;
//				삭제
				case 5:
					service.setDelete();
					break;
				default:
					run = false;
					break;
			}
			
		}
		System.out.println("작업 끝");
		
		scanner.close();
	}
}
