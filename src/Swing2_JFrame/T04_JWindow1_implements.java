package Swing2_JFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

// 창 전체를 윈도우로 사용할때는 JFrame이 아닌 JWindow로 사용
@SuppressWarnings("serial")
public class T04_JWindow1_implements extends JWindow implements MouseListener{
	JButton exitBtn;
	
	public T04_JWindow1_implements() {
		setSize(600, 350);
		
		exitBtn = new JButton("종료"); 
		add(exitBtn);
		
//		exitBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		});
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   -> 얘는 JFrame이 아니라서 사용할 수 없음
		
		exitBtn.addMouseListener(this);
	}
		
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_JWindow1_implements t04 = new T04_JWindow1_implements();
				t04.setVisible(true);
			}
		});
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		System.exit(0);
	}


	@Override
	public void mousePressed(MouseEvent e) {} // 마우스를 누르는 순간


	@Override
	public void mouseReleased(MouseEvent e) {} // 누르고 떼는 순간


	@Override
	public void mouseEntered(MouseEvent e) {} // 영역으로 들어가는 순간


	@Override
	public void mouseExited(MouseEvent e) {} // 영역에서 나오는 순간
}
