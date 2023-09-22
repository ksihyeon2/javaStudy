package Swing3_Layout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/* 
	CardLayout 사용법
 	- CardLayout 제어 메소드 : first(), last(), next(), show()
 	> first() : 첫번째 카드 보이기	
 	> last() : 마지막 카드 보이기	
 	> next() : 다음 카드 보이기	
 	> show() : 지정된 카드 보이기	
 */
@SuppressWarnings("serial")
public class T04_CardLayout1_2 extends JFrame{
	private JPanel pn1, pn2, pn3;
	
	public T04_CardLayout1_2() {
		setTitle("CardLayout 연습");
		setSize(250, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		CardLayout card = new CardLayout();
		setLayout(card);
//		setLayout(new CardLayout());
		
//		pn1 = new JPanel();
//		pn1.setBackground(Color.GRAY);
		
//		CardLayout은 먼저 만든 Layout이 뜸
		pn2 = new JPanel();
		pn2.setBackground(Color.GREEN);
		pn2.setName("green");
		add("pink",getPn1());  // 함수로 만들어서 사용해도 됨
		add(pn2);
		add("gray",getPn3());
		
//		-----------------------------			//
		addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {
				card.next(getContentPane());   // 현재 ContenPane에 올라와 있는 Layout의 다음 Layout 보여주기
			}
		});
	}
	
	private JPanel getPn3() {
		pn3 = new JPanel();
		pn3.setBackground(Color.GRAY);
		return pn3;
	}

	private JPanel getPn1() {
		pn1 = new JPanel();
//		pn1.setBackground(Color.GRAY);
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		pn1.setBackground(new Color(r,g,b));   // Color(r,g,b)  r=red,g=green,b=blue
		return pn1;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_CardLayout1_2 t04 = new T04_CardLayout1_2();
				t04.setVisible(true);
			}
		});
	}
}
