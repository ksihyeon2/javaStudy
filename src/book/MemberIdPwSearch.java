	package book;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MemberIdPwSearch extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail1,txtEmail2,txtName;
	private JButton btnIdSearch, btnPwSearch, btnClose;
	private JTextField txtID;
	
	DAO dao = new DAO();
	MemberVO vo = new MemberVO();
	
	String id = "";
	String pw = "";

	public MemberIdPwSearch() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(526,361);
		setTitle("아이디/비밀번호 찾기");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 510, 322);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID 찾기");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setBounds(35, 27, 114, 27);
		pn1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("성 명");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1.setBounds(12, 78, 71, 28);
		pn1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("E-mail");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(12, 121, 71, 28);
		pn1.add(lblNewLabel_1_1);
		
		JLabel blbE = new JLabel("@");
		blbE.setBounds(222, 122, 22, 28);
		pn1.add(blbE);
		
		txtEmail1 = new JTextField();
		txtEmail1.setColumns(10);
		txtEmail1.setBounds(108, 121, 109, 28);
		pn1.add(txtEmail1);
		
		txtEmail2 = new JTextField();
		txtEmail2.setColumns(10);
		txtEmail2.setBounds(242, 121, 109, 28);
		pn1.add(txtEmail2);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(108, 78, 109, 28);
		pn1.add(txtName);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(108, 216, 140, 28);
		pn1.add(txtID);
		
		JComboBox cbEmail = new JComboBox();
		cbEmail.setModel(new DefaultComboBoxModel(new String[] {"직접입력", "gmaill.com", "naver.com", "kakao.com", "daum.net", "nate.com", "google.com", "hanmail.net"}));
		cbEmail.setBounds(367, 122, 120, 26);
		pn1.add(cbEmail);
		
		
		btnIdSearch = new JButton("ID 검색");
		btnIdSearch.setBounds(108, 159, 81, 33);
		pn1.add(btnIdSearch);
		
		btnPwSearch = new JButton("PW 찾기");
		btnPwSearch.setBounds(108, 259, 94, 33);
		pn1.add(btnPwSearch);
		
		btnClose = new JButton("닫기");
		btnClose.setBounds(404, 279, 94, 33);
		pn1.add(btnClose);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(12, 216, 71, 28);
		pn1.add(lblNewLabel_1_1_1);
		
		
//		----------------------------------------------------------------------------------    //
//		ID 찾기
		btnIdSearch.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {				
				String name = txtName.getText();
				String email = txtEmail1.getText() + "@" + txtEmail2.getText();
				
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요");
					txtName.requestFocus();
				} else if(email.equals("")) {
					JOptionPane.showMessageDialog(null, "이메일을 입력하세요");
					txtEmail1.requestFocus();
				} else {
					vo = dao.memberSearchIDPW(name,email);
					if(vo.getId() == null) {
						JOptionPane.showMessageDialog(null, "해당 정보의 회원이 가입되어 있지 않습니다.");
					} else {
						id = vo.getId();
						txtID.setText(vo.getId());
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
		
//		pw 찾기 버튼
		btnPwSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String id = txtID.getText();
				if(id.equals("")) {
					JOptionPane.showMessageDialog(null, "ID를 입력하세요");
				} else {
					JOptionPane.showMessageDialog(null, name + "님의 비밀번호는 ' " +vo.getPw()+ " ' 입니다." );
					pw = vo.getPw();
				}
			}
		});
		
//		닫기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "ID/PW 찾기 창을 종료합니다.");
				dispose();
				new Main(id,pw);
			}
		});
	}
}
