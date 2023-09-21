package WindowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class T01 extends JFrame {

	private JPanel contentPane;
	private JTextField txtMid;
	private JTextField txtName;
	private JTextField txtSosok;
	private JButton btnClose, btnInput, btnReset;
	private JPasswordField txtPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T01 frame = new T01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public T01() {
		setTitle("스윙연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" 회 원 가 입 창");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("경기천년바탕 Bold", Font.BOLD, 20));
		lblNewLabel.setBounds(51, 10, 664, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("소속");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 18));
		lblNewLabel_1.setBounds(166, 437, 125, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("성명");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(166, 318, 125, 37);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(166, 199, 125, 37);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("ID");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(166, 80, 125, 37);
		contentPane.add(lblNewLabel_1_3);
		
		txtMid = new JTextField();
		txtMid.setFont(new Font("경기천년바탕 Bold", Font.BOLD, 18));
		txtMid.setBounds(303, 80, 294, 37);
		contentPane.add(txtMid);
		txtMid.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("경기천년바탕 Bold", Font.BOLD, 18));
		txtName.setColumns(10);
		txtName.setBounds(303, 318, 294, 37);
		contentPane.add(txtName);
		
		txtSosok = new JTextField();
		txtSosok.setFont(new Font("경기천년바탕 Bold", Font.BOLD, 18));
		txtSosok.setColumns(10);
		txtSosok.setBounds(303, 437, 294, 37);
		contentPane.add(txtSosok);
		
//		회원가입 버튼
		btnInput = new JButton("회원가입");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "";
				str += "아이디 : " + txtMid.getText() + "\n";
				str += "비밀번호 : " + txtPwd.getText() + "\n";
				str += "성 명 : " + txtName.getText() + "\n";
				str += "소 속 : " + txtSosok.getText() + "\n";
				JOptionPane.showMessageDialog(null, str + "\n회원가입이 되었습니다.");
			}
		});
		btnInput.setFont(new Font("경기천년바탕 Bold", Font.BOLD, 18));
		btnInput.setBounds(157, 497, 151, 37);
		contentPane.add(btnInput);
		
//		reset 버튼
		btnReset = new JButton("다시입력");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMid.setText("");
				txtPwd.setText("");
				txtName.setText("");
				txtSosok.setText("");
			}
		});
		btnReset.setFont(new Font("경기천년바탕 Bold", Font.BOLD, 18));
		btnReset.setBounds(343, 497, 151, 37);
		contentPane.add(btnReset);
		
		
//		창닫기 버튼
		btnClose = new JButton("창닫기");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setFont(new Font("경기천년바탕 Bold", Font.BOLD, 18));
		btnClose.setBounds(532, 497, 151, 37);
		contentPane.add(btnClose);
		
		txtPwd = new JPasswordField();
		txtPwd.setFont(new Font("경기천년바탕 Bold", Font.BOLD, 18));
		txtPwd.setBounds(303, 199, 294, 37);
		contentPane.add(txtPwd);
	}
}
