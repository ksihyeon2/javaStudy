		package book;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class MemberInput extends JFrame {

	private JPanel contentPane,pn1,pn2,pn3;
	private JTextField txtName, txtAge,txtEmail1,txtId,txtPw,txtEmail2;;
	private JLabel lblId,lblPw,lblName,lblAge,lblEmail,lblPhonenum,blbAddress,blbE;
	private JLabel lblNewLabel_1,blbE_1,blbE_2;
	private JTextField txtPhonenum1,txtPhonenum2,txtPhonenum3;
	private JButton btnCheck,btnInput,btnClose;
	private JRadioButton rdbtnMale, rdbtnFeMale;
	private ButtonGroup btnGroup = new ButtonGroup();
	
	// 중복버튼 클릭유무를 확인하기위한 변수
	private int idCheck = 0;
//	private 
	
	DAO dao = new DAO();
	MemberVO vo = null;
	private JTextField txtAddress;

	
	public MemberInput() {
		setTitle("회원가입창");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(520, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

//		JPanel     -----------------------------------------------------------
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBounds(0, 0, 504, 68);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		pn2 = new JPanel();
		pn2.setBounds(0, 67, 504, 520);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		pn3 = new JPanel();
		pn3.setBounds(0, 586, 504, 57);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
//		JLabel     -----------------------------------------------------------
		lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("굴림", Font.BOLD, 16));
		lblId.setBounds(25, 35, 69, 28);
		pn2.add(lblId);
		
		lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setFont(new Font("굴림", Font.BOLD, 16));
		lblPw.setBounds(25, 98, 69, 28);
		pn2.add(lblPw);
		
		lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("굴림", Font.BOLD, 16));
		lblName.setBounds(25, 161, 69, 28);
		pn2.add(lblName);
		
		lblAge = new JLabel("나이");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("굴림", Font.BOLD, 16));
		lblAge.setBounds(25, 224, 69, 28);
		pn2.add(lblAge);
		
		lblEmail = new JLabel("성별");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("굴림", Font.BOLD, 16));
		lblEmail.setBounds(25, 287, 69, 28);
		pn2.add(lblEmail);
		
		lblPhonenum = new JLabel("전화번호");
		lblPhonenum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhonenum.setFont(new Font("굴림", Font.BOLD, 16));
		lblPhonenum.setBounds(25, 350, 69, 28);
		pn2.add(lblPhonenum);
		
		blbAddress = new JLabel("주소");
		blbAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		blbAddress.setFont(new Font("굴림", Font.BOLD, 16));
		blbAddress.setBounds(25, 476, 69, 28);
		pn2.add(blbAddress);

		JLabel lblNewLabel_1_1 = new JLabel("(비밀 번호는 숫자 또는 영문 15자 이내로 입력하세요.)");
		lblNewLabel_1_1.setBounds(112, 129, 380, 22);
		pn2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입 창");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 10, 504, 48);
		pn1.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("(ID는 숫자 또는 영문 5자 이상 10자 이내로 입력하세요.)");
		lblNewLabel_1.setBounds(112, 70, 346, 22);
		pn2.add(lblNewLabel_1);
		
		blbE_1 = new JLabel("-");
		blbE_1.setHorizontalAlignment(SwingConstants.CENTER);
		blbE_1.setBounds(169, 349, 22, 28);
		pn2.add(blbE_1);
		
		blbE_2 = new JLabel("-");
		blbE_2.setHorizontalAlignment(SwingConstants.CENTER);
		blbE_2.setBounds(252, 349, 22, 28);
		pn2.add(blbE_2);
		
		JLabel blbAddress_1 = new JLabel("E-mail");
		blbAddress_1.setHorizontalAlignment(SwingConstants.RIGHT);
		blbAddress_1.setFont(new Font("굴림", Font.BOLD, 16));
		blbAddress_1.setBounds(25, 413, 69, 28);
		pn2.add(blbAddress_1);
		
