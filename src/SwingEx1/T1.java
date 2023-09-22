package SwingEx1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T1 extends JFrame{
	private JButton btnExit,btnOk;
	private JLabel lbl, lblName, blbAge;
	private JTextField txtName, txtAge;
	private int xPos=140, yPos=0;
	
	public T1() {
		setTitle("연습");
		setSize(350, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(null);
		
		add(getBtnExit());
		add(getBtnOk());
		add(getLbl());
		add(getLblName());
		add(getLblAge());
		add(getTxtName());
		add(getTxtAge());
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "회원가입을 종료하겠습니다.");
				System.exit(0);
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, txtName.getText() + "님 가입에 성공하셨습니다.");
			}
		});
		
	}
	
	private JButton getBtnOk() {
		btnOk = new JButton();
		btnOk.setText("확인");
		btnOk.setBounds(160, 320, 70, 30);
		return btnOk;
	}

	private JTextField getTxtAge() {
		txtAge = new JTextField();
		txtAge.setBounds(xPos-10, yPos+150, 70, 30);
		return txtAge;
	}


	private JTextField getTxtName() {
		txtName = new JTextField();
		txtName.setBounds(xPos-10, yPos+100, 70, 30);
		return txtName;
	}

	private JLabel getLblAge() {
		blbAge = new JLabel();
		blbAge.setText("나 이   :");
		blbAge.setBounds(xPos-70, yPos+150, 70, 30);
		return blbAge;
	}

	private JLabel getLblName() {
		lblName = new JLabel();
		lblName.setText("성 명   :");
		lblName.setBounds(xPos-70, yPos+100, 70, 30);
		return lblName;
	}

	private JLabel getLbl() {
		lbl = new JLabel();
		lbl.setText("회원가입");
		lbl.setBounds(xPos, yPos, 350, 30);
		return lbl;
	}

	private JButton getBtnExit() {
		btnExit = new JButton();
		btnExit.setText("종료");
		btnExit.setBounds(250, 320, 70, 30);
		return btnExit;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T1 t1 = new T1();
				t1.setVisible(true);
			}
		});
	}
}
