package Swing2_JFrame;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T02_inbokeLater2 extends JFrame{
	
	public T02_inbokeLater2() {
		setTitle("스윙 이벤트 큐 연습");
		setSize(300, 200);
		
		System.out.println("22222222222");
		
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		System.out.println("11111111111");
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
//		
				T02_inbokeLater2 t02 = new T02_inbokeLater2();
				t02.setVisible(true);
				System.out.println(Thread.currentThread().getName());  
//	 --> Swing을 따로 관리하기 위해 위에 ivokeLater2로 익명객체를 생성해야함
//		 이 동작을 하기 위해 시간이 걸리는데 그럼 다른 동작들이 놀기때문에 다른 동작을 먼저 실행 시키게 하기 위해 따로 관리해준다
			}
		});
		
		System.out.println("33333333333");
	}
}
