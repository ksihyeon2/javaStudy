package book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MemberMypage extends JFrame {

	private JPanel contentPane;
	private JTable tblBuyList;
	private JTable tblUpdateList;
	private JButton btnLogout,btnMain,btnModify,btnMemberDrop;
	private JScrollPane scrBuyList,scrUpdateList;
	
	@SuppressWarnings("rawtypes")
	Vector Booktitle,BookvData,Updatetitle,UpdatevData;
	DefaultTableModel dtm;
	
	DAO dao = new DAO();
	MemberVO mvo;
	
	public MemberMypage(String id, String name) {
		setVisible(true);
		setTitle(name + "님의 마이페이지");
		setSize(834,451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
//		JPanel     -----------------------------------------------------------
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 252, 412);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(253, 0, 565, 412);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
//		JScrollPane     -----------------------------------------------------------
		Booktitle = new Vector<>();
		Booktitle.add("책이름");
		Booktitle.add("개수");
		Booktitle.add("구매 날짜");
		
		BookvData = dao.getBuyList(id);
		
		dtm = new DefaultTableModel(BookvData, Booktitle);
		
		tblBuyList = new JTable(dtm);
		
		scrBuyList = new JScrollPane(tblBuyList);
		scrBuyList.setBounds(12, 43, 541, 128);
		
		pn2.add(scrBuyList);
		
		Updatetitle = new Vector<>();
		Updatetitle.add("책 이름");
		Updatetitle.add("현재 상태");
		
		UpdatevData = dao.getUpdateList(id);
		
		dtm = new DefaultTableModel(UpdatevData,Updatetitle);
		
		tblUpdateList = new JTable(dtm);
		
		scrUpdateList = new JScrollPane(tblUpdateList);
		scrUpdateList.setBounds(12, 224, 541, 128);
		
		pn2.add(scrUpdateList);
		
//		JLabel     -----------------------------------------------------------
		JLabel lbl1 = new JLabel("아이디");
		lbl1.setFont(new Font("굴림", Font.BOLD, 12));
		lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl1.setBounds(12, 66, 57, 23);
		pn1.add(lbl1);
		
		JLabel lbl2 = new JLabel("나이");
		lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl2.setFont(new Font("굴림", Font.BOLD, 12));
		lbl2.setBounds(12, 104, 57, 23);
		pn1.add(lbl2);

		JLabel lbl3 = new JLabel("이메일");
		lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl3.setFont(new Font("굴림", Font.BOLD, 12));
		lbl3.setBounds(12, 142, 57, 23);
		pn1.add(lbl3);
		
		JLabel lbl4 = new JLabel("회원 등급");
		lbl4.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl4.setFont(new Font("굴림", Font.BOLD, 12));
		lbl4.setBounds(12, 218, 57, 23);
		pn1.add(lbl4);
		
		JLabel lbl5 = new JLabel("포인트");
		lbl5.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl5.setFont(new Font("굴림", Font.BOLD, 12));
		lbl5.setBounds(12, 180, 57, 23);
		pn1.add(lbl5);
		
		JLabel lbl6 = new JLabel("주문 상품");
		lbl6.setFont(new Font("굴림", Font.BOLD, 14));
		lbl6.setBounds(12, 10, 95, 23);
		pn2.add(lbl6);
		
		JLabel lbl7 = new JLabel("등록 대기건");
		lbl7.setFont(new Font("굴림", Font.BOLD, 14));
		lbl7.setBounds(12, 191, 95, 23);
		pn2.add(lbl7);
		
//		JLabel Text 입력  -----------------------------------------------------------
		mvo = dao.memberSearch(id);
		
		JLabel lblProfile = new JLabel(name + "님 프로필");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("굴림", Font.BOLD, 14));
		lblProfile.setBounds(12, 22, 228, 29);
		pn1.add(lblProfile);
		
		JLabel lblName = new JLabel(id);
		lblName.setBounds(91, 66, 139, 23);
		pn1.add(lblName);
		
		JLabel lblAge = new JLabel(mvo.getAge()+" 세");
		lblAge.setBounds(91, 104, 139, 23);
		pn1.add(lblAge);
		
		JLabel lblEmail = new JLabel(mvo.getEmail());
		lblEmail.setBounds(91, 142, 139, 23);
		pn1.add(lblEmail);
		
		JLabel lblPoint = new JLabel(mvo.getPoint() + "Point");
		lblPoint.setBounds(89, 180, 139, 23);
		pn1.add(lblPoint);
		
		JLabel lblRating = new JLabel("< " + mvo.getRating() + " >");
		lblRating.setBounds(89, 218, 139, 23);
		pn1.add(lblRating);
		
//		JButton  -----------------------------------------------------------
		btnLogout = new JButton("로그아웃");
		btnLogout.setBounds(141, 313, 99, 29);
		pn1.add(btnLogout);
		
		btnMain = new JButton("메인화면");
		btnMain.setBounds(141, 274, 99, 29);
		pn1.add(btnMain);
		
		btnModify = new JButton("정보 수정");
		btnModify.setBounds(12, 274, 99, 29);
		pn1.add(btnModify);
		
		btnMemberDrop = new JButton("탈퇴하기");
		btnMemberDrop.setBounds(12, 313, 99, 29);
		pn1.add(btnMemberDrop);
		
//		--------------------------------------------------------------------
//		JButton  -----------------------------------------------------------
//		정보 수정 버튼
		btnModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mvo = dao.memberSearch(id);
				String pw = JOptionPane.showInputDialog(null, "회원 수정을 위해 비밀번호를 입력하세요.");
				if(!mvo.getPw().equals(pw)) {
					JOptionPane.showInternalMessageDialog(null, "정보가 일치하지 않습니다.");
				} else {
					new MemberUpdate(id,name);
					dispose();
				}
			}
		});
		
//		메인 버튼
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MemberLogin(id, name);
			}
		});
		
//		로그아웃 버튼
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?","로그아웃",JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					dispose();
					new Main();
				}
			}
		});
		
//		탈퇴 버튼
		btnMemberDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mvo = dao.memberSearch(id); 
				String pw = JOptionPane.showInputDialog(null, "회원 탈퇴를 위해 비밀번호를 입력하세요.");
				if(!mvo.getPw().equals(pw)) {
					JOptionPane.showInternalMessageDialog(null, "정보가 일치하지 않습니다.");
				} else {
					int res = dao.memberDelete(id);
					System.out.println(res);
					if(res == 0) {
						JOptionPane.showMessageDialog(null, "회원 탈퇴에 실패하셨습니다");
					} else {
						res = dao.shoppingDelete(id);
						if(res == 0) {
							JOptionPane.showMessageDialog(null, "구매 목록 삭제 오류");
						} else {
							res = dao.requlstDelete(id);
							if(res != 0) {
								JOptionPane.showMessageDialog(null, "회원 탈퇴되었습니다");
								dispose();
								new Main();
							}
						}
						
					}
				}
			}
		});
	}
}
