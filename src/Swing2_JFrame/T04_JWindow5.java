package Swing2_JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T04_JWindow5 extends JWindow{
	JLabel lblImg;
	
	public T04_JWindow5() {
		setSize(600, 350);
		
//		lblImg = new JLabel("안녕하세요");    -- 레이블에 텍스트를 그림처럼 띄움
//		add(lblImg);
		
		lblImg = new JLabel();
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/1.png")));
		add(lblImg);
		
		setLocationRelativeTo(null); // 화면 중앙에 vied(window) 배치하기
		
		addMouseListener(new MouseAdapter() {   // 마우스 움직임을 감지 ( Button을 붙이면 버튼을 누르는 움직임을 감지)
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.exit(0);
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_JWindow5 t05 = new T04_JWindow5();
				t05.setVisible(true);
			}
		});
	}

}
