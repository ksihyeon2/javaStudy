package Swing3_Layout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
public class T04_CardLayout4 extends JFrame{
	private JButton btn1, btn2, btn3, btn4;
	
	
	public T04_CardLayout4() {
		setTitle("CardLayout 연습3");
		setSize(250, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		CardLayout card = new CardLayout();
		setLayout(card);
		
		btn1 = new JButton("봄");
		btn2 = new JButton("여름");
		btn3 = new JButton("가을");
		btn4 = new JButton("겨울");
		
		btn1.setIcon(new ImageIcon("./images/1.jpg"));
		btn2.setIcon(new ImageIcon("./images/2.jpg"));
		btn3.setIcon(new ImageIcon("./images/3.jpg"));
		btn4.setIcon(new ImageIcon("./images/4.jpg"));
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		
//		------------------------------------------ 		//
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_CardLayout4 t04 = new T04_CardLayout4();
				t04.setVisible(true);
			}
		});
	}
}
