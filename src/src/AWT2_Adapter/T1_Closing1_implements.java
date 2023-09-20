package AWT2_Adapter;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T1_Closing1_implements extends Frame implements WindowListener, ActionListener{
//	Button btnExit = null;    // 여러곳에서 쓰려면 이곳에 적어두고 사용하면 됨
	
	public T1_Closing1_implements() {
		super("어뎁터 활용");
		setBounds(300, 250, 300, 350);
		
		Button btnExit = new Button("종 료");
		add(btnExit);
		
		setVisible(true);
	
//		-------------------------------------------------------- 	//
		btnExit.addActionListener(this);
		
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
	 new T1_Closing1_implements();  // 같은 class 안에서는 변수 없ㅇ미 new로 생성하면 됨
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowOpened(WindowEvent e) {}


	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
