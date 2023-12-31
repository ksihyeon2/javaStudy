package Swing3_Layout;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T02_BorderLayout4 extends JFrame{
	private JButton btn1,btn2,btnExit;
	private JPanel pn1;
	
	public T02_BorderLayout4() {
		setTitle("BorderLayout 연습");
		setSize(300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		btn1 = new JButton("안녕하세요");
		add(btn1, BorderLayout.NORTH);
		
		btn2 = new JButton("버튼2");
		add(btn2,BorderLayout.SOUTH);
		
		btnExit = new JButton("종료");
		add(btnExit,BorderLayout.SOUTH);
		
//		같은 위치에 여러 버튼을 생성할때는 JPanel을 사용해야함
		pn1 = new JPanel();		
		pn1.setLayout(new GridLayout(1,2));    // panel에 layout을 또 올려서 사용한 것
		pn1.add(btn2);
		pn1.add(btnExit);
		
//		add(pn1);   // getcontentpan이 생략됨
		add(pn1,BorderLayout.SOUTH);  
		
//		----------------------------------------------------------	//
		
		
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "잘가");
				System.exit(0);
			}
		});
		
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "안녕");
			}
		});
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "안녕 버튼을 누르셨습니다.");
			}
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T02_BorderLayout4 t02 = new T02_BorderLayout4();
				t02.setVisible(true);
			}
		});
		}
}
