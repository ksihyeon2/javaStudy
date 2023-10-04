package book;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Color;

@SuppressWarnings("serial")
public class SuperPage extends JFrame {

	private JPanel contentPane;
	private JButton btnBookInPut,btnBookUpdate,btnMemberList,btnMemberSearch,btnNewBook;
	private JMenuItem menuExit,menumemberpage;
	private JScrollPane scrBookUpdateList,scrBookList,scrMember;
	private JTable btlBookUpdateList,tblBookList,tblMember;
	private JTextField txtMember;
	private JComboBox cbMember;
	
	DefaultTableModel dtm;
	Vector title, vData;
	Object value;
	
	DAO dao = new DAO();
	BookVO bvo;
	ArrayList<BookVO> vos = new ArrayList<>();
	String bookname = "";
	
	@SuppressWarnings("unchecked")
	public SuperPage(String id, String rating) {
		setVisible(true);
		setSize(1000,790);
		contentPane = new JPanel();
		setTitle("관리자 home");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
//		Menu     -----------------------------------------------------------
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("메뉴");
		menuBar.add(mnNewMenu);
		
		menumemberpage = new JMenuItem("회원 페이지 이동");
		mnNewMenu.add(menumemberpage);
		
		menuExit = new JMenuItem("종료");
		mnNewMenu.add(menuExit);

//		JPanel     -----------------------------------------------------------
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 66, 984, 662);
		contentPane.add(pn1);
		pn1.setLayout(null);

		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 0, 984, 65);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lbl3 = new JLabel("등록 요청 목록");
		lbl3.setHorizontalAlignment(SwingConstants.LEFT);
		lbl3.setFont(new Font("굴림", Font.BOLD, 16));
		lbl3.setBounds(12, 352, 150, 26);
		pn1.add(lbl3);
		
		JLabel lbl4 = new JLabel("등록된 목록");
		lbl4.setHorizontalAlignment(SwingConstants.LEFT);
		lbl4.setFont(new Font("굴림", Font.BOLD, 16));
		lbl4.setBounds(493, 352, 150, 26);
		pn1.add(lbl4);
		
		JLabel lbl5 = new JLabel("관리페이지");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("굴림", Font.BOLD, 20));
		lbl5.setBounds(0, 0, 984, 65);
		pn2.add(lbl5);
	
//		JComboBox     -----------------------------------------------------------
		vos = dao.bookcoverList();
		String[] coverList = new String[vos.size()];
		String[] reviewList = new String[vos.size()];
		int covercnt = 0;
		int reviewcnt = 0;
		for(BookVO v : vos) {
			if(v.getCover().equals("<사진을 등록하세요>")) {
				coverList[covercnt] = v.getBookname();
				covercnt++; 
			} else if(v.getReview().equals("<서평을 입력하세요>")) {
				reviewList[reviewcnt] = v.getBookname();
				reviewcnt++;
			}
		}
		
		cbMember = new JComboBox();
		cbMember.setModel(new DefaultComboBoxModel(new String[] {"선택", "성명", "아이디"}));
		cbMember.setFont(new Font("굴림", Font.PLAIN, 14));
		cbMember.setBounds(12, 12, 72, 35);
		pn1.add(cbMember);
//		JTable     -----------------------------------------------------------
//		등록 요청건 표시
		title = new Vector<>();
		title.add("회원 아이디");
		title.add("책 이름");
		
		vData = dao.getrequest();

		dtm = new DefaultTableModel(vData,title);
		
		btlBookUpdateList = new JTable(dtm);
		
		scrBookUpdateList = new JScrollPane(btlBookUpdateList);
		scrBookUpdateList.setBounds(12, 388, 469, 206);
		
		pn1.add(scrBookUpdateList);
		
//		현재 등록되어 있는 책 목록
		title = new Vector<>();
		title.add("카테고리");
		title.add("책제목");
		title.add("저자");
		title.add("평점");

		vData = dao.getBookList();

		dtm = new DefaultTableModel(vData, title);
	
		tblBookList = new JTable(dtm);
	
		scrBookList = new JScrollPane(tblBookList);
		scrBookList.setBounds(493, 388, 479, 206);

		pn1.add(scrBookList);
		
//		가입되어 있는 회원 등록
		title = new Vector<>();
		title.add("번호");
		title.add("아이디");
		title.add("비밀번호");
		title.add("성명");
		title.add("성별");
		title.add("나이");
		title.add("이메일");
		title.add("전화번호");
		title.add("주소");
		title.add("가입일");
		title.add("등급");
		title.add("포인트");
		
		vData = dao.getMemberList();
		
		dtm = new DefaultTableModel(vData, title);
		
		tblMember = new JTable(dtm);
		
		scrMember = new JScrollPane(tblMember);
		scrMember.setBounds(12, 57, 960, 272);
		
		pn1.add(scrMember);
		
	
		
//		JTextField     -----------------------------------------------------------
		txtMember = new JTextField();
		txtMember.setColumns(10);
		txtMember.setBounds(96, 12, 255, 35);
		pn1.add(txtMember);
		
//		JButton     -----------------------------------------------------------
		btnBookInPut = new JButton("요청건 등록");
		btnBookInPut.setBounds(331, 606, 150, 35);
		pn1.add(btnBookInPut);
		
		btnBookUpdate = new JButton("수정하기");
		btnBookUpdate.setBounds(822, 606, 150, 35);
		pn1.add(btnBookUpdate);
		
		btnMemberSearch = new JButton("검색");
		btnMemberSearch.setBounds(363, 12, 84, 35);
		pn1.add(btnMemberSearch);
		
		btnMemberList = new JButton("전체검색");
		btnMemberList.setBounds(459, 12, 84, 35);
		pn1.add(btnMemberList);
		
		btnNewBook = new JButton("새 책 등록");
		btnNewBook.setBounds(169, 606, 150, 35);
		pn1.add(btnNewBook);
		
//		JButton     -----------------------------------------------------------
//		요청 책 등록하기
		btnBookInPut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = btlBookUpdateList.getSelectedRow();
				value = btlBookUpdateList.getValueAt(row, 1);
//				선택 안 했을때 메세지 뜨는거 확인하셈
				if(value == null) {
					JOptionPane.showMessageDialog(null, "등록하실 책을 선택하세요");
				} else {
					dispose();
					new BookUpdate(id,rating,value);
				}
			}
		});
		
//		새 책 등록
		btnNewBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BookNewUpdate(id,rating);
			}
		});
		
//		개별 조건 검색 버튼
		btnMemberSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String Member = txtMember.getText();
				if (Member.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "검색하실 내용을 입력하세요.");
					txtMember.requestFocus();
				} 
				
				if (cbMember.getSelectedItem().equals("아이디")) {
					vData = dao.getMemberSearch("id",Member);
				} else if(cbMember.getSelectedItem().equals("성명")) {
					vData = dao.getMemberSearch("name", Member);
				}
				
				dtm.setDataVector(vData, title);
			}
		});
		
//		전체 조회 버튼
		btnMemberList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vData = dao.getMemberList();
				dtm.setDataVector(vData, title);
			}
		});
		
//		수정 버튼
		btnBookUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = tblBookList.getSelectedRow();
				value = tblBookList.getValueAt(row, 1);
				dispose();
				new BookModify(id,rating,value);
			}
		});
		
//		메뉴 사용자 페이지 이동
		menumemberpage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MemberLogin(id, rating);
			}
		});
		
//		메뉴 종료 버튼
		menuExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "로그아웃",JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					System.exit(0);
				}
			}
		});
	}
}
