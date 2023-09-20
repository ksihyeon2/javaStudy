package Swing2_JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

// 창 전체를 윈도우로 사용할때는 JFrame이 아닌 JWindow로 사용
@SuppressWarnings("serial")
public class T04_JWindow2 extends JWindow{
	JButton exitBtn;
	
	public T04_JWindow2() {
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
		
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.exit(0);   -- 완전 끝낼때 사용하는 것이라 아무데나 쓰면 안됨
//				setVisible(false);    -- 잠시 닫는 것
				dispose();    // 해당 객체만 날리는 것이기 때문에 완전 끝내는 것이 아님, 여러 창을 사용할때 해당 창만 닫을때 사용
			}
		});
	}
		
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_JWindow2 t04 = new T04_JWindow2();
				t04.setVisible(true);
			}
		});
	}

}
