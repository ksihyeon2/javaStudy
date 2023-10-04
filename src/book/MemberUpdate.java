package book;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class MemberUpdate extends JFrame {

	private JPanel contentPane;
	private JButton btnClose, btnUpdate;
	private ButtonGroup btnGroup = new ButtonGroup();
	
	DAO dao = new DAO();
	MemberVO vo;

	public MemberUpdate(String id,String name) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(520, 682);
		setTitle("정보 수정");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 504, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("정보 수정");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 504, 45);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 43, 504, 541);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("굴림", Font.BOLD, 16));
		lblId.setBounds(12, 38, 69, 28);
		panel_1.add(lblId);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setFont(new Font("굴림", Font.BOLD, 16));
		lblPw.setBounds(12, 101, 69, 28);
		panel_1.add(lblPw);

		JLabel lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("굴림", Font.BOLD, 16));
		lblName.setBounds(12, 164, 69, 28);
		panel_1.add(lblName);
		
		JLabel lblAge = new JLabel("나이");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("굴림", Font.BOLD, 16));
		lblAge.setBounds(12, 227, 69, 28);
		panel_1.add(lblAge);

		JLabel lblEmail = new JLabel("성별");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("굴림", Font.BOLD, 16));
		lblEmail.setBounds(12, 290, 69, 28);
		panel_1.add(lblEmail);

//  -------------------------------------------------------------------		
		vo = new MemberVO();
		vo = dao.memberSearch(id);
		String[] phonenum = vo.getPhonenum().split("-");
		String[] email = vo.getEmail().split("@");
		
		JTextField txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setText(vo.getId());
		txtId.setBounds(99, 38, 128, 28);
		panel_1.add(txtId);
		
		JTextField txtPw = new JTextField();
		txtPw.setColumns(10);
		txtPw.setText(vo.getPw());
		txtPw.setBounds(99, 101, 128, 28);
		panel_1.add(txtPw);
		
		JTextField txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setText(vo.getName());
		txtName.setBounds(99, 164, 128, 28);
		panel_1.add(txtName);
		
		JTextField txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setText(vo.getAge()+"");
		txtAge.setBounds(99, 227, 128, 28);
		panel_1.add(txtAge);

		JTextField txtNum1 = new JTextField();
		txtNum1.setColumns(10);
		txtNum1.setText(phonenum[0]);
		txtNum1.setBounds(99, 353, 57, 28);
		panel_1.add(txtNum1);
		
		JTextField txtNum2 = new JTextField();
		txtNum2.setColumns(10);
		txtNum2.setText(phonenum[1]);
		txtNum2.setBounds(181, 353, 57, 28);
		panel_1.add(txtNum2);
		
		JTextField txtNum3 = new JTextField();
		txtNum3.setColumns(10);
		txtNum3.setText(phonenum[2]);
		txtNum3.setBounds(263, 353, 57, 28);
		panel_1.add(txtNum3);

		JTextField txtEmail1 = new JTextField();
		txtEmail1.setColumns(10);
		txtEmail1.setText(email[0]);
		txtEmail1.setBounds(99, 416, 109, 28);
		panel_1.add(txtEmail1);
		
		JTextField txtEmail2 = new JTextField();
		txtEmail2.setColumns(10);
		txtEmail2.setText(email[1]);
		txtEmail2.setBounds(237, 416, 109, 28);
		panel_1.add(txtEmail2);

		JTextField txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setText(vo.getAddress());
		txtAddress.setBounds(99, 479, 128, 28);
		panel_1.add(txtAddress);
//  -------------------------------------------------------------------		
		
		JRadioButton rdMale = new JRadioButton("남성");
		rdMale.setBounds(111, 290, 67, 28);
		btnGroup.add(rdMale);
		panel_1.add(rdMale);
		
		
		JRadioButton rdFeMale = new JRadioButton("여성");
		rdFeMale.setBounds(202, 290, 67, 28);
		btnGroup.add(rdFeMale);
		panel_1.add(rdFeMale);
		
		if(vo.getGender().equals("남자")) {
			rdMale.setSelected(true);
		} else {
			rdFeMale.setSelected(true);
		}
		
