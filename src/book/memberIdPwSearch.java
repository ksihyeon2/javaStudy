package book;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class memberIdPwSearch extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail1,txtEmail2,txtName;
	private JButton btnIdSearch, btnPwSearch;

	public memberIdPwSearch() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(526,269);
		setTitle("아이디/비밀번호 찾기");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 510, 230);
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
		
		JComboBox cbEmail = new JComboBox();
		cbEmail.setModel(new DefaultComboBoxModel(new String[] {"직접입력", "gmaill.com", "naver.com", "kakao.com", "daum.net", "nate.com", "google.com", "hanmail.net"}));
		cbEmail.setBounds(367, 122, 120, 26);
		pn1.add(cbEmail);
		
		
		btnIdSearch = new JButton("찾기");
		btnIdSearch.setBounds(108, 159, 71, 33);
		pn1.add(btnIdSearch);
		
		btnPwSearch = new JButton("PW 찾기");
		btnPwSearch.setBounds(398, 182, 94, 33);
		pn1.add(btnPwSearch);
		
//		----------------------------------------------------------------------------------    //
//		ID 찾기
		btnIdSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String email = txtEmail1.getText() + "@" + txtEmail2.getText();
				
				
			}
		});
	}

}
