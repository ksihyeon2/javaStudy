package Swing2_JFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class T02_inbokeLater extends JFrame{
	
	public T02_inbokeLater() {
		setTitle("스윙 이벤트 큐 연습");
		setSize(300, 200);
		
		System.out.println("22222222222");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	public static void main(String[] args) {
		System.out.println("11111111111");
		
		T02_inbokeLater t02 = new T02_inbokeLater();
		t02.setVisible(true);
		System.out.println(Thread.currentThread().getName());  // 현재 돌아가고 있는 Thread의 이름
		
		System.out.println("33333333333");
	}
}