//  -------------------------------------------------------------------		
		JLabel lblPhonenum = new JLabel("전화번호");
		lblPhonenum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhonenum.setFont(new Font("굴림", Font.BOLD, 16));
		lblPhonenum.setBounds(12, 353, 69, 28);
		panel_1.add(lblPhonenum);
		
		
		JLabel blbE_1 = new JLabel("-");
		blbE_1.setHorizontalAlignment(SwingConstants.CENTER);
		blbE_1.setBounds(156, 352, 22, 28);
		panel_1.add(blbE_1);
		
		JLabel blbE_2 = new JLabel("-");
		blbE_2.setHorizontalAlignment(SwingConstants.CENTER);
		blbE_2.setBounds(239, 352, 22, 28);
		panel_1.add(blbE_2);
		
		JLabel blbAddress_1 = new JLabel("E-mail");
		blbAddress_1.setHorizontalAlignment(SwingConstants.RIGHT);
		blbAddress_1.setFont(new Font("굴림", Font.BOLD, 16));
		blbAddress_1.setBounds(12, 416, 69, 28);
		panel_1.add(blbAddress_1);
		
		
		JLabel blbE = new JLabel("@");
		blbE.setBounds(216, 415, 22, 28);
		panel_1.add(blbE);

		JComboBox cbEmail = new JComboBox();
		cbEmail.setModel(new DefaultComboBoxModel(new String[] {"직접입력", "gmaill.com", "naver.com", "kakao.com", "daum.net", "nate.com", "google.com", "hanmail.net"}));
		cbEmail.setBounds(359, 417, 120, 26);
		panel_1.add(cbEmail);
		
		JLabel blbAddress = new JLabel("주소");
		blbAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		blbAddress.setFont(new Font("굴림", Font.BOLD, 16));
		blbAddress.setBounds(12, 479, 69, 28);
		panel_1.add(blbAddress);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 582, 504, 61);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnClose = new JButton("닫기");
		btnClose.setBounds(412, 16, 80, 35);
		pn3.add(btnClose);
		
		btnUpdate = new JButton("수정");
		btnUpdate.setBounds(320, 16, 80, 35);
		pn3.add(btnUpdate);
		
//		--------------------------------------------------------------
//		수정 버튼
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vo = new MemberVO();
				String id = txtId.getText();
				String pw = txtPw.getText();
				String name = txtName.getText();
				String age = txtAge.getText();
				String gender;
				if(rdMale.isSelected()) {
					gender = "남자";
				} else {
					gender = "여자";
				}
				String num = txtNum1.getText() +"-"+ txtNum2.getText() +"-"+ txtNum3.getText();
				String email= txtEmail1.getText() + "@" + txtEmail2.getText();
				String address = txtAddress.getText();
				
				vo.setId(id);
				vo.setPw(pw);
				vo.setName(name);
				vo.setAge(Integer.parseInt(age));
				vo.setGender(gender);
				vo.setPhonenum(num);
				vo.setEmail(email);
				vo.setAddress(address);
				
				int res = dao.memberUpdate(vo);
				if(res == 0) {
					JOptionPane.showInternalMessageDialog(null, "수정에 실패했습니다.");
				} else {
					JOptionPane.showMessageDialog(null, "수정 성공");
					dispose();
					new MemberMypage(id, name);
				}
			}
		});
//	email 주소 직접입력 외에 선택했을때 자동 입력
	cbEmail.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			txtEmail2.setText(cbEmail.getSelectedItem().toString());
		}
	});
		
//		닫기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "수정을 종료하시겠습니까?","수정창",JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					dispose();
					new MemberMypage(id, name);
				}
			}
		});
		
	}
}
