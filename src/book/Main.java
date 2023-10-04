package book;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JButton btnInput, btnIdPw, btnExit, btnLogin;
	private JLabel lblLogin, lblId, lblPw, lblText;
	private JPasswordField txtPw;
	
	DAO dao = new DAO();
	MemberVO mvo = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		getMainView();
	}

	private void getMainView() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(376, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

//		JPanel     -----------------------------------------------------------
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 360, 299);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
//		JLabel     -----------------------------------------------------------
		lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin.setFont(new Font("굴림", Font.BOLD, 16));
		lblLogin.setBounds(68, 26, 220, 35);
		pn1.add(lblLogin);
		
		lblId = new JLabel("ID ");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("굴림", Font.BOLD, 16));
		lblId.setBounds(51, 71, 43, 28);
		pn1.add(lblId);
		
		lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setFont(new Font("굴림", Font.BOLD, 16));
		lblPw.setBounds(51, 118, 43, 28);
		pn1.add(lblPw);
		
		lblText = new JLabel("아직 회원이 아니시면 회원가입을 해주세요.");
		lblText.setBounds(12, 232, 245, 15);
		pn1.add(lblText);
		
//		JTextField     -----------------------------------------------------------
		txtId = new JTextField();
		txtId.setBounds(106, 71, 182, 28);
		pn1.add(txtId);
		txtId.setColumns(10);
		
		txtPw = new JPasswordField();
		txtPw.setBounds(106, 118, 182, 28);
		pn1.add(txtPw);
		
//		JButton     -----------------------------------------------------------
		btnLogin = new JButton("로그인");
		btnLogin.setBounds(205, 169, 83, 23);
		pn1.add(btnLogin);
		
		btnInput = new JButton("회원가입");
		btnInput.setBounds(258, 228, 90, 23);
		pn1.add(btnInput);
		
		btnExit = new JButton("종료");
		btnExit.setBounds(285, 261, 63, 28);
		pn1.add(btnExit);
		
		btnIdPw = new JButton("ID/PW 찾기");
		btnIdPw.setBounds(79, 169, 114, 23);
		pn1.add(btnIdPw);
		
//		------------------------------------------------------------------- 
//		JButton    -------------------------------------------------------- 
//		로그인 버튼
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mvo = new MemberVO();
				String id = txtId.getText();
				String pw = txtPw.getText();
				
//				아이디/비밀번호 공백 배제
				if(id.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
					txtId.requestFocus();
				} else if(pw.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
					txtPw.requestFocus();
				} else {
					mvo = dao.memberSearch(id);
					if(mvo.getId() != null) {
						if(!mvo.getPw().equals(pw)) {
							JOptionPane.showMessageDialog(null, "비밀번호를 다시 확인 후 입력하세요.");
							txtPw.requestFocus();
						} else {
							String rating = mvo.getRating();
							String name = mvo.getName();
							if (rating.equals("관리자")) {
								dispose();
								new SuperPage(id,rating);
							} else {
								dispose();
								new MemberLogin(id,name);	
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "해당 아이디는 등록되어 있지 않습니다.");
						txtId.requestFocus();
					}
				}
			}
		});
		
//		아이디/비밀번호 찾기 버튼
		btnIdPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				dispose();
				new MemberIdPwSearch();
			}
		});
		
//		회원 가입 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MemberInput();
			}
		});
		
//		종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "로그인을 종료합니다");				
				System.exit(0);
			}
		}); 
	}

//	------------------------------------------------------------------- 
//	아이디 비밀번호 찾고 난 후 메인 화면에 찾은 아이디 비밀번호 자동 입력
	public Main(String id, String pw) {
		getMainView();
		txtId.setText(id);
		txtPw.setText(pw);
	}
}
