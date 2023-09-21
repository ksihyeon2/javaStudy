package Swing3_Layout;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T05_NullLayout2 extends JFrame{
	private JButton btnExit,btnInput,btnReset;
	private JLabel lblName, lblAge, lblTitle;
	private JTextField txtName, txtAge;
	private JTextArea txtaContent;    // 여러줄
	private int xPos = 50, yPos = 100;
	
	public T05_NullLayout2() {
		setTitle("NullLayout(절대위치) 연습");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(null);
		
		add(getLblName());
		add(getLblAge());
		add(getTxtName());
		add(getTxtAge());
		add(getLblTitle());
		add(getTxtaContent());
		
		add(getBtnInput());
		add(getBtnReset());
		add(getBtnExit());
		
//		---------------------------------------------------    //
		
//		회원가입
		btnInput.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = "";
				str += "성명 : " + txtName.getText() + "\n";
				str += "나이 : " + txtAge.getText();
				JOptionPane.showMessageDialog(null, str);
				
				txtaContent.setText(str);
			}
		});
		
//	 리셋버튼
		btnReset.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				txtaContent.setText("");
			}
		});
		
//		종료버튼
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "회원가입 종료");
				System.exit(0);
			}
		});
		
		
	}
	
//	출력
	private JTextArea getTxtaContent() {
		txtaContent = new JTextArea();
		txtaContent.setBackground(Color.GRAY);
		txtaContent.setBounds(xPos+250, yPos-10, 100, 100);
		return txtaContent;
	}

	private JLabel getLblTitle() {
		lblTitle = new JLabel("회 원 가 입");
		lblTitle.setBounds(xPos+115, yPos-50, 100, 30);
		return lblTitle;
	}

//	입력
	private JTextField getTxtAge() {
		txtAge = new JTextField();
		txtAge.setBounds(xPos+100, yPos+50, 100, 30);
		return txtAge;
	}

	private JTextField getTxtName() {
		txtName = new JTextField();
		txtName.setBounds(xPos+100, yPos, 100, 30);
		return txtName;
	}

	private JLabel getLblAge() {
		lblAge = new JLabel();
		lblAge.setText("나 이      :");
		lblAge.setBounds(xPos, yPos+50, 70, 30);
		return lblAge;
	}

	private JLabel getLblName() {
		lblName = new JLabel();
		lblName.setText("성 명      :");
		lblName.setBounds(xPos, yPos, 70, 30);
		return lblName;
	}

//	버튼 그룹
	
	private JButton getBtnInput() {
		btnInput = new JButton();
		btnInput.setText("회원가입");
		btnInput.setBounds(xPos, yPos+150, 100, 30);
		return btnInput;
	}
	
	private Component getBtnReset() {
		btnReset = new JButton();
		btnReset.setText("다시입력");
		btnReset.setBounds(xPos+120, yPos+150, 100, 30);
		return btnReset;
	}
	
	private Component getBtnExit() {
		btnExit = new JButton();
		btnExit.setText("종 료");
		btnExit.setBounds(xPos+240, yPos+150, 70, 30);
		return btnExit;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T05_NullLayout2 t05 = new T05_NullLayout2();
				t05.setVisible(true);
			}
		});
	}
}
