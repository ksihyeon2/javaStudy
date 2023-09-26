package book;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class memberLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookName;
	
	bookVO bvo = new bookVO();

	public memberLogin() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,650);
		contentPane = new JPanel();
//		이름 정해서 수정
		setTitle("책");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 984, 34);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 33, 399, 578);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		txtBookName = new JTextField();
		txtBookName.setBounds(116, 10, 192, 24);
		pn2.add(txtBookName);
		txtBookName.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(323, 10, 64, 24);
		pn2.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 46, 375, 522);
		pn2.add(scrollPane);
		
		
		JComboBox cbTitle = new JComboBox();
		cbTitle.setModel(new DefaultComboBoxModel(new String[] {"책 제목", "카테고리", "저자"}));
		cbTitle.setBounds(12, 10, 92, 24);
		pn2.add(cbTitle);
		
		JTextArea txtBookList = new JTextArea();
		scrollPane.setViewportView(txtBookList);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(398, 33, 586, 578);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
//		---------------------------------------------------------------------------   //
//		검색 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if(cbTitle.getSelectedItem().equals("책 제목")) {
//					txtBookList.setText(bvo.getBookname());
//				} else if (cbTitle.getSelectedItem().equals("카테고리")) {
//					txtBookList.setText(bvo.getCategory());
//				} else {
//					txtBookList.setText(bvo.getWriter());
//				}
			}
		});
	}
}
