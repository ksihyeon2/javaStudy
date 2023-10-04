package book;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class MemberCart extends JFrame {

	private JPanel contentPane;
	private JButton btnBack,btnNewButton;
	private JTable tlbList;
	private JScrollPane scrList;
	
	Vector title,vData;
	DefaultTableModel dtm;
	
	DAO dao = new DAO();
	
	public MemberCart(String id, String name) {
		setVisible(true);
		setSize(834,451);
		contentPane = new JPanel();
		setTitle(name + "님의 장바구니");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
//		JPanel     -----------------------------------------------------------
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 818, 59);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 353, 818, 59);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
//		JScrollPane     -----------------------------------------------------------
//		title = new Vector<>();
//		title.add("표지");
//		title.add("카테고리");
//		title.add("제목");
//		title.add("가격");
//		
//		vData = dao.
		
		scrList = new JScrollPane();
		scrList.setBounds(0, 57, 818, 297);
		contentPane.add(scrList);
		
		tlbList = new JTable();
		scrList.setViewportView(tlbList);
		
		JCheckBox cbList = new JCheckBox("New check box");
		scrList.setRowHeaderView(cbList);
		
//		JLabel     -----------------------------------------------------------
		JLabel lbl1 = new JLabel("장 바 구 니");
		lbl1.setFont(new Font("굴림", Font.BOLD, 16));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(74, 0, 656, 59);
		pn1.add(lbl1);
		
		JLabel lbl2 = new JLabel("합계 : ");
		lbl2.setFont(new Font("굴림", Font.BOLD, 14));
		lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl2.setBounds(180, 0, 133, 59);
		pn2.add(lbl2);
		
//		총 합계
		JLabel lblTotal = new JLabel("New label");
		lblTotal.setFont(new Font("굴림", Font.PLAIN, 14));
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setBounds(325, 0, 105, 59);
		pn2.add(lblTotal);
		
//		JButton     -----------------------------------------------------------
		btnBack = new JButton("<");
		btnBack.setBounds(12, 12, 50, 36);
		pn1.add(btnBack);
		
		
		btnNewButton = new JButton("구매하기");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 14));
		btnNewButton.setBounds(438, 10, 188, 39);
		pn2.add(btnNewButton);
		
		
//		------------------------------------------------------------------
//		JButton     -----------------------------------------------------------
//		뒤로 가기 버튼
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MemberMypage(id,name);
			}
		});
	}
}
