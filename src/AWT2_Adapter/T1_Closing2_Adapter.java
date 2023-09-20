package AWT2_Adapter;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T1_Closing2_Adapter extends Frame {
//	Button btnExit = null;    // 여러곳에서 쓰려면 이곳에 적어두고 사용하면 됨
	
	public T1_Closing2_Adapter() {
		super("어뎁터 활용");
		setBounds(300, 250, 300, 350);
		
		Button btnExit = new Button("종 료");
		add(btnExit);
		
		setVisible(true);
	
//		-------------------------------------------------------- 	//
		btnExit.addActionListener(new ActionListener() {   // 구현 메소드가 한개인 경우에는 Adapter가 없음 
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});     
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
	 new T1_Closing2_Adapter();  // 같은 class 안에서는 변수 없ㅇ미 new로 생성하면 됨
	}
	
}
