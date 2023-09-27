		package book;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
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
public class superPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookName;
	private JButton btnPhotoUpdate,btnSearch;
	private JMenuItem menumember, menubuylist, menuExit;
	@SuppressWarnings("rawtypes")
//	private Vector title, vData;
	private DefaultTableModel defaultTableModel;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtPhoto;
	
	DAO dao = new DAO();
	BookVO bvo;
	ArrayList<BookVO> vos = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public superPage(String id, String rating) {
		setVisible(true);
		setSize(1000,790);
		contentPane = new JPanel();
		setTitle("관리자 home");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("메뉴");
		menuBar.add(mnNewMenu);
		
		menumember = new JMenuItem("회원 관리");
		mnNewMenu.add(menumember);
		
		menubuylist = new JMenuItem("주문 목록");
		mnNewMenu.add(menubuylist);
		
		JMenuItem menuUpdate = new JMenuItem("등록 요청 목록");
		mnNewMenu.add(menuUpdate);
		
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
		
		JComboBox cbTitle = new JComboBox();
		cbTitle.setModel(new DefaultComboBoxModel(new String[] {"책 제목", "카테고리", "저자"}));
		cbTitle.setBounds(12, 10, 92, 24);
		pn2.add(cbTitle);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(398, 0, 586, 728);
		contentPane.add(pn3);
		pn3.setLayout(null);

		btnPhotoUpdate = new JButton("사진 등록하기");
		btnPhotoUpdate.setBounds(452, 98, 122, 26);
		pn3.add(btnPhotoUpdate);
		
		JLabel lblNewLabel = new JLabel("사진 등록");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(12, 24, 122, 26);
		pn3.add(lblNewLabel);
		
		txtPhoto = new JTextField();
		txtPhoto.setBounds(12, 99, 428, 26);
		pn3.add(txtPhoto);
		txtPhoto.setColumns(10);
				
//		-------------------------------------------------------------
	
		vos = dao.bookcoverList();
		String[] coverList = new String[vos.size()];
		int cnt = 0;
		for(BookVO v : vos) {
			if(v.getCover().equals("<사진을 등록하세요>")) {
				coverList[cnt] = v.getBookname();
			}
		}
			
		JComboBox cbUpdateBook = new JComboBox(coverList);
		cbUpdateBook.setBounds(12, 65, 120, 24);
		pn3.add(cbUpdateBook);
		
//		-------------------------------------------------------------
//		사진 등록하기
		btnPhotoUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

//   cbbox 선택 지정
		cbUpdateBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bvo.setBookname(cbUpdateBook.getSelectedItem().toString());
			}
		});
	}
}
