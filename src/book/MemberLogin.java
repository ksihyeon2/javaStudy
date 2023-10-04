package book;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MemberLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookName;
	private JButton btnNewButton,btnSearch,btnBuy,btnBookList;
	private JMenuItem menuMypage, menuExit;
	private JTable table;
	private JScrollPane scrollPane;
	
	@SuppressWarnings("rawtypes")
	Vector title, vData;
	DefaultTableModel dtm;
	
	DAO dao = new DAO();
	BookVO bvo;
	BookUpdateVO bUpdatevo;
	Object value;

	@SuppressWarnings("unchecked")
	public MemberLogin(String id,String name) {
		setVisible(true);
		setSize(1000,790);
		contentPane = new JPanel();
		setTitle("home");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
//		JPanel     -----------------------------------------------------------
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 399, 728);
		contentPane.add(pn1);
		pn1.setLayout(null);

		JPanel pn2 = new JPanel();
		pn2.setBounds(398, 0, 586, 728);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
//		JMenu     -----------------------------------------------------------
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("메뉴");
		menuBar.add(mnNewMenu);
		
		menuMypage = new JMenuItem("마이페이지");
		mnNewMenu.add(menuMypage);
		
//		메뉴 마이페이지
		menuMypage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MemberMypage(id,name);
			}
		});
		
		menuExit = new JMenuItem("종료");
		mnNewMenu.add(menuExit);

//		JMenu     -----------------------------------------------------------
		txtBookName = new JTextField();
		txtBookName.setBounds(116, 10, 192, 24);
		pn1.add(txtBookName);
		txtBookName.setColumns(10);
		
//		JComboBox     -----------------------------------------------------------
		JComboBox cbTitle = new JComboBox();
		cbTitle.setModel(new DefaultComboBoxModel(new String[] {"선택", "제목", "카테고리", "저자"}));
		cbTitle.setBounds(12, 10, 92, 24);
		pn1.add(cbTitle);
		
		JLabel lblCover = new JLabel("");
		lblCover.setHorizontalAlignment(SwingConstants.CENTER);
		lblCover.setBounds(12, 53, 562, 329);
		pn2.add(lblCover);
		
		JLabel lbl1 = new JLabel("제목 :");
		lbl1.setFont(new Font("굴림", Font.BOLD, 14));
		lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl1.setBounds(12, 394, 66, 33);
		pn2.add(lbl1);
		
		JLabel lblBookName = new JLabel("");
		lblBookName.setHorizontalAlignment(SwingConstants.LEFT);
		lblBookName.setBounds(90, 392, 198, 33);
		pn2.add(lblBookName);
		
		JLabel lblWriter = new JLabel("");
		lblWriter.setHorizontalAlignment(SwingConstants.LEFT);
		lblWriter.setBounds(412, 392, 162, 33);
		pn2.add(lblWriter);
		
		JLabel lbl2 = new JLabel("저자 :");
		lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl2.setFont(new Font("굴림", Font.BOLD, 14));
		lbl2.setBounds(311, 392, 66, 33);
		pn2.add(lbl2);
		
		JLabel lbl3 = new JLabel("출판사 :");
		lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl3.setFont(new Font("굴림", Font.BOLD, 14));
		lbl3.setBounds(12, 437, 66, 33);
		pn2.add(lbl3);
		
		JLabel lblCompany = new JLabel("");
		lblCompany.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompany.setBounds(90, 435, 198, 33);
		pn2.add(lblCompany);
		
		JLabel lbl4 = new JLabel("출판일 :");
		lbl4.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl4.setFont(new Font("굴림", Font.BOLD, 14));
		lbl4.setBounds(311, 435, 66, 33);
		pn2.add(lbl4);
		
		JLabel lblPublication = new JLabel("");
		lblPublication.setHorizontalAlignment(SwingConstants.LEFT);
		lblPublication.setBounds(412, 435, 162, 33);
		pn2.add(lblPublication);
		
		JLabel lbl6 = new JLabel("가격 :");
		lbl6.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl6.setFont(new Font("굴림", Font.BOLD, 14));
		lbl6.setBounds(311, 480, 66, 33);
		pn2.add(lbl6);
		
		JLabel lbl5 = new JLabel("평점 :");
		lbl5.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl5.setFont(new Font("굴림", Font.BOLD, 14));
		lbl5.setBounds(12, 482, 66, 33);
		pn2.add(lbl5);
		
		JLabel lblGrade = new JLabel("");
		lblGrade.setHorizontalAlignment(SwingConstants.LEFT);
		lblGrade.setBounds(90, 480, 198, 33);
		pn2.add(lblGrade);
		
		JLabel lblPrice = new JLabel("");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setBounds(412, 480, 162, 33);
		pn2.add(lblPrice);
		
		JLabel lbl7 = new JLabel("책소개 :");
		lbl7.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl7.setFont(new Font("굴림", Font.BOLD, 14));
		lbl7.setBounds(12, 526, 66, 33);
		pn2.add(lbl7);
		
		JLabel lblData = new JLabel("책 정보");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("굴림", Font.BOLD, 20));
		lblData.setBounds(12, 10, 562, 33);
		pn2.add(lblData);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(90, 526, 484, 143);
		pn2.add(scrollPane_1);
		
		JTextArea txtReview = new JTextArea();
		txtReview.setLineWrap(true);
		scrollPane_1.setViewportView(txtReview);
		
		btnNewButton = new JButton("책 신청하기");
		btnNewButton.setBounds(278, 692, 109, 26);
		pn1.add(btnNewButton);
		
		btnBuy = new JButton("구매하기");
		btnBuy.setBounds(482, 691, 92, 26);
		pn2.add(btnBuy);
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(323, 10, 64, 24);
		pn1.add(btnSearch);
		
		btnBookList = new JButton("전체 보기");
		btnBookList.setBounds(157, 692, 109, 26);
		pn1.add(btnBookList);
