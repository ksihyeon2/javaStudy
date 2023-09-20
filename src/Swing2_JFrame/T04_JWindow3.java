package Swing2_JFrame;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T04_JWindow3 extends JWindow{
	JButton exitBtn;
	
	public T04_JWindow3() {
		setSize(600, 350);
		
		exitBtn = new JButton("종료"); 
		add(exitBtn);

		
//		JWindow를 화면 중앙에 띄우기
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();  // 싱글톤처럼 씀
		Point centerpoint = ge.getCenterPoint();  // 가운데 좌표를 가져옴
		
		int leftTopX = centerpoint.x - this.getWidth()/2;  // 가운데 좌표크기에서 폭 절반을 뺌
		int leftTopY = centerpoint.y - this.getHeight()/2;   // 가운데 y 좌표크기에서 높이 절반를 뺌 
//		--> 위치를 가운데로 지정하기
		setLocation(leftTopX, leftTopY);
		
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose(); 
			}
		});
	}
		
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_JWindow3 t04 = new T04_JWindow3();
				t04.setVisible(true);
			}
		});
	}

}
