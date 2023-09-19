package AWT1;

import java.awt.Frame;

public class T1_Frame {
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		
		frame.setTitle("AWT 연습");   //frame 제목 설정
		frame.setSize(400,300);    // (폭,높이) : 픽셀단위
		
		frame.setVisible(true);     // true가 보이는 것, false 가려짐
	}
}
