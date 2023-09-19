package AWT1;

import java.awt.Frame;

@SuppressWarnings("serial")
public class T1_Frame2 extends Frame {
	
	public T1_Frame2() {
		super("프레임 테스트");
		setSize(400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
//		Frame frame = new Frame();
//		
//		frame.setTitle("AWT 연습");   //frame 제목 설정
//		frame.setSize(400,300);    // (폭,높이) : 픽셀단위
//		
//		frame.setVisible(true);     // true가 보이는 것, false 가려짐
		
		new T1_Frame2(); // 메소드 호출해서 해당 메소드로 이동하면 기본메소드 이기 때문에 상속받은 Frame이 실행됨
		
	}
}