//		JTextField     -----------------------------------------------------------
		txtId = new JTextField();
		txtId.setBounds(112, 35, 128, 28);
		pn2.add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(112, 161, 128, 28);
		pn2.add(txtName);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(112, 224, 128, 28);
		pn2.add(txtAge);
		
		txtEmail1 = new JTextField();
		txtEmail1.setColumns(10);
		txtEmail1.setBounds(112, 413, 109, 28);
		pn2.add(txtEmail1);
		
		txtEmail2 = new JTextField();
		txtEmail2.setColumns(10);
		txtEmail2.setBounds(250, 413, 109, 28);
		pn2.add(txtEmail2);
		
		txtPhonenum1 = new JTextField();
		txtPhonenum1.setColumns(10);
		txtPhonenum1.setBounds(112, 350, 57, 28);
		pn2.add(txtPhonenum1);
		
		txtPhonenum2 = new JTextField();
		txtPhonenum2.setColumns(10);
		txtPhonenum2.setBounds(194, 350, 57, 28);
		pn2.add(txtPhonenum2);
		
		txtPhonenum3 = new JTextField();
		txtPhonenum3.setColumns(10);
		txtPhonenum3.setBounds(276, 350, 57, 28);
		pn2.add(txtPhonenum3);
		
		blbE = new JLabel("@");
		blbE.setBounds(229, 412, 22, 28);
		pn2.add(blbE);
		
		txtPw = new JTextField();
		txtPw.setColumns(10);
		txtPw.setBounds(112, 98, 128, 28);
		pn2.add(txtPw);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(112, 476, 128, 28);
		pn2.add(txtAddress);
		
//		JScrollPane     -----------------------------------------------------------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(371, 413, 122, 28);
		pn2.add(scrollPane);
		
//		JComboBox     -----------------------------------------------------------
		JComboBox cbEmail = new JComboBox();
		cbEmail.setModel(new DefaultComboBoxModel(new String[] {"직접입력", "gmaill.com", "naver.com", "kakao.com", "daum.net", "nate.com", "google.com", "hanmail.net"}));
		scrollPane.setViewportView(cbEmail);
		
//		JButton     -----------------------------------------------------------
		btnInput = new JButton("가입");
		btnInput.setBounds(328, 10, 76, 37);
		pn3.add(btnInput);
		
		btnCheck = new JButton("중복 확인");
		btnCheck.setBounds(252, 36, 92, 28);
		pn2.add(btnCheck);
		
		btnClose = new JButton("창닫기");
		btnClose.setBounds(416, 10, 76, 37);
		pn3.add(btnClose);
		
//		ButtonGroup -----------------------------------------------------------------
		rdbtnMale = new JRadioButton("남성");
		rdbtnMale.setBounds(124, 287, 67, 28);
		btnGroup.add(rdbtnMale);
		pn2.add(rdbtnMale);
		
		rdbtnFeMale = new JRadioButton("여성");
		rdbtnFeMale.setBounds(215, 287, 67, 28);
		btnGroup.add(rdbtnFeMale);
		pn2.add(rdbtnFeMale);		
//		-------------------------------------------------------------------
//		JButton     -----------------------------------------------------------
//		중복 확인 버튼
		
		btnCheck.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String id = txtId.getText();
			if(id.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "ID를 입력하세요");
				txtId.setText("");
				txtId.requestFocus();
			} else if (!Pattern.matches("^[a-z0-9]*$", id)) {
				JOptionPane.showMessageDialog(null, "ID는 영문과 숫자를 혼합하여 입력해 주세요");			
				txtId.setText("");
				txtId.requestFocus();
			} else if (id.length() < 5 || id.length() > 10) {
				JOptionPane.showMessageDialog(null, "ID는 5글자 이상 10글자 이내로 입력해 주세요.");
				txtId.setText("");
				txtId.requestFocus();
			}	else {
				vo = dao.memberSearch(id);
				if(vo.getId() != null) {
					JOptionPane.showMessageDialog(null, "사용중인 ID 입니다. \n 다른 아이디를 입력해 주세요");
					txtId.setText("");
					txtId.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null, "사용 가능한 ID 입니다.");
					txtPw.requestFocus();
				}
			}
			idCheck = 1;
		}
	});
	
