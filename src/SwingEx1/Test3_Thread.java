package SwingEx1;

import java.time.LocalDateTime;

public class Test3_Thread {

	
	public static void main(String[] args) {
		System.out.println("현재 시간 : " + LocalDateTime.now());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		System.out.println("다음 시간 : " + LocalDateTime.now());
	}
}
