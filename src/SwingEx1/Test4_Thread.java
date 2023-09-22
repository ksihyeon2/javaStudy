package SwingEx1;

import java.time.LocalDateTime;

public class Test4_Thread {

	
	public static void main(String[] args) {
		int cnt = 0;
		while(true) {
			System.out.println("현재 시간 : " + LocalDateTime.now());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			cnt++;
			if(cnt == 10) {
				break;
			}
		}
		System.out.println("작업 끝");
	}
}