//		가입 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vo = new MemberVO();
				String id = txtId.getText();
				if(id.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "ID를 다시 입력하세요.");
					txtId.setText("");
					txtId.requestFocus();
				} else if (!Pattern.matches("^[a-z0-9]*$", id)) {
					JOptionPane.showMessageDialog(null, "ID는 영문과 숫자를 혼합하여 입력해 주세요");			
					txtId.setText("");
					txtId.requestFocus();
				} else if (id.length() < 5 || id.length() > 10) {
					JOptionPane.showMessageDialog(null, "ID는 5자 이상 10자 이내로 입력해 주세요.");
					txtId.setText("");
					txtId.requestFocus();
				}
				
				String pw = txtPw.getText();
				if(pw.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Pw를 다시 입력하세요");
					txtPw.setText("");
					txtPw.requestFocus();
				} else if  (!Pattern.matches("^[a-z0-9]*$", pw)) {
					JOptionPane.showMessageDialog(null, "PW는 영문과 숫자만 입력해 주세요");			
					txtPw.setText("");
					txtPw.requestFocus();
				} else if (id.length() > 10) {
					JOptionPane.showMessageDialog(null, "Pw는 10자 이내로 입력해 주세요.");
					txtId.setText("");
					txtId.requestFocus();
				}
				
				String name = txtName.getText();
				if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명 다시 입력하세요");
					txtName.setText("");
					txtName.requestFocus();
				} else if(Pattern.matches("^[a-z0-9]*$", name)) {
					JOptionPane.showMessageDialog(null, "성명은 한글로 입력해 주세요");			
					txtName.setText("");
					txtName.requestFocus();
				}
				
				int age = Integer.parseInt(txtAge.getText());
				if(txtAge.getText() == "") {
					JOptionPane.showMessageDialog(null, "나이를 다시 입력하세요");
					txtAge.setText("");
					txtAge.requestFocus();
				} else if(!Pattern.matches("^[0-9]*$", txtAge.getText())) {
					JOptionPane.showMessageDialog(null, "나이는 숫자로 입력해 주세요");			
					txtAge.setText("");
					txtAge.requestFocus();
				}
				
				if(!cbEmail.getSelectedItem().equals("직접입력")) {
					txtEmail2.setText(cbEmail.getSelectedItem().toString());
				}
				String email = txtEmail1.getText()+"@"+txtEmail2.getText();
				String phoneNum = txtPhonenum1.getText()+"-"+txtPhonenum2.getText()+"-"+txtPhonenum3.getText();
				String[] phoneN = phoneNum.split("-");
				for(int i=0; i<phoneN.length; i++) {
					if(!Pattern.matches("^[0-9]*$",phoneN[i])) {
						JOptionPane.showMessageDialog(null, "전화번호는 숫자로 입력해 주세요.");
						txtPhonenum1.setText("");
						txtPhonenum2.setText("");
						txtPhonenum3.setText("");
						txtPhonenum1.requestFocus();
						break;
					}
				}
				String address = txtAddress.getText();
				String gender;
				if(rdbtnMale.isSelected()) {
					gender = "남자";
				} else {
					gender = "여자";
				}
				
//				아이디 중복 확인 했을때만 가입 가능하게 하기
				if(idCheck == 0) {
					JOptionPane.showMessageDialog(null, "ID 중복을 확인해 주세요.");
				} else {
					vo.setId(id);
					vo.setPw(pw);
					vo.setName(name);
					vo.setGender(gender);
					vo.setAge(age);
					vo.setEmail(email);
					vo.setPhonenum(phoneNum);
					vo.setAddress(address);
					
					int res = dao.memberInput(vo);
					if(res == 0) {
						JOptionPane.showMessageDialog(null, "회원 가입에 실패하셨습니다.");
						txtId.setText("");
						txtPw.setText("");
						txtName.setText("");
//						성별 초기화
						txtAge.setText("");
						txtEmail1.setText("");
						txtEmail2.setText("");
						txtPhonenum1.setText("");
						txtAddress.setText("");
						txtId.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, name + "님 회원가입을 축하드립니다.");
						dispose();
					}
				}
			}
		});
		
//		email 주소 직접입력 외에 선택했을때 자동 입력
		cbEmail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtEmail2.setText(cbEmail.getSelectedItem().toString());
			}
		});
		
//		닫기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInternalMessageDialog(null, "회원가입을 종료합니다");
				dispose();
			}
		});
	}
}
