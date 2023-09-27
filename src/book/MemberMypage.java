package book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MemberMypage extends JFrame {

	private JPanel contentPane;
	private JButton btnLogout, btnModify;

	DAO dao = new DAO();
	MemberVO mvo;
	
	public MemberMypage(String id, String name) {
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(name + "님의 마이페이지");
		setSize(834,492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 984, 23);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("메뉴");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuHome = new JMenuItem("홈");
		mnNewMenu.add(menuHome);
		
		JMenuItem menuCart = new JMenuItem("장바구니");
		mnNewMenu.add(menuCart);
		
		JMenuItem menuExit = new JMenuItem("종료");
		mnNewMenu.add(menuExit);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 21, 252, 432);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(253, 21, 565, 432);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("주문 상품");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_3.setBounds(12, 10, 95, 23);
		pn2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("등록 문의");
		lblNewLabel_3_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(12, 191, 95, 23);
		pn2.add(lblNewLabel_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 43, 541, 128);
		pn2.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 224, 541, 128);
		pn2.add(scrollPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(12, 49, 57, 23);
		pn1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("나이");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(12, 83, 57, 23);
		pn1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("이메일");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(12, 117, 57, 23);
		pn1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("회원 등급");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(12, 185, 57, 23);
		pn1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("포인트");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1.setBounds(12, 151, 57, 23);
		pn1.add(lblNewLabel_1_1_1_1_1);
//		---------------------------------------------------------------------
		mvo = dao.memberSearch(id);
		
		JLabel lblNewLabel = new JLabel(name + "님 프로필");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 10, 228, 29);
		pn1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel(id);
		lblNewLabel_2.setBounds(89, 49, 139, 23);
		pn1.add(lblNewLabel_2);
		
		JLabel lblAge = new JLabel(mvo.getAge()+" 세");
		lblAge.setBounds(89, 83, 139, 23);
		pn1.add(lblAge);
		
		
		JLabel lblEmail = new JLabel(mvo.getEmail());
		lblEmail.setBounds(89, 117, 139, 23);
		pn1.add(lblEmail);
		
		JLabel lblPoint = new JLabel(mvo.getPoint() + "Point");
		lblPoint.setBounds(89, 151, 139, 23);
		pn1.add(lblPoint);
		
		JLabel lblRating = new JLabel("< " + mvo.getRating() + " >");
		lblRating.setBounds(89, 185, 139, 23);
		pn1.add(lblRating);
		
		btnModify = new JButton("정보 수정");
		btnModify.setBounds(12, 218, 99, 29);
		pn1.add(btnModify);
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setBounds(141, 218, 99, 29);
		pn1.add(btnLogout);
	
		
		
//		----------------------------------------------------------------
//		메뉴 홈 버튼
		menuHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MemberLogin(id,name);
			}
		});
		
//		메뉴 종료 버튼
		menuExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					System.exit(0);
				}
			}
		});
		
//		정보 수정 버튼
		btnModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String pw = JOptionPane.showInputDialog(null, "회원 수정을 위해 비밀번호를 입력하세요.");
				if(!mvo.getPw().equals(pw)) {
					JOptionPane.showInternalMessageDialog(null, "정보가 일치하지 않습니다.");
				} else {
					new MemberUpdate(id);
					dispose();
				}
			}
		});
		
//		로그아웃 버튼
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);
				if (ans == 0) {
					dispose(); 
					String id = "";
					String pw = "";
					new Main(id,pw);
				}
			}
		});
	}
}
