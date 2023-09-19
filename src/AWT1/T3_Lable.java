package AWT1;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T3_Lable extends Frame implements WindowListener{
	
	public T3_Lable() {
//		디자인
		super("프레임 테스트");
		setSize(400,300);
		
//		이름표(Label) : 레이블 컴포턴트
		Label lbl = new Label("회 원 가 입 폼");
		this.add(lbl);
		
		setVisible(true);
		
//-------------------------------------------//
		
//		감시자
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new T3_Lable();
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
}
