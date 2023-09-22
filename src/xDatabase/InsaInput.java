package xDatabase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class InsaInput extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdMale, rdFeMale;
	private JButton btnInput, btnReset, btnClose;

	InsaDAO dao = new InsaDAO();
	InsaVO vo = null;
	int res = 0;
	
	public InsaInput() {
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 684, 75);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("회 원 가 입 폼");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 684, 55);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 76, 684, 311);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("성  명  :");
		lblName.setFont(new Font("굴림", Font.BOLD, 24));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(155, 39, 116, 40);
		pn2.add(lblName);
		
		JLabel lblName_1 = new JLabel("나  이  :");
		lblName_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_1.setFont(new Font("굴림", Font.BOLD, 24));
		lblName_1.setBounds(155, 105, 116, 40);
		pn2.add(lblName_1);
		
		JLabel lblName_2 = new JLabel("성  별  :");
		lblName_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_2.setFont(new Font("굴림", Font.BOLD, 24));
		lblName_2.setBounds(155, 173, 116, 40);
		pn2.add(lblName_2);
		
		JLabel lblName_3 = new JLabel("입 사 일  :");
		lblName_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_3.setFont(new Font("굴림", Font.BOLD, 24));
		lblName_3.setBounds(155, 237, 116, 40);
		pn2.add(lblName_3);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.BOLD, 24));
		txtName.setBounds(309, 39, 209, 40);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("굴림", Font.BOLD, 24));
		txtAge.setColumns(10);
		txtAge.setBounds(309, 105, 209, 40);
		pn2.add(txtAge);
		
		rdMale = new JRadioButton("남자");
		rdMale.setFont(new Font("굴림", Font.PLAIN, 22));
		rdMale.setBounds(309, 177, 102, 34);
		buttonGroup.add(rdMale);
		pn2.add(rdMale);
		
		rdFeMale = new JRadioButton("여자");
		rdFeMale.setSelected(true);
		rdFeMale.setFont(new Font("굴림", Font.PLAIN, 22));
		rdFeMale.setBounds(432, 177, 102, 34);
		buttonGroup.add(rdFeMale);
		pn2.add(rdFeMale);
		
		String[] yy = new String[25];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		int imsi;
		for(int i=0; i<yy.length; i++) {
			imsi = i + 2000;
			yy[i] = imsi+"";
 		}
		for(int i=0; i<mm.length; i++) {
			mm[i] = (i+1)+"";
		}
		for(int i=0; i<dd.length; i++) {
			dd[i] = (i+1)+"";
		}
		
		JComboBox cbYY = new JComboBox(yy);
		cbYY.setFont(new Font("굴림", Font.PLAIN, 15));
		cbYY.setBounds(309, 237, 91, 34);
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);
		cbMM.setFont(new Font("굴림", Font.PLAIN, 15));
		cbMM.setBounds(434, 237, 54, 34);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);
		cbDD.setFont(new Font("굴림", Font.PLAIN, 15));
		cbDD.setBounds(532, 237, 54, 34);
		pn2.add(cbDD);
		
		JLabel lblNewLabel_1 = new JLabel("년");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(412, 237, 24, 35);
		pn2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("월");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(494, 237, 24, 35);
		pn2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("일");
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(592, 237, 24, 35);
		pn2.add(lblNewLabel_1_1_1);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 397, 684, 63);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("가입하기");
		btnInput.setFont(new Font("굴림", Font.BOLD, 20));
		btnInput.setBounds(65, 10, 130, 43);
		pn3.add(btnInput);
		
		btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("굴림", Font.BOLD, 20));
		btnReset.setBounds(269, 10, 130, 43);
		pn3.add(btnReset);
		
		btnClose = new JButton("창닫기");
		btnClose.setFont(new Font("굴림", Font.BOLD, 20));
		btnClose.setBounds(477, 10, 130, 43);
		pn3.add(btnClose);
		
		
//		====================================================    //
//		가입 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String age = txtAge.getText();
				String gender;
				String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
				
				if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요");
					txtName.requestFocus();
				} else if (age.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "나이를 입력하세요");
					txtAge.requestFocus();
				} else {
					if(!Pattern.matches("^[0-9]*$", age)) {
						JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요");
						txtAge.setText("");
						txtAge.requestFocus();
					} else {
						if(rdMale.isSelected()) {
							gender = "남자";
						} else {
							gender = "여자";
						}
//						모든 체크가 끝나면 DB에 새로운 회원을 가입처리 한다.
//						회원명 중복 처리
						vo = dao.getNameSearch(name);
						if(vo.getName() != null) {
							JOptionPane.showMessageDialog(null, "이미 가입된 회원입니다. \n 다시 입력하세요.");
							txtName.requestFocus();
						} else {
//							정상적으로 자료가 입력되었다면 vo에 담아있는 값을 DB에 저장
							vo.setName(name);
							vo.setAge(Integer.parseInt(age));
							vo.setGender(gender);
							vo.setIpsail(ipsail);
//							vo에 담긴 자료를 DB에 저장시켜준다.
							res = dao.setInsaInput(vo);
							if(res == 0) {
								JOptionPane.showMessageDialog(null, "회원가입에 실패했습니다. \n 다시 가입하세요.");
								txtName.requestFocus();
							} else {
								JOptionPane.showMessageDialog(null, name + "님 회원가입이 완료되었습니다.");
							}
//								다음 입력자료 처리를 위한 준비
							btnReset.doClick();
						}
					}
				}
			}
		});
		
//		다시입력 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				rdFeMale.setSelected(true);
//				오늘 날짜로 입사일 초기화
				InsaService service = new InsaService();
				vo = service.getDefaultDate();
				cbYY.setSelectedItem(vo.getStrYY());
				cbMM.setSelectedItem(vo.getStrDD());
				cbDD.setSelectedItem(vo.getStrMM());
//				cbYY.setSelectedItem(yy[0]);
//				cbMM.setSelectedItem(dd[0]);
//				cbDD.setSelectedItem(mm[0]);
				txtName.requestFocus();
			}
		});
		
//		창닫기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "창을 닫겠습니다.");
				dispose();
			}
		});
	}
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InsaInput frame = new InsaInput();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				} 
//			}
//		});
		new InsaInput();
	}
}