//		-------------------------------------------------------------------    //
		title = new Vector<>();
		title.add("카테고리");
		title.add("책제목");
		title.add("저자");
		title.add("평점");

		vData = dao.getBookList();

		dtm = new DefaultTableModel(vData, title);
	
		table = new JTable(dtm);
	
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 50, 375, 629);

		pn1.add(scrollPane);
		
//		-------------------------------------------------------------------------
		
//		사진, 정보 띄우기
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				lblCover.setIcon(null);
//				lblCover.setText("");
				int row = table.getSelectedRow();				
				value = table.getValueAt(row,1);
				bvo = dao.BookSearch(value.toString());
				if(!bvo.getCover().equals("<사진을 등록하세요>")){
					lblCover.setIcon(new ImageIcon(getClass().getResource(bvo.getCover())));
				} else {
					lblCover.setText(bvo.getCover());
				}
				lblBookName.setText(bvo.getBookname());
				lblWriter.setText(bvo.getWriter());
				lblCompany.setText(bvo.getCompany());
				lblPublication.setText(bvo.getPublication());
				lblGrade.setText(bvo.getGrade()+"");
				lblPrice.setText(bvo.getPrice()+"원");
				txtReview.setText(bvo.getReview());
			}
		});
		
//		구매 버튼
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(value == null) {
					JOptionPane.showMessageDialog(null, "구매를 원하시는 책을 선택하세요.");
				} else {
					new BookBuy(id,value);
				}
			}
		});
		
//		메뉴 종료
		menuExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);
				if (ans == 0) {
					System.exit(0);
				}
			}
		});
		
//		개별 검색 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookSearch = txtBookName.getText();
				if(cbTitle.getSelectedItem().equals("제목")) {
					vData = dao.getBookSearch("bookname",bookSearch);
				} else if(cbTitle.getSelectedItem().equals("카테고리")) {
					vData = dao.getBookSearch("category", bookSearch);
				} else if(cbTitle.getSelectedItem().equals("저자")) {
					vData = dao.getBookSearch("writer", bookSearch);
				}
				dtm.setDataVector(vData, title);
			}
		});
		
//		전체 목록 보기 버튼
		btnBookList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					vData = dao.getBookList();
					dtm.setDataVector(vData, title);
			}
		});
		
//		책 신청 버튼 (사용자)
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bookname = JOptionPane.showInputDialog(null, "등록을 원하시는 책의 제목을 입력하세요.");
				if (bookname.equals("")) {
				JOptionPane.showMessageDialog(null, "등록 신청을 원하시는 책 제목을 입력하세요");
				} else {
//					등록 여부 확인
					bvo = dao.BookSearch(bookname);
					if(bvo.getBookname() != null) {
						JOptionPane.showMessageDialog(null, "이미 등록되어 있는 책입니다.");
					} else {
						bUpdatevo = dao.BookUpdateSearch(bookname);
						if(bUpdatevo.getBookname() != null) {
							JOptionPane.showMessageDialog(null, "이미 신청등록 되어 있습니다.");
						} else {
							bUpdatevo.setBookname(bookname);
							bUpdatevo.setId(id);
							bUpdatevo.setName(name);
							int res = dao.BookUpdate(bUpdatevo);
							if(res == 0) {
								JOptionPane.showMessageDialog(null, "신청 실패");
							} else {
								JOptionPane.showMessageDialog(null, "신청 성공");
							}
						}
					}
				}
			}	
		});
	}
}
