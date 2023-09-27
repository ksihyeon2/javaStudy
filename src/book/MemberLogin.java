		package book;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

@SuppressWarnings("serial")
public class MemberLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookName;
	private JButton btnNewButton,btnSearch,btnCart,btnBuy;
	private JMenuItem menuMypage, menuCart, menuExit;
	@SuppressWarnings("rawtypes")
	private Vector title, vData;
	private DefaultTableModel defaultTableModel;
	private JTable table;
	private JScrollPane scrollPane;
	
	DAO dao = new DAO();
	BookVO bvo;
	BookUpdateVO bUpdatevo;

	@SuppressWarnings("unchecked")
	public MemberLogin(String id,String name) {
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,790);
		contentPane = new JPanel();
		setTitle("home");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("메뉴");
		menuBar.add(mnNewMenu);
		
		menuMypage = new JMenuItem("마이페이지");
		mnNewMenu.add(menuMypage);
		
		menuCart = new JMenuItem("장바구니");
		mnNewMenu.add(menuCart);
		
		menuExit = new JMenuItem("종료");
		mnNewMenu.add(menuExit);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 0, 399, 728);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		txtBookName = new JTextField();
		txtBookName.setBounds(116, 10, 192, 24);
		pn2.add(txtBookName);
		txtBookName.setColumns(10);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(12, 46, 375, 636);
//		pn2.add(scrollPane);
		
//		table = new JTable();
//		scrollPane.setViewportView(table);
		
		JComboBox cbTitle = new JComboBox();
		cbTitle.setModel(new DefaultComboBoxModel(new String[] {"책 제목", "카테고리", "저자"}));
		cbTitle.setBounds(12, 10, 92, 24);
		pn2.add(cbTitle);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(398, 0, 586, 728);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JLabel lblCover = new JLabel("책 표지");
		lblCover.setHorizontalAlignment(SwingConstants.CENTER);
		lblCover.setBounds(12, 10, 562, 329);
		pn3.add(lblCover);
		
		JLabel lblNewLabel = new JLabel("제목 :");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(12, 351, 66, 33);
		pn3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("제목");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(90, 349, 198, 33);
		pn3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("제목");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(412, 349, 162, 33);
		pn3.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("저자 :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_2.setBounds(311, 349, 66, 33);
		pn3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("출판사 :");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(12, 394, 66, 33);
		pn3.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("제목");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(90, 392, 198, 33);
		pn3.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("출판일 :");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(311, 392, 66, 33);
		pn3.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("제목");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(412, 392, 162, 33);
		pn3.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("가격");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(311, 437, 66, 33);
		pn3.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("평점 :");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(12, 439, 66, 33);
		pn3.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("제목");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setBounds(90, 437, 198, 33);
		pn3.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("제목");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setBounds(412, 437, 162, 33);
		pn3.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("서평 :");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(12, 483, 66, 33);
		pn3.add(lblNewLabel_2_1_1_1);
		
//		JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane_1.setBounds(100, 489, 474, 192);
//		pn3.add(scrollPane_1);
		
		btnNewButton = new JButton("책 신청하기");
		btnNewButton.setBounds(278, 692, 109, 26);
		pn2.add(btnNewButton);
		
		btnCart = new JButton("담기");
		btnCart.setBounds(389, 691, 73, 26);
		pn3.add(btnCart);
		
		btnBuy = new JButton("구매하기");
		btnBuy.setBounds(482, 691, 92, 26);
		pn3.add(btnBuy);
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(323, 10, 64, 24);
		pn2.add(btnSearch);
		
//		-------------------------------------------------------------------    //
		title = new Vector<>();
		title.add("카테고리");
		title.add("책제목");
		title.add("저자");
		title.add("평점");

		vData = dao.getBookList();

		defaultTableModel = new DefaultTableModel(vData, title);
	
		table = new JTable(defaultTableModel);
	
		scrollPane =new JScrollPane(table);
		scrollPane.setBounds(12, 50, 375, 629);

		pn2.add(scrollPane);
		
//		-------------------------------------------------------------------------
		
//		사진, 정보 띄우기
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();				
				Object value = table.getValueAt(row,1);
//				new Service(value);
			}
		});
		
//		메뉴 마이페이지
		menuMypage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MemberMypage(id,name);
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
		
//		검색 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookname = txtBookName.getText();
				bvo = dao.BookSearch(bookname);
				if(bvo.getBookname() == null) {
					JOptionPane.showMessageDialog(null, "검색하신 책이 없습니다.");
					txtBookName.requestFocus();
				} else {
//					
				}
			}
		});
		
//		책 신청 버튼 (사용자)
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bookname = JOptionPane.showInputDialog(null, "등록을 원하시는 책의 제목을 입력하세요.");
				if (bookname.equals("")) {
				JOptionPane.showMessageDialog(null, "등록 신청을 원하시는 책 제목을 입력하세요");
				txtBookName.requestFocus();
				} else {
//					이미 등록되어 있는지 확인
					bvo = dao.BookSearch(bookname);
					if(bvo.getBookname() != null) {
						JOptionPane.showMessageDialog(null, "이미 등록되어 있는 책입니다.");
					} else {
//						------------------------------------- 중복 확인
							bUpdatevo = dao.BookUpdateSearch(bookname);
							if(bUpdatevo.getBookname() != null) {
								JOptionPane.showMessageDialog(null, "이미 신청등록 되어 있습니다.");
							} else {
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
